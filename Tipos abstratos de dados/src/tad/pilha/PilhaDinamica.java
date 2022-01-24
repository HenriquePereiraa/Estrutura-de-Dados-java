package tad.pilha;

public class PilhaDinamica<Tipo> implements TADPilha<Tipo> {
	
	private Node<Tipo> topo;
	private int qtd;

	
	public void push(Tipo elemento) {
		Node<Tipo> newValue = new Node<Tipo>(elemento);
		
		newValue.next = topo;
		topo = newValue;
		qtd++;
	}

	public Tipo pop() {
		Tipo response = null;
		
		if(! this.isEmpty()) {
			response = topo.info;
			topo = topo.next;
			qtd--;
		} else {
			throw new RuntimeException("Pilha vazia!");
		}
		
		return response;
	}

	public boolean isEmpty() {
		return topo == null;
	}

	public boolean isFull() {
		return false;
	}
	
	public int size() {
		return this.qtd;
	}
	
	public Tipo top() {
		Tipo response = null;
		
		if(! this.isEmpty()) {
			response = topo.info;
		} else {
			throw new RuntimeException("Pilha vazia!");
		}
		
		return response;
	}

	
	public String toString() {
		String response = "Topo";
		
		if(! this.isEmpty()) {
			Node<Tipo> aux = topo;
			while(aux != null) {
				response += " -> " + aux.info;
				aux = aux.next;
			}
		} else {
			response += " -> null";
		}
		
		
		return response;
	}
	
	public void print() {
		System.out.println(this);
	}

}
