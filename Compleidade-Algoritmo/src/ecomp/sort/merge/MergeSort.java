package ecomp.sort.merge;

public class MergeSort {
	
	public static void sort(int[] vetor, int indexInicial, int indexFinal) {
		
		if(indexInicial < indexFinal)
		{//caso base
			int indexMedio = (indexFinal + indexInicial) / 2;//meio do array
			
			sort(vetor, indexInicial, indexMedio);//do inicio até o meio
			sort(vetor, indexMedio + 1, indexFinal);//do meio até o fim. meio+1 para não pegar o mesmo elemento que o "esquerdo" ja pegou 
			
			merge(vetor, indexInicial, indexMedio, indexFinal);//junta o vetor 
			
		}
	}
	
	public static void merge(int[] vetor, int indexInicial, int indexMedio, int indexFinal) {
		
		int[] esquerdo = new int[indexMedio - indexInicial + 1];
		int[] direito = new int[indexFinal - indexMedio];
		
		for(int i = 0; i < esquerdo.length; i++) {
			esquerdo[i] = vetor[indexInicial + i];
		}
		
		for(int j = 0; j < direito.length; j++) {
			direito[j] = vetor[indexMedio + 1 + j];
		}
		
		int indexEsquerdo = 0;//percorrer o array esquerdo
		int indexDireito = 0;//percorrer o array direito
		
		int indexVetor = indexInicial;//vai percorre o vetor principal reatribuindo os novos valores
		
		
		while(indexEsquerdo < esquerdo.length && indexDireito < direito.length)
		{
			if(esquerdo[indexEsquerdo] <= direito[indexDireito])
			{
				vetor[indexVetor] = esquerdo[indexEsquerdo++];
			} else {
				vetor[indexVetor] = direito[indexDireito++];
			}
			
			indexVetor++;
		}
		
		while(indexEsquerdo < esquerdo.length)
		{
			vetor[indexVetor] = esquerdo[indexEsquerdo++];
			indexVetor++;
		}
		
		while(indexDireito < direito.length)
		{
			vetor[indexVetor] = direito[indexDireito++];
		}
	}

}
