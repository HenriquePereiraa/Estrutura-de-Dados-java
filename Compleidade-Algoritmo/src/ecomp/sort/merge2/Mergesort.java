package ecomp.sort.merge2;

import java.util.Arrays;

public class Mergesort {
	
	public static void sort(int[] vetor, int inicio, int fim) {
		
		if(inicio < fim) {
			
			int meio = (inicio+fim)/2;
			
			sort(vetor,inicio,meio);
			sort(vetor,meio+1,fim);
			merge(vetor,inicio,meio,fim);
		}
	}
	
	public static void merge(int[] vetor, int inicio, int meio, int fim) {
		
		int[] auxiliar = new int[vetor.length];
		
		for(int i = 0; i < vetor.length; i++) {
			auxiliar[i] = vetor[i];
		}
		
		int indiceEsquerda = inicio;
		int indiceDireita = meio+1;
		
		for(int i = inicio; i <= fim; i++) {
			
			if(indiceEsquerda > meio) {
				vetor[i] = auxiliar[indiceDireita++];
			} else if(indiceDireita > fim) {
				vetor[i] = auxiliar[indiceEsquerda++];
			} else if(auxiliar[indiceEsquerda] < auxiliar[indiceDireita]) {
				vetor[i] = auxiliar[indiceEsquerda++];
			} else {
				vetor[i] = auxiliar[indiceDireita++];
			}
		}
	}

	public static void main(String[] args) {
		
		int[] valores = {59,4,5,7,9,3,1,10,15,23,45,44,38};
		
		System.out.println(Arrays.toString(valores));
		sort(valores,0,valores.length-1);
		System.out.println(Arrays.toString(valores));
	}
}
