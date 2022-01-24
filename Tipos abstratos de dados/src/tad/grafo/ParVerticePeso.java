package ecomp.tad.grafo;

public class ParVerticePeso<Tipo> {
	
	Vertice<Tipo> v;
	float peso;
	
	public ParVerticePeso(Vertice<Tipo> w, float peso) {
		v = w;
		this.peso = peso;
	}

	public boolean equals(Object o) {
		boolean r = false;
		if(o instanceof Vertice) {
			return v.equals(o);
		} else if(o instanceof ParVerticePeso) {
			return v.equals(((ParVerticePeso)o).v);
		}
		
		return r;
	}
}
