package tad.pilha;

public class Main {
	
	public static String converterDecimalBinario(int n) {
		String novaBase = "";
		TADPilha<Integer> pilha = new PilhaDinamica<Integer>();
		while(n >= 2) {
			pilha.push(n%2);
			n = n/2;
		}
		
		pilha.push(n);
		
		while(! pilha.isEmpty()) {
			novaBase += pilha.pop();
		}
		
		return novaBase;
	}
	
	public static boolean expressaoBemFormada(String s) {
		boolean isFormated = true;
		TADPilha<String> pilha = new PilhaDinamica<String>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '(') {
				pilha.push("(");
			} else if(c == ')') {
				if(pilha.isEmpty()) {
					isFormated = false;
					break;
				} else {
					pilha.pop();
				}
			}
		}
		
		if(! pilha.isEmpty()) {
			isFormated = false;
		}
		
		return isFormated;
	}
	
	
	public static int calcularExpressaoPosFixa(String s) {
		int response = 0;
		String[] termos = s.split(" ");
		
		
		return 0;
	}

	public static void main(String[] args) {
		TADPilha<Integer> pilha = new PilhaDinamica<Integer>();
		
		/*pilha.print();
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		pilha.push(4);
		pilha.push(5);
		pilha.print();
		pilha.pop();
		pilha.print();
		pilha.pop();
		pilha.print();*/
		
		System.out.println(converterDecimalBinario(35));
		System.out.println(expressaoBemFormada("(A+B))"));
		System.out.println(expressaoBemFormada("(A+B)"));
		
	}

}
