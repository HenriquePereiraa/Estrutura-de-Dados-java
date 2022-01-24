package tad.fila;

public class FilaDinamica<Tipo> implements TDAFila<Tipo> {
	
	private NoFila<Tipo> inicio, fim;
	private int qtd;

	
	public void inqueue(Tipo elemento) {
		NoFila<Tipo> novoElemento = new NoFila<Tipo>(elemento);
		
		if(inicio == null) {
			inicio = fim = novoElemento;
		} else {
			fim.next = novoElemento;
			fim = novoElemento;
		}
		
		qtd++;

	}

	
	public Tipo dequeue() {
		Tipo response = null;
		
		if(inicio != null) {
			response = inicio.value;
			inicio = inicio.next;
			
			if(inicio == null) {
				fim = null;
			}
			qtd--;
		}
				
		return response;
	}

	
	public Tipo consultarInicio() {
		
		Tipo response = null;
		
		if(inicio != null) {
			response = inicio.value;
		}
		
		return response;
	}

	
	public boolean isEmpty() {
		return this.qtd == 0;
	}

	public int size() {
		
		return this.qtd;
	}
	
	public String toString() {
		String s = "";
		NoFila<Tipo> copyList = inicio;
		
		while(copyList != null) {
			s += copyList.value + "\n";
			copyList = copyList.next;
		}
		
		return s;
	}
	
	public void print() {
		System.out.println(this);
	}

}
