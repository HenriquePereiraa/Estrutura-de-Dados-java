package tad.fila;

public class FilaEstatica<Tipo> implements TDAFila<Tipo> {
	
	private Tipo[] vetor;
	private int front, back, qtd;
	
	public FilaEstatica(int tam) {
		vetor = (Tipo[]) new Object[tam];
	}

	
	public void inqueue(Tipo elemento) {
		if(qtd < vetor.length) {
			if(qtd == 0) {
				front = back = 0;
				vetor[back] = elemento;				
			} else {
//				back++;
//				if(back == vetor.length) {
//					back = 0;
//				}
				back = (back+1) % vetor.length;
				//4  =  4+1     % 5 = 0
				vetor[back] = elemento;
			}
			qtd++;
		} else {
			Tipo[] aux = (Tipo[]) new Object[qtd*2];
			for (int i = 0; i < qtd; i++) {
				aux[i] = vetor[(front+i)%vetor.length];
			}
			vetor = aux;
			front = 0;
			back = qtd;
			vetor[back] = elemento;
			qtd++;
		}

	}

	public Tipo dequeue() {
		Tipo response = null;
		
		if(qtd > 0) {
			response = vetor[front];
			vetor[front] = null;
			front = (front+1)%vetor.length;
			qtd--;
		}
		
		return response;
	}

	
	public Tipo consultarInicio() {
		Tipo response = null;
		
		if(qtd > 0) {
			response = vetor[front];
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
		
		for (int i = 0; i < vetor.length; i++) {
			s += vetor[(front+i)%vetor.length] + "\n";
		}
		
		return s;
	}
	public void print() {
		System.out.println(this);

	}

}
