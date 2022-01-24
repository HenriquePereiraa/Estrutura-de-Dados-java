package tad.fila;

public interface TDAFila<Tipo> {
	
	public void inqueue(Tipo elemento);
	
	public Tipo dequeue();
	
	public Tipo consultarInicio();
	
	public boolean isEmpty();
	
	public int size();
	
	public void print();

}
