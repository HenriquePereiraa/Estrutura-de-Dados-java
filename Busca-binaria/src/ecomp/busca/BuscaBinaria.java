package ecomp.busca;

public class BuscaBinaria {
	
	
	public static boolean buscaBinaria(int[] vetor, int valorBuscado) {
		
		boolean achou = false;
		int inicio = 0;
		int fim = vetor.length - 1;
		
		while(inicio <= fim) {
			
			int meio = (int) (inicio + fim)/2;
			
			if(vetor[meio] == valorBuscado) {
				achou = true;
				break;
			} else if(vetor[meio] < valorBuscado) {
				inicio = meio + 1;
			} else {
				fim = meio - 1;
			}
		}
		
		return achou;
	}

	public static void main(String[] args) {
		 
		int[] vetor = new int[10];
		
		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = i * 2;
		}
		
		boolean result = buscaBinaria(vetor,10);
		
		System.out.println(result);
		
	}

}
