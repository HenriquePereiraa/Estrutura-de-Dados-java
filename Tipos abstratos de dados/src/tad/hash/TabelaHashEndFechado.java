package tad.hash;
import tad.lista.ListaLigada;

public class TabelaHashEndFechado<T> {
	private ListaLigada<T> tabela[];
	
	public TabelaHashEndFechado(int n) {
		tabela = new ListaLigada[n];
		
		for(int i = 0; i < n; i++) {
			tabela[i] = new ListaLigada<T>();
		}
	}
	
	
	public void add(T elemento) {
		int indice = elemento.hashCode() % tabela.length;
		
		if(!tabela[indice].find(elemento)) {
			tabela[indice].inserir(elemento);
		}
	}
}
