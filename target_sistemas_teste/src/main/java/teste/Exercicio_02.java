package teste;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Exercicio_02 {

	public static void main(String[] args) {
		/*
		 * 2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor
		 * sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8,
		 * 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado
		 * um número, ele calcule a sequência de Fibonacci e retorne uma mensagem
		 * avisando se o número informado pertence ou não a sequência.
		 * 
		 * IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua
		 * preferência ou pode ser previamente definido no código;
		 */
		
		int n1 = 0, n2 = 1, nextNumber = n1 + n2;
		//array que vai armazenar os números da sequência fibonacci entre 0  e 100
		ArrayList<Integer> arrayFibonacci = new ArrayList<Integer>();

		arrayFibonacci.add(n1);
		arrayFibonacci.add(n2);
		arrayFibonacci.add(nextNumber);
		
		
		/*criando sequência de fibonacci entre 0 e 100 
		  para usar de referência na hora de consultar o numero informado pelo usário*/

		for (int i = 0; i < 100; i = nextNumber) {
			n1 = n2;
			n2 = nextNumber;
			nextNumber = n1 + n2;
			if (nextNumber > 100)//verificando se o numero está entre 1 e 100, caso ultrapasse ele sai do for e continua o código
				continue;
			arrayFibonacci.add(nextNumber);

		}

		int opcao = Integer.parseInt(JOptionPane.showInputDialog(
				"Informe um número entre 0 e 100 para saber se ele faz parte da sequência de Fibonacci:"));
		//verificando se é um número válido entre 0 e 100
		if (opcao > 100 || opcao < 0) {
			JOptionPane.showMessageDialog(null, "ERRO: Informar somente números entre 0 e 100");

		} else {
			boolean resultado = false;
			/*verificando se o número informado está na sequência*/
			for (int i = 0; i < arrayFibonacci.size(); i++) {
				if (opcao == arrayFibonacci.get(i))
					resultado = true;

			}
			//exibindo o resultado
			if (resultado == true) {
				JOptionPane.showMessageDialog(null,
						"o Número escolhido foi: " + opcao + " e ele faz parte da sequência de Fibonacci");

			} else {
				JOptionPane.showMessageDialog(null,
						"o Número escolhido foi: " + opcao + " e ele NÃO faz parte da sequência de Fibonacci");

			}

		}

	}

}
