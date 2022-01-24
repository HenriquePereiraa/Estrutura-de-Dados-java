package tad.lista;

public class ListaEstatica<Tipo> implements Lista<Tipo> {
	
	private Tipo[] values;
	private int qtd;
	
	public ListaEstatica(int tamanho) {
		values = (Tipo[]) new Object[tamanho];
	}
	
	
	public void inserir(Tipo novo) {
		if(qtd < values.length) {
			values[qtd] = novo;
		} else {
			Tipo[] temp = (Tipo[]) new Object[qtd*2];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = values[i];
			}
			values = temp;
			values[qtd] = novo;
		}
		qtd++;		
	}

	
	public boolean remover(Tipo elemento) {
		boolean response = false;
		int index = indexOf(elemento);
		
		if(index != -1) {
			while(index < qtd-1) {
				values[index] = values[index+1];
				index++;
			}
			values[index] = null;
			qtd--;	 
		}
		
		return false;
	}

	
	public Tipo consultar(int index) {
		if(index < qtd) {
			return values[index];
		} else {
			return null;			
		}
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < qtd; i++) {
			s += " -> " + values[i];
		}
		return s;
	}

	
	public void print() {
		System.out.println(this);

	}

	public int indexOf(Tipo elemento) {
		int response = -1;
		for (int i = 0; i < qtd; i++) {
			if(values[i].equals(elemento)) {
				response = i;
				break;
			}
		}
		return response;
	}

}
