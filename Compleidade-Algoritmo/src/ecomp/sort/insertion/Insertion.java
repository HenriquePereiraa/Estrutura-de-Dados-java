package ecomp.sort.insertion;

import java.util.Arrays;

public class Insertion { 
	
	public static void insertionSort(int[] vetor) {
		int aux, j;
		
		for (int i = 1; i < vetor.length; i++) {
			aux = vetor[i];
			j = i-1;
			
			System.out.println("aux: " + aux + " | posição i: " + i +  " | posição j: " + j);
			System.out.println(Arrays.toString(vetor)+"\n");
			while(j >= 0 && vetor[j] > aux)
			{
				vetor[j+1] = vetor[j];
				j--;
			}
			vetor[j+1] = aux;
		}
	}

	public static void main(String[] args) {
		
		int[] valores = {27,7,-123,10,77,50,300,1,0,-100,0,20,-50,100};
		insertionSort(valores);
	}

}
