package teste;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Exercicio_04 {

	public static void main(String[] args) {
		/*
		 * 4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por
		 * estado:
		 * 
		 * SP – R$67.836,43 
		 * RJ – R$36.678,66 
		 * MG – R$29.229,88 
		 * ES – R$27.165,48 
		 * Outros – R$19.849,53
		 * 
		 * Escreva um programa na linguagem que desejar onde calcule o percentual de
		 * representação que cada estado teve dentro do valor total mensal da
		 * distribuidora.
		 */
		Double sp = 67836.43;
		Double rj = 36678.66;
		Double mg = 29229.88;
		Double es = 27165.48;
		Double outros = 19849.53;
		Double valorTotal;
		DecimalFormat df = new DecimalFormat("#,##0.00");

		valorTotal = (sp + rj + mg + es + outros);

		JOptionPane.showMessageDialog(null,
				"O Percentual de representação que o estado de SP teve dentro do valor total mensal da distribuidora foi de "
						+ df.format(calcularPercentual(sp, valorTotal)) + "%\n"
						+ "O Percentual de representação que o estado de RJ teve dentro do valor total mensal da distribuidora foi de "
						+ df.format(calcularPercentual(rj, valorTotal)) + "%\n"
						+ "O Percentual de representação que o estado de MG teve dentro do valor total mensal da distribuidora foi de "
						+ df.format(calcularPercentual(mg, valorTotal)) + "%\n"
						+ "O Percentual de representação que o estado de ES teve dentro do valor total mensal da distribuidora foi de "
						+ df.format(calcularPercentual(es, valorTotal)) + "%\n"
						+ "O Percentual de representação que os outros estados tiveram dentro do valor total mensal da distribuidora foi de "
						+ df.format(calcularPercentual(outros, valorTotal)) + "%");

	}// FIM DO MAIN
	//método para calcular o percentual do estado 
	public static Double calcularPercentual(Double estado, Double valorTotal) {
		Double percentual;

		percentual = (estado / valorTotal) * 100;

		return percentual;

	}
}// FIM DA CLASSE
