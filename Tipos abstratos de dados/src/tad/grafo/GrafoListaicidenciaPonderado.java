package ecomp.tad.grafo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class GrafoListaicidenciaPonderado<Tipo> implements TADGrafo<Tipo> {
	
	private Hashtable<Vertice<Tipo>, List<ParVerticePeso<Tipo>>> grafo;
	private boolean isDirecionado;
	
	public GrafoListaicidenciaPonderado(boolean _isDirecionado) {
		this.grafo = new Hashtable<Vertice<Tipo>, List<ParVerticePeso<Tipo>>>();
		this.isDirecionado = _isDirecionado;
	}

	
	public int numVertices() {
		return grafo.size();
	}

	
	public int numArestas() {
		int total = 0;
		
		for (Enumeration<Vertice<Tipo>> vertices = grafo.keys(); vertices.hasMoreElements();) {
			Vertice<Tipo> vertice = (Vertice<Tipo>) vertices.nextElement();
			
			List<ParVerticePeso<Tipo>> adjacentes = grafo.get(vertice);
			
			total += adjacentes.size();
		}
		
		if(isDirecionado == false) {
			total = total / 2;
		}
		
		return total;
	}

	
	public int grau(Vertice v) {
		int total = 0;
		//se o grafo não é direcionado
		if(isDirecionado == false) {
			total = grauNegativo(v);
		} else {//Grafo direcionado
			//fazer em duas etapas
			
			total = grauNegativo(v) + grauPositivo(v);
		}
		
		return total;
	}

	private int grauPositivo(Vertice destino) {
		// grau positivo do vertice é que entra no vertice
		int total = 0;
		
		for (Enumeration<Vertice<Tipo>> vertices = grafo.keys(); vertices.hasMoreElements();) {
			Vertice<Tipo> vertice = (Vertice<Tipo>) vertices.nextElement();
			
			List<ParVerticePeso<Tipo>> adjacentes = grafo.get(vertice);
			
			if(adjacentes.contains(destino)) {
				total++;
			}
		}
		
		return total;
	}


	private int grauNegativo(Vertice v) {
		// grau negativo do vertice é que sai do vertice
		int total = 0;
		
		List<ParVerticePeso<Tipo>> adjacentes = grafo.get(v);
		
		if(adjacentes != null) {
			 total = adjacentes.size();
		}
		return total;
	}


	
	public Iterator<Vertice<Tipo>> verticesAdjacentes(Vertice<Tipo> origem) {
		
		List<ParVerticePeso<Tipo>> adjacentes = grafo.get(origem);
		List<Vertice<Tipo>> vertices = new ArrayList<Vertice<Tipo>>();		
		if(adjacentes != null) {
			for (int i = 0; i < adjacentes.size(); i++) {
				vertices.add(adjacentes.get(i).v);
			}
		}
		return vertices.iterator();
	}

	
	public Iterator<Aresta<Tipo>> arestasIncidentes(Vertice<Tipo> destino) {
		
		List<Aresta<Tipo>> arestas = new ArrayList<Aresta<Tipo>>();
		
		for (Enumeration<Vertice<Tipo>> vertices = grafo.keys(); vertices.hasMoreElements();) {
			Vertice<Tipo> vertice = (Vertice<Tipo>) vertices.nextElement();
			
			List<ParVerticePeso<Tipo>> adjacentes = grafo.get(vertice);
			
			if(adjacentes.contains(destino)) {
				Aresta<Tipo> aresta = new Aresta<Tipo>(vertice, destino);
				arestas.add(aresta);
			}
		}
		
		return arestas.iterator();
	}

	
	public boolean saoAdjacentes(Vertice<Tipo> v, Vertice<Tipo> w) {
		
		boolean resposta = false;
		
		List<ParVerticePeso<Tipo>> adjacentes = grafo.get(v);
		if(adjacentes != null && adjacentes.contains(w)) {
			resposta = true;
		}
		
		if(isDirecionado && resposta == false) {
			adjacentes = grafo.get(w);
			if(adjacentes != null && adjacentes.contains(v)) 
				resposta = true;
		}
		return resposta;
	}

	
	public void insereVertice(Vertice<Tipo> v) {
		if(!grafo.contains(v)) {
			grafo.put(v, new ArrayList<ParVerticePeso<Tipo>>());
		}
		
	}

	
	public void insereAresta(Vertice<Tipo> v, Vertice<Tipo> w, float peso) {
		//para garantir que v e w estão no grafo
		insereVertice(v);
		insereVertice(w);
		
		Vertice<Tipo> vNoGrafo = getVerticeOriginal(v);
		Vertice<Tipo> wNoGrafo = getVerticeOriginal(w);
		
		List<ParVerticePeso<Tipo>> adjacentes = grafo.get(vNoGrafo);
		if(adjacentes.contains(wNoGrafo) == false) {
			ParVerticePeso<Tipo> novo = new ParVerticePeso<Tipo>(wNoGrafo, peso);
			adjacentes.add(novo);
		}
		
		if(!isDirecionado) {
			adjacentes = grafo.get(wNoGrafo);
			if(adjacentes.contains(vNoGrafo) == false) {
				ParVerticePeso<Tipo> novo = new ParVerticePeso<Tipo>(vNoGrafo, peso);
				adjacentes.add(novo);
			}
		}
		
	}
	
	//metodo utilizado para resgatar o objeto na memoria do grafo
	private Vertice<Tipo> getVerticeOriginal(Vertice<Tipo> verticeBuscado) {
		
		Vertice<Tipo> resposta = null;
		
		if(grafo.containsKey(verticeBuscado)) {
			for (Enumeration<Vertice<Tipo>> vertices = grafo.keys(); vertices.hasMoreElements();) {
				Vertice<Tipo> vertice = (Vertice<Tipo>) vertices.nextElement();
				
				if(vertice.equals(verticeBuscado)) {
					resposta = vertice;
					break;
				}
			}
		}
		return resposta;
	}


	
	public void removeVertice(Vertice<Tipo> verticeParaRemover) {
		
		for (Enumeration<Vertice<Tipo>> vertices = grafo.keys(); vertices.hasMoreElements();) {
			Vertice<Tipo> vertice = (Vertice<Tipo>) vertices.nextElement();
			
			List<ParVerticePeso<Tipo>> adjacentes = grafo.get(vertice);
			
			if(adjacentes.contains(verticeParaRemover)) {
				adjacentes.remove(verticeParaRemover);
			}
		}
		
		grafo.remove(verticeParaRemover);
		
	}

	
	public void removeAresta(Aresta<Tipo> e) {
		
		List<ParVerticePeso<Tipo>> adjacentes = grafo.get(e.origem);
		if(adjacentes.contains(e.destino)) {
			adjacentes.remove(e.destino);
		}
		if(!isDirecionado) {
			adjacentes = grafo.get(e.destino);
			if(adjacentes.contains(e.origem)) {
				adjacentes.remove(e.origem);
			}
		}	
	}
	
	
	public void insereAresta(Vertice<Tipo> v, Vertice<Tipo> w) {
		insereAresta(v,w,0);
		
	}
}
