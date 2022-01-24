package tad.pilha;

public class PilhaEstatica<Tipo> implements TADPilha<Tipo> {
	
	private Tipo[] datas;
	private int topo;
	
	public PilhaEstatica() {
		datas = (Tipo[]) new Object[10];
		topo = -1;
	}

	
	public void push(Tipo elemento) {
		if(topo < datas.length-1) {
			topo++;
			datas[topo] = elemento;
		} else {
			throw new RuntimeException("Pilha cheia!");
		}
	}

	
	public Tipo pop() {
		Tipo response = null;
		
		if(topo >= 0) {
			response = datas[topo];
			datas[topo] = null;
			topo--;
		} else {
			throw new RuntimeException("Pilha vazia!");
		}
		
		return response;
	}

	public boolean isEmpty() {
		return topo == -1;
	}

	
	public boolean isFull() {
		return topo == datas.length-1;
	}


	public int size() {
		return topo+1 ;
	}
	
	public Tipo top() {
		Tipo response = null;
		
		if(topo >= 0) {
			response = datas[topo];
		} else {
			throw new RuntimeException("Pilha vazia!");
		}
		
		return response;
	}
	
	public String toString() {
		String response = "Topo";
		
		if(! isEmpty()) {
			for(int i = topo; i >= 0; i--) {
				response += " -> " + datas[i];
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
