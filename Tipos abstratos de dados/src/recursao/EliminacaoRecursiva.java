package recursao;

/*
 * Dada uma String s, escreva um algoritmo que retorne RECURSIVAMENTE uma nova String, novaString"limpa", ou seja,
 * onde os caracteres adjacentes que são iguais foram reduzidos a um único caractere.
 * */

public class EliminacaoRecursiva {

	
	public static String eleminacaoRecursiva(String s) {
		
		if(s.length() < 2) {
			return s;
		}
		
		if(s.substring(0,1).equals((s.substring(1,2)))) {
			return eleminacaoRecursiva(s.substring(1));
		} else {
			return s.substring(0,1) + eleminacaoRecursiva(s.substring(1));
		}
		
		
	}

	public static void main(String[] args) {
		
		String result = eleminacaoRecursiva("abbbcdd");
		
		System.out.println(result);

	}

}
