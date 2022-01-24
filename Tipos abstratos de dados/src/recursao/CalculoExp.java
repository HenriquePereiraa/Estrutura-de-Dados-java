package recursao;

public class CalculoExp {
	
	public static int calculoExp(String s) {
		//10+15+30+20=
		
		if(s.contains("+") == false && s.contains("=") == false){
			return 0;
		}
		
		if(s.contains("+") && s.contains("=")) {
			int posicaoMais = s.indexOf("+");
			return calculoExp(s.substring(posicaoMais+1)) + Integer.parseInt(s.substring(0, posicaoMais));
		} else {
			int posicaoIgual = s.indexOf("=");
			return Integer.parseInt(s.substring(0,posicaoIgual));
		}
		
	}

	public static void main(String[] args) {
		int result = calculoExp("10+15+30+20=");
		System.out.println(result);
	}

}
