package tad.lista;

public class ListaLigada<Tipo> implements Lista<Tipo> {
	
	protected NoList<Tipo> inicio;
	protected int qdt;
	
	public void inserir(Tipo novo) {
		NoList<Tipo> novoNo = new NoList<Tipo>(novo);
		
		if(inicio == null) {
			inicio = novoNo;
		} else {
			NoList<Tipo> aux = inicio;
			while(aux.next != null) {
				aux = aux.next;
			}
			
			aux.next = novoNo;
		}
		
		this.qdt++;
	}

	
	public boolean remover(Tipo elemento) {
		boolean response = false;
		
		if(inicio  != null) {
			if(inicio.info.equals(elemento)) {
				inicio = inicio.next;
			} else {
				NoList<Tipo> aux = inicio;
				while(aux.next != null) {
					if(aux.next.info.equals(elemento)) {
						aux = aux.next.next;
						this.qdt--;
						response = true;
						break;
					}
					aux = aux.next;
				}
			}
		}
		
		return response;
	}

	
	public Tipo consultar(int index) {
		
		if(index < qdt) {
			int count = 0;
			
			NoList<Tipo> aux = inicio;
			while(count != index) {
				aux = aux.next;
				count++;
			}
			
			return aux.info;
			
		} else {
			return null;
		}
		
		
	}
	
	public String toString() {
		String s = "";
		NoList<Tipo> aux = inicio;
		while(aux != null) {
			s += " -> " + aux;
			aux = aux.next;
		}
		
		return s;
	}

	
	public void print() {
		
		
		System.out.println(this.toString());

	}

	
	public int indexOf(Tipo elemento) {
		int count = 0;
		int response = -1;
		NoList<Tipo> aux = inicio;
		while(aux != null) {
			if(aux.info.equals(elemento)) {
				response = count;
				break;
			}
			
			aux = aux.next;
			count++;
		}
		return response;
	}
	
	public boolean find(Tipo elemento) {
		int count = 0;
		boolean response = false;
		NoList<Tipo> aux = inicio;
		while(aux != null) {
			if(aux.info.equals(elemento)) {
				response = true;
				break;
			}
			
			aux = aux.next;
			count++;
		}
		return response;
	}

}
