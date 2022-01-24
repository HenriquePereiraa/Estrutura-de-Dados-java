package ecomp.tad.grafo;

public class Vertice<Tipo> {
	
	Tipo info;
	
	public Vertice(Tipo _info) {
		this.info = _info;
	}

	public int hashCode() {
		return info.hashCode();
	}
	
	public boolean equals(Object o) {
		boolean r = false;
		
		if(o instanceof Vertice) {
			r = info.equals(((Vertice)o).info);	
		}
		
		return r;
	}
	
	public String toString() {
		return "" + info; 
	}

}
