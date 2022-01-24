package tad.arvore;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria<String> arvore = new ArvoreBinaria();
		
		arvore.inserir("1");
		arvore.inserir("5");
		arvore.inserir("8");
		arvore.inserir("10");
		arvore.inserir("15");
		arvore.inserir("20");
		arvore.inserir("30");
		/*arvore.inserir("9");
		arvore.inserir("12");
		arvore.inserir("13");
		System.out.println("\nAltura da arvore: " + arvore.alturaArvore());
		
		System.out.println("\nExiste 6? " + arvore.existe(6));
		System.out.println("Removendo o 6");
		arvore.remove(6);
		arvore.print();
		System.out.println("\nAltura da arvore: " + arvore.alturaArvore());
		System.out.println("\nExiste 6? " + arvore.existe(6));
		
		System.out.println("----------------------------------");
		System.out.println("Existe 5? " + arvore.existe(5));
		System.out.println("Removendo o 5");
		arvore.remove(4);*/
		arvore.print();
		/*System.out.println("\nAltura da arvore: " + arvore.alturaArvore());
		System.out.println("\nExiste 5? " + arvore.existe(5));*/

	}

}
