package tad.pilha;

public interface TADPilha<Tipo> {
	
	public void push(Tipo elemento);
	
	public Tipo pop();
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public int size();
	
	public Tipo top();
	
	public void print();
}
