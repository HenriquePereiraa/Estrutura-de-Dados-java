package tad.lista;

public class ListaLigadaDuplaExtremidade<Tipo> extends ListaLigada<Tipo> implements Lista<Tipo> {
	
	private NoList<Tipo> fim;
	
	
	public void inserir(Tipo novo) {
		NoList<Tipo> novoNo = new NoList<Tipo>(novo);
		
		if(inicio == null) {
			inicio = novoNo;
		} else {
			fim.next = novoNo;
		}
		
		fim = novoNo;
		
		this.qdt++;
	}
	
	public boolean remover(Tipo elemento) {
		boolean response = false;
		
		if(inicio  != null) {
			if(inicio.info.equals(elemento)) {
				inicio = inicio.next;
				if(inicio == null) { 
					fim = null;
				}
			} else {
				NoList<Tipo> aux = inicio;
				while(aux.next != null) {
					if(aux.next.info.equals(elemento)) {
						aux = aux.next.next;
						this.qdt--;
						response = true;
						if(aux.next == null) {
							fim = aux;
						}
						break;
					}
					aux = aux.next;
				}
			}
		}
		
		return response;
	}

}
