package tad.lista;

public class NoList<Tipo> {
	
	Tipo info;
	NoList<Tipo> next;
	
	public NoList(Tipo _info) {
		this.info = _info;
	}
	
	public String toString() {
		return "" + info;
	}
}
