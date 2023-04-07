package teste;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Exercicio_05 {

	public static void main(String[] args) {

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
