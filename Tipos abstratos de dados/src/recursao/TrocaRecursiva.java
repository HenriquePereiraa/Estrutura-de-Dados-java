package recursao;

/*
 * Dado uma String s, escreva um algoritmo RECURSIVO que retorne uma nova String novaS onde todas as apari��es 
 * de PI foram substitu�das pelo seu valor aproximado 3.14.
   Espa�os (' ') e pontua��es (',', '.') n�o s�o considerados. A sa�da esperada tamb�m n�o � sens�vel a caso.
 * */


public class TrocaRecursiva {
	
	
	public static int count = 0;
	public static String novaS = "";
	public static String eleminacaoRecursiva(String s) {
		
		s = s.toLowerCase();
		s = s.replace(" ", "");
		s = s.replace(",", "");
		s = s.replace(".", "");
		s = s.replace("pi", "3.14");
		
		if(s.contains(" ") || s.contains(",") || s.contains("pi")) {
			return eleminacaoRecursiva(s);
		}
		
		return s;
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		System.out.println(eleminacaoRecursiva("Pedro, vamos .comer pipoca. e soltar pipa"));
		
	}
}
