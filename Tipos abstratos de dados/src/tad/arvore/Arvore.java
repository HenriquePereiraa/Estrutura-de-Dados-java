package tad.arvore;

public interface Arvore<T extends Comparable> {
	
	public void inserir(T elemento);
	
	public boolean remove(T elemento);
	
	public T consultar(T elemento);
	
	public boolean existe(T elemento);
	
	public void print();
}
