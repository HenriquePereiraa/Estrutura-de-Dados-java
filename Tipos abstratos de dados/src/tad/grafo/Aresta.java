package ecomp.tad.grafo;

public class Aresta<Tipo> {

	Vertice<Tipo> origem, destino;
	
	public Aresta(Vertice<Tipo> origem, Vertice<Tipo> destino) {
		this.origem = origem;
		this.destino = destino;
	}

	
}
