package tad.arvore;

public class ArvoreBinaria<T extends Comparable> implements Arvore<T> {
	
	protected NoBinario<Comparable> raiz;

	
	public void inserir(T elemento) {
		
		if(!existe(elemento)) {
			NoBinario<Comparable> novoNo = new NoBinario(elemento);
			
			if(raiz == null) {
				raiz = novoNo;
			} else {
				NoBinario<Comparable> aux = raiz;
				
				while(aux != null) {
					int flag = aux.info.compareTo(elemento);
					
					if(flag < 0) {
						if(aux.direita != null) {
							aux = aux.direita;
						} else {
							aux.direita = novoNo;
							break;
						}
					} else {
						if(aux.esquerda != null) {
							aux = aux.esquerda;
						} else {
							aux.esquerda = novoNo;
							break;
						}
					}
				}
			}
		}
	}

	
	public boolean remove(T elemento) {
		
		boolean response = false;
		
		if(raiz != null) {
			if(raiz.info.equals(elemento)) {
				if(raiz.esquerda == null) {
					raiz = raiz.direita;
				} else if(raiz.direita == null) {
					raiz = raiz.esquerda;
				} else {
					substituiRaizSubArvore(raiz);
				}
				response = true;
			} else {
				//Nó que preciso remover não é a raiz
				//localizar o nó na árvore
				
				NoBinario<Comparable> p = raiz;
				NoBinario<Comparable> paiP = p;
				while(p != null) {
					int flag = p.info.compareTo(elemento);
					if(flag == 0 ) {
						//nó a ser removido
						break;
					} else if(flag > 0) {
						paiP = p;
						p = p.esquerda;
					} else if(flag < 0) {
						paiP = p;
						p = p.direita;
					}
				}
				
				if(p != null) {
					//trata da remoção do nó p da arvore
					response = true;
					
					if(p.esquerda == null) {
						if(paiP.esquerda == p) {
							paiP.esquerda = p.direita;
						} else {
							paiP.direita = p.direita;
						}
					} else if(p.direita == null) {
						if(paiP.esquerda == p) {
							paiP.esquerda = p.esquerda;
						} else {
							paiP.direita = p.esquerda;
						}
					} else {
						substituiRaizSubArvore(p);
					}
				}
			}
		}
		return response;
	}


	private void substituiRaizSubArvore(NoBinario<Comparable> raizSubArvore) {
		//localizar o meno descendente à direita da raiz
		NoBinario<Comparable> aux = raizSubArvore.direita;
		NoBinario<Comparable> paiAux = aux;
		
		while(aux.esquerda != null) {
			paiAux = aux;
			aux = aux.esquerda;
		}
		//substitui a informação da raiz
		raizSubArvore.info = aux.info;
		if(aux != paiAux) {
			//remove o nó que substituiu a raiz
			paiAux.esquerda = aux.direita;						
		} else {
			raizSubArvore.direita = aux.direita;
		}
	}

	
	public T consultar(T elemento) {
		
		T response = null;
		
		NoBinario<Comparable> aux = raiz;
		while(aux != null) {
			int flag = aux.info.compareTo(elemento);
			
			if(flag == 0) {
				response = (T) aux.info;
				break;
			} else if(flag < 0) {
				aux = aux.direita;
			} else if(flag > 0) {
				aux = aux.esquerda;
			}
		}
		
		return response;
	}

	
	public boolean existe(T elemento) {
		return this.consultar(elemento) != null;	
	}
	
	private void percursoPreOrdem(NoBinario<Comparable> p) {
		if(p != null) {
			System.out.print(p.info + ", ");
			percursoPreOrdem(p.esquerda);
			percursoPreOrdem(p.direita);
		}
	}
	
	private void percursoPosOrdem(NoBinario<Comparable> p) {
		if(p != null) {
			percursoPosOrdem(p.esquerda);
			percursoPosOrdem(p.direita);
			System.out.print(p.info + ", ");
		}
	}
	
	private void percursoEmOrdem(NoBinario<Comparable> p) {
		if(p != null) {
			percursoEmOrdem(p.esquerda);
			System.out.print(p.info + ", ");
			percursoEmOrdem(p.direita);
		}
	}

	
	public void print() {
		/*System.out.println("Percurso Pre-ordem: ");
		this.percursoPreOrdem(raiz);
		System.out.println("\nPercurso Pos-ordem: ");
		this.percursoPosOrdem(raiz);
		System.out.println("\nPercurso Em ordem: ");*/
		this.percursoEmOrdem(raiz);
		
	}
	
	private int percursoPos(NoBinario<Comparable> p) {
		int altura = -1;
		
		if(p != null) {
			int alturaEsquerdo = percursoPos(p.esquerda);
			int alturaDireita = percursoPos(p.direita);
			altura = (alturaEsquerdo > alturaDireita) ? alturaEsquerdo : alturaDireita;
			altura++;
		}
		
		return altura;
	}
	
	public int alturaArvore() {
		int altura = percursoPos(raiz);
		
		return altura;
	}
	
	public int qtdFolhas(NoBinario<Comparable> raiz) {
		if(raiz == null) {
			return 0;
		} else if(raiz.direita == null && raiz.esquerda == null) {
			return 1;
		} else {
			return qtdFolhas(raiz.esquerda) + qtdFolhas(raiz.direita);
		}
	}

}
