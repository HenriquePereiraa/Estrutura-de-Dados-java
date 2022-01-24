package ecomp.tad.grafo;

import java.util.ArrayList;
import java.util.List;

public class GrafoMatrizAdjacencia<Tipo> {
	
	private List<Vertice<Tipo>> vertice;
	private float grafo[][];
	
	public GrafoMatrizAdjacencia(int n) {
		vertice = new ArrayList<Vertice<Tipo>>();
		grafo = new float[n][n];
	}
	
	
	
}
