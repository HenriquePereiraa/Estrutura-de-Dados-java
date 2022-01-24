package tad.arvore;

public class NoBinario<T extends Comparable> {
	
	T info;
	
	NoBinario<T> esquerda, direita;
	
	public NoBinario(T _info) {
		this.info = _info;
	}
	
	public String toString() {
		return "" + info;
	}
}
