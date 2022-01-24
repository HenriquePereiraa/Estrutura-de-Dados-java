package tad.fila;

public class Main {

	public static void main(String[] args) {
		TDAFila<Integer> fila = new FilaEstatica<Integer>(5);
		
		fila.inqueue(1);
		fila.inqueue(2);
		fila.inqueue(3);
		fila.inqueue(4);
		fila.inqueue(5);
		
		fila.print();
		
		System.out.println("REMOVENDO: " + fila.dequeue());
		
		fila.print();
		
		System.out.println("REMOVENDO: " + fila.dequeue());
		
		fila.print();
		fila.inqueue(6);
		fila.print();
		fila.inqueue(7);
		fila.print();
		fila.inqueue(8);
		fila.print();
		
		
		/*TDAFila<Integer> fila = new FilaDinamica<Integer>();
		
		
		fila.inqueue(1);
		fila.inqueue(2);
		fila.inqueue(3);
		fila.inqueue(4);
		fila.inqueue(5);
		*/
	}

}
