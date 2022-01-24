package tad.arvore;

public class ArvoreAVL<T extends Comparable> extends ArvoreBinaria<T> {
	
	private boolean isAVL;
	NoBinario<Comparable> z, y, x;
	NoBinario<Comparable> a, b, c, t0, t1, t2, t3;
	
	public void inserir(T novo) {
		super.inserir(novo);	
		
		if(!isAVL()) {
			balancear();
		}
	}
	
	public boolean romeve(T e) {
		boolean response = super.remove(e);
		
		while(! isAVL()) {
			balancear();
		}
		
		return response;
	}

	private void balancear() {
		
		
	}

	//verificar se  |Altura(v.noEsquerdo) - Altura(v.noDireito)| <= 1
	private boolean isAVL() {
		isAVL = true;
		x = y = z = null;
		a = b = c = null;
		t0 = t1 = t2 = t3 = null;
		calcularAlturaNo(raiz);
		
		return isAVL;
	}
	
	private int calcularAlturaNo(NoBinario<Comparable> no) {
		int v;
		
		if(no != null) {
			int e = calcularAlturaNo(no.esquerda);
			int d = calcularAlturaNo(no.direita);
			v = (e>d) ? (e+1) : (d+1);
			
			if(Math.abs(e-d) > 1 && isAVL) {
				//arvore continua sendo AVL
				isAVL = false;
				x = no;
			}
		} else {
			v = -1;
		}
		
		return v;
	}
}
