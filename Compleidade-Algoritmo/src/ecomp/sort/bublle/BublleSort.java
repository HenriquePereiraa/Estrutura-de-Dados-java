package ecomp.sort.bublle;

import java.util.Arrays;

public class BublleSort {
	
	public static void bublleSort(int[] vetor) {
		int aux;
		
		for(int i = 0; i < vetor.length; i++)
		{
			for(int j = i+1; j < vetor.length; j++)
			{
				
				if(vetor[i] > vetor[j])
				{
					aux = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = aux;
				}
			}
			System.out.println("============================================================");
			System.out.println(Arrays.toString(vetor));
		}
	}

	public static void main(String[] args) {
		int[] valores = {65, 35, 26, 13, 91, 12, 23};
		bublleSort(valores);
		/*for (int i : valores) {
			System.out.println(i);
		}*/
		
		/*long inicio = System.currentTimeMillis();
		bublleSort(valores);
		long fim = System.currentTimeMillis();
		
		System.out.println("Tempo: " + (fim-inicio));
		*/
		/*System.out.println("Ordenados");
		for(int i = 0; i < valores.length; i++)
		{
			System.out.println(valores[i]);
		}*/

	}

}
