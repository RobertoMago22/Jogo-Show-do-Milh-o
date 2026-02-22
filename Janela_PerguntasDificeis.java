package Jogo_ShowMilhao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

public class Janela_PerguntasDificeis {
	
	private static CardLayout card;
	private static JPanel painelPerguntas;
	private static int[] verificador = new int[10];
	private static JLabel[] perguntaDificel = new JLabel[10];
	private static JButton[][] botoes = new JButton[10][4];

	public static void janela_PerguntasDificeis() {
	
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

	perguntaDificel = new JLabel[10];

	for (int i = 0; i < 10; i++) {

		perguntaDificel[i] = new JLabel();

		perguntaDificel[i].setOpaque(true);
		perguntaDificel[i].setVerticalAlignment(SwingConstants.CENTER);
		perguntaDificel[i].setHorizontalAlignment(SwingConstants.CENTER);
		perguntaDificel[i].setBackground(Color.red);
		perguntaDificel[i].setForeground(Color.white);
		perguntaDificel[i].setBounds(20, 20, 1250, 100);
		perguntaDificel[i].setFont(new Font("Arial", Font.BOLD, 20));

		pergunta[i].add(perguntaDificel[i]);

	}
	
	perguntaDificel[0].setBounds(20, 20, 1250, 200);
	perguntaDificel[1].setBounds(20, 20, 1250, 200);
	perguntaDificel[2].setBounds(20, 20, 1250, 200);
	perguntaDificel[3].setBounds(20, 20, 1250, 200);
	perguntaDificel[5].setBounds(20, 20, 1250, 200);
	perguntaDificel[7].setBounds(20, 20, 1250, 200);

//--------------------------------------PerguntasFaceis-------------------------------------------------------

	Janela_PerguntasDificeis.setPerguntas();

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
	
	botoes[8][0].setBounds(20, 300, 450, 30);
	botoes[8][1].setBounds(20, 350, 450, 30);
	botoes[8][2].setBounds(20, 400, 450, 30);
	botoes[8][3].setBounds(20, 450, 450, 30);

//------------------------------------------Opções---------------------------------------------------------

//------------------------------------------Pergunta 1-----------------------------------------------------------

	botoes[0][0].setText("1) 0");
	botoes[0][1].setText("2) 2");
	botoes[0][2].setText("3) 3");
	botoes[0][3].setText("4) 4");
//------------------------------------------Pergunta 2-----------------------------------------------------------			
	botoes[1][0].setText("1) 0");
	botoes[1][1].setText("2) 1");
	botoes[1][2].setText("3) 5");
	botoes[1][3].setText("4) Erro");
//------------------------------------------Pergunta 3-----------------------------------------------------------			
	botoes[2][0].setText("1) Falta ponto e vírgula");
	botoes[2][1].setText("2) Uso incorreto do operador =");
	botoes[2][2].setText("3) x não foi declarado");
	botoes[2][3].setText("4) Não há erro");
//------------------------------------------Pergunta 4-----------------------------------------------------------			
	botoes[3][0].setText("1) 1");
	botoes[3][1].setText("2) 2");
	botoes[3][2].setText("3) 3");
	botoes[3][3].setText("4) 4");
//------------------------------------------Pergunta 5-----------------------------------------------------------			
	botoes[4][0].setText("1) O código não compila");
	botoes[4][1].setText("2) Executa uma vez");
	botoes[4][2].setText("3) Loop infinito");
	botoes[4][3].setText("4) O programa ignora o laço");
//------------------------------------------Pergunta 6-----------------------------------------------------------			
	botoes[5][0].setText("1) Erro");
	botoes[5][1].setText("2) Ok");
	botoes[5][2].setText("3) Nada");
	botoes[5][3].setText("4) false");
//------------------------------------------Pergunta 7-----------------------------------------------------------			
	botoes[6][0].setText("1) ||");
	botoes[6][1].setText("2) !");
	botoes[6][2].setText("3) &");
	botoes[6][3].setText("4) &&");
//------------------------------------------Pergunta 8-----------------------------------------------------------			
	botoes[7][0].setText("1) 012");
	botoes[7][1].setText("2) 123");
	botoes[7][2].setText("3) 0123");
	botoes[7][3].setText("4) 321");
//------------------------------------------Pergunta 9-----------------------------------------------------------			
	botoes[8][0].setText("1) Não há diferança");
	botoes[8][1].setText("2) do while executa pelo menos uma vez");
	botoes[8][2].setText("3) while executa mais rápido");
	botoes[8][3].setText("4) do while não usa condição");
//------------------------------------------Pergunta 10-----------------------------------------------------------			
	botoes[9][0].setText("1) O laço termina normalmente");
	botoes[9][1].setText("2) Erro de compilação");
	botoes[9][2].setText("3) Loop infinito");
	botoes[9][3].setText("4) O código não executa");

//---------------------------------------Ação dos Botoes---------------------------------------------------

	for(int i = 0; i < 10; i++) {
		
		int x = i;
		
		for(int j = 0; j < 4; j++) {
		
			int  y= j;
			
			botoes[x][y].addActionListener(e -> {

				botoes[x][y].setBackground(Color.YELLOW);
				botoes[x][Janela_PerguntasDificeis.getRespostaCerta(x)].setBackground(Color.GREEN);

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
	
	Janela_PerguntasDificeis.setRespostasCertas();		
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

	perguntaDificel[0].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída do código?<br></br>"
							+ "<br></br>"
							+ "int x = 0;<br></br>"
							+ "do {<br></br>"
							+ "    x++;<br></br>"
							+ "} while (x &lt; 3);<br></br>"
							+ "System.out.println(x);</html>");

	perguntaDificel[1].setText("<html>" + Numero_Pergunta.getComeco() + "- Quantas vezes será executado o while?<br></br>"
							+ "<br></br>"
							+ "int x = 5;<br></br>"
							+ "while (x &lt; 5) {<br></br>"
							+ "    x++;<br></br>"
							+ "}</html>");

	perguntaDificel[2].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual é o erro no código abaixo?<br></br>"
							+ "<br></br>"
							+ "if (x = 5) {<br></br>"
							+ "    System.out.println(x);<br></br>"
							+ "}</html>");

	perguntaDificel[3].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída?<br></br>"
							+ "<br></br>"
							+ "int x = 1;<br></br>"
							+ "for (; x &lt;= 3; x++) {}<br></br>"
							+ "System.out.println(x);</html>");

	perguntaDificel[4].setText("<html>" + Numero_Pergunta.getComeco() + "- O que acontece se a condição do while "
							+ "for sempre verdadeira?</html>");

	perguntaDificel[5].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída?<br></br>"
							+ "<br></br>"
							+ "int x = 10;<br></br>"
							+ "if (x &gt; 5 && x &lt; 15) {<br></br>"
							+ "    System.out.println(\"OK\");<br></br>"
							+ "}</html>");

	perguntaDificel[6].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual operador representa “E” lógico em Java?</html>");

	perguntaDificel[7].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída?<br></br>"
							+ "<br></br>"
							+ "int x = 0;<br></br>"
							+ "while (x &lt; 3) {<br></br>"
							+ "    System.out.print(x);<br></br>"
							+ "    x++;<br></br>"
							+ "}</html>");

	perguntaDificel[8].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual é a principal diferença entre "
							+ "while e do while?</html>");

	perguntaDificel[9].setText("<html>" + Numero_Pergunta.getComeco() + "- O que acontece se esquecer de "
							+ "incrementar a variável de controle em um laço?</html>");
}

public static void setRespostasCertas() {
	
	for(ActionListener al: botoes[0][2].getActionListeners()) {
		
		botoes[0][2].removeActionListener(al);
	}
	
	botoes[0][2].addActionListener(e -> {

		botoes[0][2].setBackground(Color.GREEN);

		botoes[0][0].setEnabled(false);
		botoes[0][1].setEnabled(false);
		botoes[0][2].setEnabled(false);
		botoes[0][3].setEnabled(false);

		verificador[0] = 0;

		Numero_Pergunta.setAcertou();

		Premio.setAcertou();

		Tempo.tempoPergunta();
	});
	
	for(ActionListener al: botoes[1][0].getActionListeners()) {
		
		botoes[1][0].removeActionListener(al);
	}
	
	botoes[1][0].addActionListener(e -> {

		botoes[1][0].setBackground(Color.GREEN);

		botoes[1][0].setEnabled(false);
		botoes[1][1].setEnabled(false);
		botoes[1][2].setEnabled(false);
		botoes[1][3].setEnabled(false);

		verificador[1] = 0;

		Numero_Pergunta.setAcertou();

		Premio.setAcertou();

		Tempo.tempoPergunta();
	});
	
	for(ActionListener al: botoes[2][1].getActionListeners()) {
		
		botoes[2][1].removeActionListener(al);
	}
	
	botoes[2][1].addActionListener(e -> {

		botoes[2][1].setBackground(Color.GREEN);

		botoes[2][0].setEnabled(false);
		botoes[2][1].setEnabled(false);
		botoes[2][2].setEnabled(false);
		botoes[2][3].setEnabled(false);

		verificador[2] = 0;

		Numero_Pergunta.setAcertou();

		Premio.setAcertou();

		Tempo.tempoPergunta();
	});
	
	for(ActionListener al: botoes[3][3].getActionListeners()) {
		
		botoes[3][3].removeActionListener(al);
	}
	
	botoes[3][3].addActionListener(e -> {

		botoes[3][3].setBackground(Color.GREEN);

		botoes[3][0].setEnabled(false);
		botoes[3][1].setEnabled(false);
		botoes[3][2].setEnabled(false);
		botoes[3][3].setEnabled(false);

		verificador[3] = 0;

		Numero_Pergunta.setAcertou();

		Premio.setAcertou();

		Tempo.tempoPergunta();
	});
	
	for(ActionListener al: botoes[4][2].getActionListeners()) {
		
		botoes[4][2].removeActionListener(al);
	}
	
	botoes[4][2].addActionListener(e -> {

		botoes[4][2].setBackground(Color.GREEN);

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
	
	for(ActionListener al: botoes[6][3].getActionListeners()) {
		
		botoes[6][3].removeActionListener(al);
	}
	
	botoes[6][3].addActionListener(e -> {

		botoes[6][3].setBackground(Color.GREEN);

		botoes[6][0].setEnabled(false);
		botoes[6][1].setEnabled(false);
		botoes[6][2].setEnabled(false);
		botoes[6][3].setEnabled(false);

		verificador[6] = 0;

		Numero_Pergunta.setAcertou();

		Premio.setAcertou();

		Tempo.tempoPergunta();
	});
	
	for(ActionListener al: botoes[7][0].getActionListeners()) {
		
		botoes[7][0].removeActionListener(al);
	}
	
	botoes[7][0].addActionListener(e -> {

		botoes[7][0].setBackground(Color.GREEN);

		botoes[7][0].setEnabled(false);
		botoes[7][1].setEnabled(false);
		botoes[7][2].setEnabled(false);
		botoes[7][3].setEnabled(false);

		verificador[7] = 0;

		Numero_Pergunta.setAcertou();

		Premio.setAcertou();

		Tempo.tempoPergunta();
	});
	
	for(ActionListener al: botoes[8][1].getActionListeners()) {
		
		botoes[8][1].removeActionListener(al);
	}
	
	botoes[8][1].addActionListener(e -> {

		botoes[8][1].setBackground(Color.GREEN);

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
			x = 2;
			break;
			
		case 1:
			x = 0;
			break;
			
		case 2:
			x = 1;
			break;
			
		case 3:
			x = 3;
			break;
			
		case 4:
			x = 2;
			break;
			
		case 5:
			x = 1;
			break;
			
		case 6:
			x = 3;
			break;
			
		case 7:
			x = 0;
			break;
			
		case 8:
			x = 1;
			break;
			
		case 9:
			x = 2;
			break;
		}
		
		return x;
	}

}
