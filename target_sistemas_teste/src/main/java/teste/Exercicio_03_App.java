package teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Exercicio_03_App {

	public static void main(String[] args) {
		/**
		 * 3) Dado um vetor que guarda o valor de faturamento diário de uma
		 * distribuidora, faça um programa, na linguagem que desejar, que calcule e
		 * retorne: • O menor valor de faturamento ocorrido em um dia do mês; • O maior
		 * valor de faturamento ocorrido em um dia do mês; • Número de dias no mês em
		 * que o valor de faturamento diário foi superior à média mensal.
		 * 
		 * IMPORTANTE: a) Usar o json ou xml disponível como fonte dos dados do
		 * faturamento mensal; b) Podem existir dias sem faturamento, como nos finais de
		 * semana e feriados. Estes dias devem ser ignorados no cálculo da média;
		 */

		String diaMaior = null, diaMenor = null;
		Double maiorValor = 0.0, menorValor = 1000000.00, verificaValor, totalFaturamento = 0.0, media = 0.0;
		int count = 0, countDiasMaiorFat = 0;
		//criando um objeto que vai serr setado com os dados do arquivo json
		Exercicio_03_Faturamento faturamento = new Exercicio_03_Faturamento();
		DecimalFormat df = new DecimalFormat("#,##0.00");
		ArrayList<Exercicio_03_Faturamento> faturamentos = new ArrayList();//array para armazenar os objetos

		JSONParser parser = new JSONParser();
		try {

			JSONArray jArrayFaturamentos = (JSONArray) parser
					.parse(new InputStreamReader(new FileInputStream("src/main/webapp/dados.json"), "UTF-8"));

			//criando o objeto e setando com dados do array de dados que veio do json 
			
			for (Object object : jArrayFaturamentos) {
				JSONObject jFaturamento = (JSONObject) object;
				String dia = jFaturamento.get("dia").toString();
				Double valor = Double.parseDouble(jFaturamento.get("valor").toString());

				faturamento = new Exercicio_03_Faturamento();
				faturamento.setDia(dia);
				faturamento.setValor(valor);
				faturamentos.add(faturamento);//adicionando objeto ao array de objetos da classe Exercicio_03_Faturamento

			}

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
		//percorrendo o array 
		for (Exercicio_03_Faturamento fatDiarios : faturamentos) {

			verificaValor = fatDiarios.getValor();

			if (verificaValor == 0.0) {
				count++;

			} else
				totalFaturamento += verificaValor;
			//verificando se é o maior
			if (verificaValor > maiorValor) {
				maiorValor = verificaValor;
				diaMaior = fatDiarios.getDia();

			}
			//verificando se é o menor
			if (verificaValor != 0.0 && verificaValor < menorValor) {
				menorValor = verificaValor;
				diaMenor = fatDiarios.getDia();
			}

		}

		media = totalFaturamento / (faturamentos.size() - count);//calculo de media
		//contando os dias em que o faturamento foi superior a media
		for (Exercicio_03_Faturamento faturaDia : faturamentos) {
			if (faturaDia.getValor() > media) {
				countDiasMaiorFat++;
			}
		}

		JOptionPane.showMessageDialog(null, "o MENOR valor de faturamento foi R$" + df.format(menorValor)
				+ " e ocorreu no dia: " + diaMenor + "\n"
				+ "o MAIOR valor de faturamento foi R$"+df.format(maiorValor)+" e ocorreu no dia: "+diaMaior+"\n"
						+ "O N° de dias no mês em que o valor de faturamento diário foi superior à média mensal foi: "+ countDiasMaiorFat);

		

	}

}
