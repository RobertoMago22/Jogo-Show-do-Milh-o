package Jogo_ShowMilhao;

import java.awt.*;
import javax.swing.*;

public class Janela {
	
	private static JFrame janela;
	private static CardLayout card;
	private static JPanel painelPrincipal;
	
	public static void janela() {
		
		//----------------------------------------Janela-----------------------------------------------------
		
		janela = new JFrame("Show do Milhão");
		
		janela.setUndecorated(false);
		janela.setResizable(false);
		janela.setSize(1300, 720);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		
		
		card = new CardLayout();

		painelPrincipal = new JPanel(card);

		janela.add(painelPrincipal);
		
		
		//----------------------------------------Tela Inicial---------------------------------------
		
		JPanel telaInicial = new JPanel();
		
		telaInicial.setBackground(Color.BLUE);
		telaInicial.setLayout(null);
		
		painelPrincipal.add(telaInicial, "Tela 1");
		
		//----------------------------------------Imagem---------------------------------------------------
		
		ImageIcon imagem = new ImageIcon(Janela.class.getResource("/Imagens/Show_Milhao_logo.png"));

		Image img = imagem.getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);

		ImageIcon imagem2 = new ImageIcon(img);

		JLabel label1 = new JLabel(imagem2);
		
		label1.setBounds(153, 0, 1000, 700);
		
		telaInicial.add(label1);
		
		//----------------------------------------Botão Começar---------------------------------------------
		
		JButton comeco = new JButton("Começar");
		
		comeco.setBounds(590, 600, 120, 30);
		comeco.setForeground(Color.WHITE);
		comeco.setBackground(Color.RED);
		comeco.setFont(new Font("Arial", Font.BOLD, 20));
		
		telaInicial.add(comeco);
		
		comeco.addActionListener(e -> {
			
			Janela_PerguntasFaceis.janela_PerguntasFaceis();
			Janela_PerguntasMedias.janela_PerguntasMedias();
			Janela_PerguntasDificeis.janela_PerguntasDificeis();
			Janela_PerguntasFinais.janela_PerguntasFinais();
			
			Premio.premio();
			Janela.setAddTela(Premio.getProximoPremio(), "Tela Premio");
			Janela.setTela("Tela Premio");
			Tempo.tempo();
		});
		
		
		janela.setVisible(true);
		
	}
	
	
	public static void setAddTela(JPanel tela, String name) {
		
		painelPrincipal.add(tela, name);
		painelPrincipal.revalidate();
		painelPrincipal.repaint();
		
	}
	
	
	public static void setTela(String name) {
		
		card.show(painelPrincipal, name);
		
	}
	
}
