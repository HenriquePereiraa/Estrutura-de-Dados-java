package tad.arvore;

import tad.pilha.PilhaDinamica;

public class ArvoreExpressao {
	
	private NoBinario<String> raiz;
	
	
	
	public ArvoreExpressao(String expressao) {
		PilhaDinamica<String> pOperadores = new PilhaDinamica<String>();
		PilhaDinamica<NoBinario<String>> pNos = new PilhaDinamica<NoBinario<String>>();
		
		String[] tokens = expressao.replace(" ", "").split("");		
		
		
		for (int i = 0; i < tokens.length; i++) {
			String termo = tokens[i];
			System.out.println(termo);
			char c = termo.charAt(0);
			if(Character.isDigit(c)) {
				System.out.println("É um digito: " + c);
				NoBinario<String> novoNo = new NoBinario<String>(termo);
				pNos.push(novoNo);
			} else if(c == ')') {
				String operador = pOperadores.pop();
				System.out.println("Operador: " + operador);
				NoBinario<String> novoNo = new NoBinario<String>(operador);
				novoNo.direita = pNos.pop();
				novoNo.esquerda = pNos.pop(); 
				pNos.push(novoNo);
			} else if( c != '(') {
				pOperadores.push(termo);
			}
		}
		
		if(pNos.size() == 1) {
			raiz = pNos.pop();
		}
		
	}
	
	private int percursoPosOrdem(NoBinario<String> p) {
		
		int response = 0;
		
		if(p != null) {
			if(p.esquerda == null && p.direita == null) {
				response = Integer.parseInt(p.info);
			} else {
				int valorNoEsquerdo = percursoPosOrdem(p.esquerda);
				int valorNoDireito = percursoPosOrdem(p.direita);
				response = aplicarOperador(p.info, valorNoEsquerdo, valorNoDireito);
			}
		}
		
		return response;
		
	}
	
	private int aplicarOperador(String operador, int valorNoEsquerdo, int valorNoDireito) {
		int respostaDoCalculo = 0;
		
		if(operador.equals("+")) {
			respostaDoCalculo = valorNoEsquerdo + valorNoDireito;
		} else if(operador.equals("-")) {
			respostaDoCalculo = valorNoEsquerdo - valorNoDireito;
		}  else if(operador.equals("*")) {
			respostaDoCalculo = valorNoEsquerdo * valorNoDireito;
		}  else if(operador.equals("/")) {
			respostaDoCalculo = valorNoEsquerdo / valorNoDireito;
		}
		
		return respostaDoCalculo;
	}

	public int calcularExpressao() {
		int response = percursoPosOrdem(raiz);
		
		return response;
	}
	
	public static void main(String[] args) {
		ArvoreExpressao arvore = new ArvoreExpressao("(1+2)");
		
		System.out.println("Resultado: " + arvore.calcularExpressao());
	}

}
