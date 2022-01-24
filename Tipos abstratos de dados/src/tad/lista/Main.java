package tad.lista;

public class Main {

	public static void main(String[] args) {
		ListaLigada<Integer> values = new ListaLigada<Integer>();
		
		values.inserir(1);
		values.inserir(2);
		values.inserir(3);
		values.inserir(4);
		values.print();

	}

}
