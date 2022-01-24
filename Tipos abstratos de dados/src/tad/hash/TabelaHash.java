package tad.hash;

public interface TabelaHash<T> {
	
	public void add(T elemento);
	
	public void remove(T elemento);
	
	public boolean procurar(T elemento);
	
	public void print();

}
