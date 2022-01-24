package tad.lista;


public class ListaEstaticaOrdenada<T extends Comparable> implements Lista<T> {
	private Comparable[] vetor;
	private int qtd;
	
	public ListaEstaticaOrdenada() {
		this.vetor = new Comparable[3];
	}
	
	public void inserir(T novo) {
		if (indexOf(novo) == -1) {
			if (qtd == vetor.length) {
				// vetor está cheio, expandindo a memoria manualmente
				Comparable[] temp = new Comparable[qtd*2];
				for (int i = 0; i < qtd; i++) {
					temp[i] = vetor[i];
				}
				vetor = temp;
			} 
			
			int i=qtd-1;
			while (i>=0 && vetor[i].compareTo(novo) > 0) {
				vetor[i+1] = vetor[i];
				i--;
			}
			vetor[i+1] = novo;
			qtd++;
		}
	}

	public boolean remover(T e) {
		boolean r = false;
		int index = indexOf(e);
		if (index != -1) {
			r = true;
			while (index < qtd-1) {
				vetor[index] = vetor[index+1];
				index++;
			}
			vetor[index] = null;
			qtd--;
		}
		return r;
	}

	public T consultar(int index) {
		if (index < qtd) 
			return (T) vetor[index];
		else 
			return null;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < qtd; i++) {
			s += " -> " + vetor[i];
		}
		return s;
	}

	public void print() {
		System.out.println(this);
	}

	public int indexOf(T e) {
		int r = -1;
		int left=0, right=qtd-1;
		int meio;
		while (left <= right) {
			meio = (right+left) / 2;
			int flag = vetor[meio].compareTo(e);
			if (flag == 0) {
				// encontrei o elemento
				r = meio;
				break;
			} else if (flag < 0) {
				left = meio+1;
			} else {
				right = meio-1;
			}
		}
		return r;
	}
}
