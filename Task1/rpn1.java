package compiladores;


// Professor encontrei em um livro que estava estudando, como fazer essa formula de modo que fosse pós fixa, 
// porém não consegui fazer com que recebesse as entradas uma abaixo da outra.

import java.util.Scanner;
import java.util.Stack;

public class RPN 
    {
    private Stack<Integer> stack;

     public RPN()
        {
            stack = new Stack<>(); 
        }

     public static void main(String[] args)
        {
            String conta, repete;
            int resultado;

            Scanner in = new Scanner(System.in);

            do
            {  
                RPN evaluator = new RPN();
                System.out.println("Digite a sua equação na forma pós-fixa");
                conta = in.nextLine();

                resultado = evaluator.evaluate(conta);
                System.out.println();
                System.out.println("Saida " + resultado);

                System.out.print("Deseja fazer outra operação [S/N]? ");
                repete = in.nextLine();
                System.out.println();
            }
            while (repete.equalsIgnoreCase("S"));
       }

    public int evaluate(String expr) 
        {
            int op1, op2, resultado = 0;
            String aux;
            Scanner in = new Scanner(expr);     

            while (in.hasNext())        
            {
                aux = in.next();          

                if (isOperator(aux))  
                {
                    op2 = (stack.pop()).intValue();
                    op1 = (stack.pop()).intValue();
                    resultado = evaluateSingleOperator(aux.charAt(0), op1, op2);     
                    stack.push((resultado));
                }
                else
                    stack.push((Integer.parseInt(aux)));       
            }

            return resultado;
        }

     private boolean isOperator(String token)
        {
            return ( token.equals("+") || token.equals("-") ||
                     token.equals("*") || token.equals("/") || token.equals("%") );

        }

     private int evaluateSingleOperator(char operador, int op1, int op2)
        {
            int resultado = 0;

            switch (operador)
            {
                case '+':
                    resultado = op1 + op2;
                    break;
                case '-':
                    resultado = op1 - op2;
                    break;
                case '*':
                    resultado = op1 * op2;
                    break;
                case '/':
                    resultado = op1 / op2;
                    break;
                case '%':
                    resultado = op1 % op2;
                    break;
            }

            return resultado;
        }

}