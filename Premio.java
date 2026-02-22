package Jogo_ShowMilhao;

import java.awt.*;
import javax.swing.*;
import java.text.*;

public class Premio {
	
	private static double anterior;
	private static double atual;
	private static double proximo;
	private static JPanel informacao;
	private static DecimalFormat df = new DecimalFormat("#,##0.00");

	public static void premio() {
		
		anterior = 0;
		atual = 500.00f;
		proximo = 1000.00f;
		
		informacao = new JPanel();
		
		informacao.setBackground(Color.blue);
		informacao.setLayout(null);
		
		
		JLabel valor = new JLabel("Prêmio de R$.: " + df.format(proximo));

		valor.setForeground(Color.WHITE);
		valor.setFont(new Font("Arial", Font.BOLD, 50));
		valor.setBounds(400, 100, 700, 500);

		informacao.add(valor);
	}
	
	public static void setAcertou() {
		
		if(Numero_Pergunta.getComeco() <= 5) {
			
			anterior = atual;
			atual = proximo;
			proximo += 1000;
		}
		
		else if(Numero_Pergunta.getComeco() == 6) {
			
			anterior = atual;
			atual = proximo;
			proximo += 5000;
		}
		
		else if(Numero_Pergunta.getComeco() <= 10) {
			
			anterior = atual;
			atual = proximo;
			proximo += 10000;
		}
		
		else if(Numero_Pergunta.getComeco() == 11) {
			
			anterior = atual;
			atual = proximo;
			proximo += 50000;
		}
		
		else if(Numero_Pergunta.getComeco() <= 15) {
			
			anterior = atual;
			atual = proximo;
			proximo += 100000;
		}
		
		else if(Numero_Pergunta.getComeco() == 16) {
			
			anterior = atual;
			atual = proximo;
			proximo += 500000;
		}
		
	}
	
	public static void setErrou() {
		
		atual = anterior;
	}
	
	public static void setFinal() {
		
		atual = 0;
	}
	
	public static double getAtual() {
		
		return atual;
	}
	
	public static JPanel getProximoPremio() {
		
		informacao.removeAll();
		
		JLabel valor = new JLabel("Prêmio de R$.: " + df.format(proximo));

		valor.setForeground(Color.WHITE);
		valor.setFont(new Font("Arial", Font.BOLD, 50));
		valor.setBounds(400, 100, 700, 500);

		informacao.add(valor);
		
		informacao.revalidate();
		informacao.repaint();
		
		return informacao;
	}
	
	public static JPanel getFim() {
		
		informacao.removeAll();
		
		JLabel valor = new JLabel("Você ganhou R$.: " + df.format(atual));

		valor.setForeground(Color.WHITE);
		valor.setFont(new Font("Arial", Font.BOLD, 50));
		valor.setBounds(400, 100, 700, 500);

		informacao.add(valor);
		
		informacao.revalidate();
		informacao.repaint();
		
		return informacao;
		
	}
	
	public static JPanel getFinal() {
			
		informacao.removeAll();
			
		JLabel valor = new JLabel("Parabéns você ganhou R$.: 1.000.000,00");
	
		valor.setForeground(Color.WHITE);
		valor.setFont(new Font("Arial", Font.BOLD, 50));
		valor.setBounds(200, 100, 1000, 500);
	
		informacao.add(valor);
			
		informacao.revalidate();
		informacao.repaint();
			
		return informacao;
	}

}
