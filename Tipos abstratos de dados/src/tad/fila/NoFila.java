package tad.fila;

public class NoFila<Tipo> {
	
	Tipo value;
	NoFila<Tipo> next;
	
	public NoFila(Tipo _value) {
		this.value = _value;
	}

}
