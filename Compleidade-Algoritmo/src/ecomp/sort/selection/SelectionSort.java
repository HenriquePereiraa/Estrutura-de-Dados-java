package ecomp.sort.selection;

import java.util.Arrays;

public class SelectionSort {
	
	public static void selectionSort(int[] vetor) {
		
		int aux,menor_posicao;
		System.out.println("ARRAY INICIAL: " + Arrays.toString(vetor));
		for (int i = 0; i < vetor.length; i++) {
			menor_posicao = i;
			for (int j = i + 1; j < vetor.length; j++) {
				System.out.println("menor valor: " + vetor[menor_posicao]  + " comparado com: " + vetor[j]);
				if(vetor[menor_posicao] > vetor[j])
				{
					menor_posicao = j;
					System.out.println("\nmenor valor passe a ser: " + vetor[menor_posicao] + "\n");
				}
			}
			System.out.println("ANTES DA TROCA: " + Arrays.toString(vetor));
			
			aux = vetor[i];
			vetor[i] = vetor[menor_posicao];
			vetor[menor_posicao] = aux;
			System.out.println("APOS A TROCA:   " + Arrays.toString(vetor));
		}
	}

	public static void main(String[] args) {
		
		int[] valores = {32,40,-25,8,-5,3,82,-18,2,26,9,73};
		selectionSort(valores);
		System.out.println(Arrays.toString(valores));

	}

}
