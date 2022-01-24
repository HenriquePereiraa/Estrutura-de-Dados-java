package tad.pilha;

public class Node<Tipo> {
	
	Tipo info;
	Node<Tipo> next;
	
	public Node(Tipo elemento)
	{
		this.info = elemento;
	}
}
