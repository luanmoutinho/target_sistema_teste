package teste;

import javax.swing.JOptionPane;

public class Exercicio_01 {

	public static void main(String[] args) {
		/*
		 * Observe o trecho de código abaixo:
		 * 
		 * int INDICE = 13, SOMA = 0, K = 0;
		 * 
		 * enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; }
		 * 
		 * imprimir(SOMA);
		 * 
		 * Ao final do processamento, qual será o valor da variável SOMA?
		 */
		int indice = 13, soma = 0, k = 0;

		while (k < indice) {
			k++;
			soma += 1;
		}

		
		JOptionPane.showMessageDialog(null, "A soma dos números é igual a "+soma);
	}

}
