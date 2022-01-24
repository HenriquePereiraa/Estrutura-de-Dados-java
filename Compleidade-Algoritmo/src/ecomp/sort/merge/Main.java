package ecomp.sort.merge;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		int[] valores = new int[100];
		
		for(int i = 0; i < valores.length; i++)
		{
			valores[i] = (int)(Math.random() * valores.length);
		}
		
		long inicio = System.currentTimeMillis();
		MergeSort.sort(valores, 0, valores.length-1);
		long tempoFinal = System.currentTimeMillis();
		System.out.println(tempoFinal-inicio);
	}

}
