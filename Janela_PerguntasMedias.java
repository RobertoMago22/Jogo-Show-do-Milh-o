package Jogo_ShowMilhao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

public class Janela_PerguntasMedias {
	
	private static CardLayout card;
	private static JPanel painelPerguntas;
	private static int[] verificador = new int[10];
	private static JLabel[] perguntaMedia = new JLabel[10];
	private static JButton[][] botoes = new JButton[10][4];

	public static void janela_PerguntasMedias() {

		card = new CardLayout();

		painelPerguntas = new JPanel(card);
		
		Numero_Pergunta.setErrou();

//---------------------------------------------Verificador-----------------------------------------------

		for (int i = 0; i < 10; i++) {

			verificador[i] = 1;
		}

//----------------------------------------------Janela---------------------------------------------

		JPanel[] pergunta = new JPanel[10];

		for (int i = 0; i < 10; i++) {

			pergunta[i] = new JPanel();

			pergunta[i].setBackground(Color.BLUE);
			pergunta[i].setLayout(null);
		}

//-----------------------------------------------Perguntas-------------------------------------------

		perguntaMedia = new JLabel[10];

		for (int i = 0; i < 10; i++) {

			perguntaMedia[i] = new JLabel();

			perguntaMedia[i].setOpaque(true);
			perguntaMedia[i].setVerticalAlignment(SwingConstants.CENTER);
			perguntaMedia[i].setHorizontalAlignment(SwingConstants.CENTER);
			perguntaMedia[i].setBackground(Color.red);
			perguntaMedia[i].setForeground(Color.white);
			perguntaMedia[i].setBounds(20, 20, 1250, 100);
			perguntaMedia[i].setFont(new Font("Arial", Font.BOLD, 20));

			pergunta[i].add(perguntaMedia[i]);

		}
		
		perguntaMedia[0].setBounds(20, 20, 1250, 200);
		perguntaMedia[1].setBounds(20, 20, 1250, 200);
		perguntaMedia[3].setBounds(20, 20, 1250, 200);
		perguntaMedia[5].setBounds(20, 20, 1250, 200);
		perguntaMedia[8].setBounds(20, 20, 1250, 200);
		
		
// --------------------------------------PerguntasFaceis-------------------------------------------------------

		Janela_PerguntasMedias.setPerguntas();

//-------------------------------------------------Botoes-------------------------------------------

		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 4; j++) {

				botoes[i][j] = new JButton();

				botoes[i][j].setBounds(20, 300 + (j * 50), 400, 30);
				botoes[i][j].setBackground(Color.red);
				botoes[i][j].setForeground(Color.white);
				botoes[i][j].setVerticalAlignment(SwingConstants.CENTER);
				botoes[i][j].setHorizontalAlignment(SwingConstants.LEFT);
				botoes[i][j].setFont(new Font("Arial", Font.BOLD, 20));

				pergunta[i].add(botoes[i][j]);

			}

			painelPerguntas.add(pergunta[i], "tela" + i);
		}

//------------------------------------------Opções---------------------------------------------------------

//------------------------------------------Pergunta 1-----------------------------------------------------------

		botoes[0][0].setText("1) A");
		botoes[0][1].setText("2) B");
		botoes[0][2].setText("3) Nada");
		botoes[0][3].setText("4) Erro");
//------------------------------------------Pergunta 2-----------------------------------------------------------			
		botoes[1][0].setText("1) 1");
		botoes[1][1].setText("2) 2");
		botoes[1][2].setText("3) 3");
		botoes[1][3].setText("4) 4");
//------------------------------------------Pergunta 3-----------------------------------------------------------			
		botoes[2][0].setText("1) Repetir código");
		botoes[2][1].setText("2) Finalizar o programa");
		botoes[2][2].setText("3) Criar variáveis");
		botoes[2][3].setText("4) Executar quando o if for falso");
//------------------------------------------Pergunta 4-----------------------------------------------------------			
		botoes[3][0].setText("1) 4");
		botoes[3][1].setText("2) 5");
		botoes[3][2].setText("3) 6");
		botoes[3][3].setText("4) 0");
//------------------------------------------Pergunta 5-----------------------------------------------------------			
		botoes[4][0].setText("1) do while");
		botoes[4][1].setText("2) while");
		botoes[4][2].setText("3) for");
		botoes[4][3].setText("4) if");
//------------------------------------------Pergunta 6-----------------------------------------------------------			
		botoes[5][0].setText("1) Diferente");
		botoes[5][1].setText("2) Igual");
		botoes[5][2].setText("3) Nada");
		botoes[5][3].setText("4) Erro");
//------------------------------------------Pergunta 7-----------------------------------------------------------			
		botoes[6][0].setText("1) Atribuição");
		botoes[6][1].setText("2) Somar");
		botoes[6][2].setText("3) Comparação");
		botoes[6][3].setText("4) Subtração");
//------------------------------------------Pergunta 8-----------------------------------------------------------			
		botoes[7][0].setText("1) while");
		botoes[7][1].setText("2) do whie");
		botoes[7][2].setText("3) if");
		botoes[7][3].setText("4) for");
//------------------------------------------Pergunta 9-----------------------------------------------------------			
		botoes[8][0].setText("1) 123");
		botoes[8][1].setText("2) 0123");
		botoes[8][2].setText("3) 321");
		botoes[8][3].setText("4) Erro");
//------------------------------------------Pergunta 10-----------------------------------------------------------			
		botoes[9][0].setText("1) stop");
		botoes[9][1].setText("2) exit");
		botoes[9][2].setText("3) break");
		botoes[9][3].setText("4) end");

//---------------------------------------Ação dos Botoes---------------------------------------------------

		for(int i = 0; i < 10; i++) {
			
			int x = i;
			
			for(int j = 0; j < 4; j++) {
			
				int  y= j;
				
				botoes[x][y].addActionListener(e -> {

					botoes[x][y].setBackground(Color.YELLOW);
					botoes[x][Janela_PerguntasMedias.getRespostaCerta(x)].setBackground(Color.GREEN);

					botoes[x][0].setEnabled(false);
					botoes[x][1].setEnabled(false);
					botoes[x][2].setEnabled(false);
					botoes[x][3].setEnabled(false);

					verificador[x] = 1;

					Premio.setErrou();

					Tempo.tempoFim();

					Numero_Pergunta.setErrou();
				});
			}
		}
		
		Janela_PerguntasMedias.setRespostasCertas();		
	}

	public static JPanel getPerguntas() {

		Random random = new Random();
		int numero;

		do
			numero = random.nextInt(10);

		while (verificador[numero] == 0);

		switch (numero) {

		case 0:
			card.show(painelPerguntas, "tela0");
			break;

		case 1:
			card.show(painelPerguntas, "tela1");
			break;

		case 2:
			card.show(painelPerguntas, "tela2");
			break;
			
		case 3:
			card.show(painelPerguntas, "tela3");
			break;
			
		case 4:
			card.show(painelPerguntas, "tela4");
			break;

		case 5:
			card.show(painelPerguntas, "tela5");
			break;

		case 6:
			card.show(painelPerguntas, "tela6");
			break;
			
		case 7:
			card.show(painelPerguntas, "tela7");
			break;
			
		case 8:
			card.show(painelPerguntas, "tela8");
			break;
			
		case 9:
			card.show(painelPerguntas, "tela9");
			break;

		}

		return painelPerguntas;

	}

	public static void setPerguntas() {

		perguntaMedia[0].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída do código?<br></br>"
								+ "<br></br>int x = 10;<br></br>if (x &lt; 5) {<br></br>"
								+ "    System.out.println(\"A\");<br></br>"
								+ "} else {<br></br>    System.out.println(\"B\");<br></br>"
								+ "}</html>");

		perguntaMedia[1].setText("<html>" + Numero_Pergunta.getComeco() + "- Quantas vezes o laço será executado?"
								+ "<br></br><br></br>"
								+ "for (int i = 0; i &lt; 3; i++) {<br></br>"
								+ "    System.out.println(i);<br></br>"
								+ "}</html>");

		perguntaMedia[2].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual é a função do else?</html>");

		perguntaMedia[3].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será o valor final de x?<br></br>"
								+ "<br></br>"
								+ "int x = 0;<br></br>"
								+ "while (x &lt; 5) {<br></br>"
								+ "    x++;<br></br>"
								+ "}</html>");

		perguntaMedia[4].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual laço garante que o bloco seja "
								+ "executado ao menos uma vez?</html>");

		perguntaMedia[5].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual é a saída?<br></br>"
								+ "<br></br>"
								+ "int x = 5;<br></br>"
								+ "if (x == 5) {<br></br>"
								+ "    System.out.println(\"Igual\");<br></br>"
								+ "}</html>");

		perguntaMedia[6].setText("<html>" + Numero_Pergunta.getComeco() + "- O operador == é usado para:</html>");

		perguntaMedia[7].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual estrutura é mais indicada quando "
								+ "se sabe o número de repetições?</html>");

		perguntaMedia[8].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída?<br></br>"
								+ "<br></br>"
								+ "for (int i = 1; i &lt;= 3; i++) {<br></br>"
								+ "    System.out.print(i);<br></br>"
								+ "}</html>");

		perguntaMedia[9].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual palavra-chave interrompe "
								+ "um laço?</html>");
	}
	
	public static void setRespostasCertas() {
		
		for(ActionListener al: botoes[0][1].getActionListeners()) {
			
			botoes[0][1].removeActionListener(al);
		}
		
		botoes[0][1].addActionListener(e -> {

			botoes[0][1].setBackground(Color.GREEN);

			botoes[0][0].setEnabled(false);
			botoes[0][1].setEnabled(false);
			botoes[0][2].setEnabled(false);
			botoes[0][3].setEnabled(false);

			verificador[0] = 0;

			Numero_Pergunta.setAcertou();

			Premio.setAcertou();

			Tempo.tempoPergunta();
		});
		
		for(ActionListener al: botoes[1][2].getActionListeners()) {
			
			botoes[1][2].removeActionListener(al);
		}
		
		botoes[1][2].addActionListener(e -> {

			botoes[1][2].setBackground(Color.GREEN);

			botoes[1][0].setEnabled(false);
			botoes[1][1].setEnabled(false);
			botoes[1][2].setEnabled(false);
			botoes[1][3].setEnabled(false);

			verificador[1] = 0;

			Numero_Pergunta.setAcertou();

			Premio.setAcertou();

			Tempo.tempoPergunta();
		});
		
		for(ActionListener al: botoes[2][3].getActionListeners()) {
			
			botoes[2][3].removeActionListener(al);
		}
		
		botoes[2][3].addActionListener(e -> {

			botoes[2][3].setBackground(Color.GREEN);

			botoes[2][0].setEnabled(false);
			botoes[2][1].setEnabled(false);
			botoes[2][2].setEnabled(false);
			botoes[2][3].setEnabled(false);

			verificador[2] = 0;

			Numero_Pergunta.setAcertou();

			Premio.setAcertou();

			Tempo.tempoPergunta();
		});
		
		for(ActionListener al: botoes[3][1].getActionListeners()) {
			
			botoes[3][1].removeActionListener(al);
		}
		
		botoes[3][1].addActionListener(e -> {

			botoes[3][1].setBackground(Color.GREEN);

			botoes[3][0].setEnabled(false);
			botoes[3][1].setEnabled(false);
			botoes[3][2].setEnabled(false);
			botoes[3][3].setEnabled(false);

			verificador[3] = 0;

			Numero_Pergunta.setAcertou();

			Premio.setAcertou();

			Tempo.tempoPergunta();
		});
		
		for(ActionListener al: botoes[4][0].getActionListeners()) {
			
			botoes[4][0].removeActionListener(al);
		}
		
		botoes[4][0].addActionListener(e -> {

			botoes[4][0].setBackground(Color.GREEN);

			botoes[4][0].setEnabled(false);
			botoes[4][1].setEnabled(false);
			botoes[4][2].setEnabled(false);
			botoes[4][3].setEnabled(false);

			verificador[4] = 0;

			Numero_Pergunta.setAcertou();

			Premio.setAcertou();

			Tempo.tempoPergunta();
		});
		
		for(ActionListener al: botoes[5][1].getActionListeners()) {
			
			botoes[5][1].removeActionListener(al);
		}
		
		botoes[5][1].addActionListener(e -> {

			botoes[5][1].setBackground(Color.GREEN);

			botoes[5][0].setEnabled(false);
			botoes[5][1].setEnabled(false);
			botoes[5][2].setEnabled(false);
			botoes[5][3].setEnabled(false);

			verificador[5] = 0;

			Numero_Pergunta.setAcertou();

			Premio.setAcertou();

			Tempo.tempoPergunta();
		});
		
		for(ActionListener al: botoes[6][2].getActionListeners()) {
			
			botoes[6][2].removeActionListener(al);
		}
		
		botoes[6][2].addActionListener(e -> {

			botoes[6][2].setBackground(Color.GREEN);

			botoes[6][0].setEnabled(false);
			botoes[6][1].setEnabled(false);
			botoes[6][2].setEnabled(false);
			botoes[6][3].setEnabled(false);

			verificador[6] = 0;

			Numero_Pergunta.setAcertou();

			Premio.setAcertou();

			Tempo.tempoPergunta();
		});
		
		for(ActionListener al: botoes[7][3].getActionListeners()) {
			
			botoes[7][3].removeActionListener(al);
		}
		
		botoes[7][3].addActionListener(e -> {

			botoes[7][3].setBackground(Color.GREEN);

			botoes[7][0].setEnabled(false);
			botoes[7][1].setEnabled(false);
			botoes[7][2].setEnabled(false);
			botoes[7][3].setEnabled(false);

			verificador[7] = 0;

			Numero_Pergunta.setAcertou();

			Premio.setAcertou();

			Tempo.tempoPergunta();
		});
		
		for(ActionListener al: botoes[8][0].getActionListeners()) {
			
			botoes[8][0].removeActionListener(al);
		}
		
		botoes[8][0].addActionListener(e -> {

			botoes[8][0].setBackground(Color.GREEN);

			botoes[8][0].setEnabled(false);
			botoes[8][1].setEnabled(false);
			botoes[8][2].setEnabled(false);
			botoes[8][3].setEnabled(false);

			verificador[8] = 0;

			Numero_Pergunta.setAcertou();

			Premio.setAcertou();

			Tempo.tempoPergunta();
		});
		
		for(ActionListener al: botoes[9][2].getActionListeners()) {
			
			botoes[9][2].removeActionListener(al);
		}
		
		botoes[9][2].addActionListener(e -> {

			botoes[9][2].setBackground(Color.GREEN);

			botoes[9][0].setEnabled(false);
			botoes[9][1].setEnabled(false);
			botoes[9][2].setEnabled(false);
			botoes[9][3].setEnabled(false);

			verificador[9] = 0;

			Numero_Pergunta.setAcertou();

			Premio.setAcertou();

			Tempo.tempoPergunta();
		});
	}
	
	public static int getRespostaCerta(int x) {
		
		switch(x) {
		
		case 0:
			x = 1;
			break;
			
		case 1:
			x = 2;
			break;
			
		case 2:
			x = 3;
			break;
			
		case 3:
			x = 1;
			break;
			
		case 4:
			x = 0;
			break;
			
		case 5:
			x = 1;
			break;
			
		case 6:
			x = 2;
			break;
			
		case 7:
			x = 3;
			break;
			
		case 8:
			x = 0;
			break;
			
		case 9:
			x = 2;
			break;
		}
		
		return x;
	}

}
