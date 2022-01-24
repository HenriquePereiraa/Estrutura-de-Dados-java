package ecomp.tad.grafo;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		TADGrafo<String> grafo = new GrafoListaicidenciaPonderado<String>(true);
		
		
		grafo.insereAresta(new Vertice<String>("MAN"), new Vertice<String>("BSB"));
		grafo.insereAresta(new Vertice<String>("BSB"), new Vertice<String>("SAO"));
		grafo.insereAresta(new Vertice<String>("REC"), new Vertice<String>("BSB"));
		grafo.insereAresta(new Vertice<String>("SAO"), new Vertice<String>("RIO"));
		grafo.insereAresta(new Vertice<String>("REC"), new Vertice<String>("SAO"));
		grafo.insereAresta(new Vertice<String>("REC"), new Vertice<String>("SAL"));
		grafo.insereAresta(new Vertice<String>("SAL"), new Vertice<String>("RIO"));
		
		Iterator<Vertice<String>> adjacentes = grafo.verticesAdjacentes(new Vertice<String>("REC"));
		
		while(adjacentes.hasNext()) {
			System.out.println("-> " + adjacentes.next());
		}
		
	}

}
