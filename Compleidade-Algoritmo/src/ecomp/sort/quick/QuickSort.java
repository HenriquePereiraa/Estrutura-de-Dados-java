package ecomp.sort.quick;

import java.util.Arrays;

public class QuickSort {
	
	public static void quickSort(int[] vetor, int esquerda, int direita) {
		
		if(esquerda < direita) {
			int pivo = particao(vetor,esquerda,direita);
			quickSort(vetor, esquerda, pivo);
			quickSort(vetor, pivo+1, direita);
		}
	}

	private static int particao(int[] vetor, int esquerda, int direita) {
		int meio = (int) (esquerda + direita)/2;
		int pivot = vetor[meio];
		
		int i = esquerda -1;
		int j = direita + 1;
		
		System.out.println("PIVO: " + pivot);
		System.out.println("I: " + i);
		System.out.println("J: " + j);
		while(true) {
			
			do {
				i++;
			}while(vetor[i] < pivot);
			do {
				j--;
			}while(vetor[j] > pivot);
			
			if(i >= j) {
				return j;
			}
			
			
			System.out.println(Arrays.toString(vetor));
			int aux = vetor[i];
			vetor[i] = vetor[j];
			vetor[j] = aux;
			System.out.println(Arrays.toString(vetor));


		}
	}

	public static void main(String[] args) {
		
		int[] valores = {-88,93,35,-71,87,46,-39,78,-31};
		quickSort(valores,0,valores.length-1);
		System.out.println(Arrays.toString(valores));

	}

}
