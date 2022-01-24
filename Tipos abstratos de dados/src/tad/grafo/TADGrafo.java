package ecomp.tad.grafo;

import java.util.Iterator;

public interface TADGrafo<Tipo> {
	
	int numVertices();
	int numArestas();
	int grau(Vertice v);
	Iterator<Vertice<Tipo>> verticesAdjacentes(Vertice<Tipo> v);
	Iterator<Aresta<Tipo>> arestasIncidentes(Vertice<Tipo> v);
	boolean saoAdjacentes(Vertice<Tipo> v, Vertice<Tipo> w);
	void insereVertice(Vertice<Tipo> v);
	void insereAresta(Vertice<Tipo> v, Vertice<Tipo> w);
	void removeVertice(Vertice<Tipo> v);
	void removeAresta(Aresta<Tipo> e);
}
