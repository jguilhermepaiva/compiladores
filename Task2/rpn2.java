package compiladores;

import java.util.LinkedList;

public class RPN{

	public static void main(String[] args) {
		eRPN("10 s +");
	}
		private static void eRPN(String expressao){
			LinkedList<Double> stack = new LinkedList<Double>();
			for (String aux : expressao.split("\\s")){
				if (aux.equals("*")) {
					System.out.print("aux [type=PLUS");
					double operadorDois = stack.pop();
					double operadorUm = stack.pop();
					stack.push(operadorUm * operadorDois);

				} else if (aux.equals("/")) {
					System.out.print("aux [type=PLUS");
					double operadorDois = stack.pop();
					double operadorUm = stack.pop();
					stack.push(operadorUm / operadorDois);

				} else if (aux.equals("-")) {
					System.out.print("aux [type=PLUS");
					double operadorDois = stack.pop();
					double operadorUm = stack.pop();
					stack.push(operadorUm - operadorDois);

				} else if (aux.equals("+")) {
					System.out.print("aux [type=PLUS");
					double operadorDois = stack.pop();
					double operadorUm = stack.pop();
					stack.push(operadorUm + operadorDois);

				} else if (aux.equals("^")) {
					System.out.print("aux [type=PLUS");
					double operadorDois = stack.pop();
					double operadorUm = stack.pop();
					stack.push(Math.pow(operadorUm, operadorDois));

				} else {
					System.out.print("aux [type=NUM]");
					try {
						stack.push(Double.parseDouble(aux+""));
					} catch (NumberFormatException e) {
	    					System.out.println("\nError: Unexpected character: " + aux);
	    					return;
					}
				}
				System.out.println(",lexeme="+aux+"]");
			}
			if (stack.size() > 1) {
				System.out.println("Erro, muitos operandores: " + stack);
				return;
			}
			System.out.println("Saida: " + stack.pop());
		}
	}