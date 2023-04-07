package teste;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Exercicio_05 {

	public static void main(String[] args) {

		/*
		 * ) Escreva um programa que inverta os caracteres de um string.
		 * 
		 * IMPORTANTE: a) Essa string pode ser informada através de qualquer entrada de
		 * sua preferência ou pode ser previamente definida no código; b) Evite usar
		 * funções prontas, como, por exemplo, reverse;
		 * 
		 */
		String palavraInformada = JOptionPane
				.showInputDialog("Digite uma palavra e eu irei inverter os seus caracteres");
		char aux;
		int count = 1;

		char[] palavraInvertida = palavraInformada.toCharArray();

		for (int i = 0; i < (palavraInvertida.length / 2); i++) {
			aux = palavraInvertida[i];
			palavraInvertida[i] = palavraInvertida[palavraInformada.length() - count];
			palavraInvertida[palavraInformada.length() - count] = aux;
			count++;

		}
		palavraInformada = new String(palavraInvertida);
		JOptionPane.showMessageDialog(null,
				"esse é o resultado da sua palavra invertida:  \" " + palavraInformada + " \"");

	}

}
