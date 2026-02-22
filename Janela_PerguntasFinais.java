package Jogo_ShowMilhao;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Janela_PerguntasFinais {
	
	
	private static CardLayout card;
	private static JPanel painelPerguntas;
	private static int[] verificador = new int[10];
	private static JLabel[] perguntaFinal = new JLabel[10];
	private static JButton[][] botoes = new JButton[10][4];

	public static void janela_PerguntasFinais() {
	
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

//-----------------------------------------------Layout Perguntas-------------------------------------------

	perguntaFinal = new JLabel[10];

	for (int i = 0; i < 10; i++) {

		perguntaFinal[i] = new JLabel();

		perguntaFinal[i].setOpaque(true);
		perguntaFinal[i].setVerticalAlignment(SwingConstants.CENTER);
		perguntaFinal[i].setHorizontalAlignment(SwingConstants.CENTER);
		perguntaFinal[i].setBackground(Color.red);
		perguntaFinal[i].setForeground(Color.white);
		perguntaFinal[i].setBounds(20, 20, 1250, 200);
		perguntaFinal[i].setFont(new Font("Arial", Font.BOLD, 20));

		pergunta[i].add(perguntaFinal[i]);

	}
	
	perguntaFinal[6].setBounds(20, 20, 1250, 300);
	
//--------------------------------------PerguntasFinais-------------------------------------------------------

	Janela_PerguntasFinais.setPerguntas();

//-------------------------------------------------Layout Botoes-------------------------------------------

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
	
	botoes[6][0].setBounds(20, 350, 450, 30);
	botoes[6][1].setBounds(20, 400, 450, 30);
	botoes[6][2].setBounds(20, 450, 450, 30);
	botoes[6][3].setBounds(20, 500, 450, 30);

//------------------------------------------Opções---------------------------------------------------------

//------------------------------------------Pergunta 1-----------------------------------------------------------

	botoes[0][0].setText("1) 10");
	botoes[0][1].setText("2) 12");
	botoes[0][2].setText("3) 14");
	botoes[0][3].setText("4) 20");
//------------------------------------------Pergunta 2-----------------------------------------------------------			
	botoes[1][0].setText("1) 5 5");
	botoes[1][1].setText("2) 6 6");
	botoes[1][2].setText("3) 5 6");
	botoes[1][3].setText("4) 6 5");
//------------------------------------------Pergunta 3-----------------------------------------------------------			
	botoes[2][0].setText("1) 11");
	botoes[2][1].setText("2) 12");
	botoes[2][2].setText("3) 13");
	botoes[2][3].setText("4) 14");
//------------------------------------------Pergunta 4-----------------------------------------------------------			
	botoes[3][0].setText("1) 11");
	botoes[3][1].setText("2) 12");
	botoes[3][2].setText("3) 13");
	botoes[3][3].setText("4) 14");
//------------------------------------------Pergunta 5-----------------------------------------------------------			
	botoes[4][0].setText("1) 10 20");
	botoes[4][1].setText("2) 20 20");
	botoes[4][2].setText("3) 30 20");
	botoes[4][3].setText("4) 20 30");
//------------------------------------------Pergunta 6-----------------------------------------------------------			
	botoes[5][0].setText("1) 3 Java");
	botoes[5][1].setText("2) 4 Java");
	botoes[5][2].setText("3) 5 Java");
	botoes[5][3].setText("4) 6 Java");
//------------------------------------------Pergunta 7-----------------------------------------------------------			
	botoes[6][0].setText("1) 5");
	botoes[6][1].setText("2) 6");
	botoes[6][2].setText("3) 7");
	botoes[6][3].setText("4) Compilation error");
//------------------------------------------Pergunta 8-----------------------------------------------------------			
	botoes[7][0].setText("1) Nada será impresso");
	botoes[7][1].setText("2) 1");
	botoes[7][2].setText("3) 2");
	botoes[7][3].setText("4) 3");
//------------------------------------------Pergunta 9-----------------------------------------------------------			
	botoes[8][0].setText("1) 1 2 3 ");
	botoes[8][1].setText("2) 0 1 2");
	botoes[8][2].setText("3) 1 2");
	botoes[8][3].setText("4) 0 1 2 3");
//------------------------------------------Pergunta 10-----------------------------------------------------------			
	botoes[9][0].setText("1) 6");
	botoes[9][1].setText("2) 8");
	botoes[9][2].setText("3) 9");
	botoes[9][3].setText("4) 12");

//---------------------------------------Ação dos Botoes---------------------------------------------------

	for(int i = 0; i < 10; i++) {
		
		int x = i;
		
		for(int j = 0; j < 4; j++) {
		
			int  y= j;
			
			botoes[x][y].addActionListener(e -> {

				botoes[x][y].setBackground(Color.YELLOW);
				botoes[x][Janela_PerguntasFinais.getRespostaCerta(x)].setBackground(Color.GREEN);

				botoes[x][0].setEnabled(false);
				botoes[x][1].setEnabled(false);
				botoes[x][2].setEnabled(false);
				botoes[x][3].setEnabled(false);

				verificador[x] = 1;

				Premio.setFinal();

				Tempo.tempoFim();

				Numero_Pergunta.setErrou();
			});
		}
	}
	
	Janela_PerguntasFinais.setRespostasCertas();		
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

	perguntaFinal[0].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída do código?<br></br>"
							+ "<br></br>"
							+ "int x = 1;<br></br>"
							+ "x = x++ + ++x * x++;<br></br>"
							+ "System.out.println(x);</html>");

	perguntaFinal[1].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída?<br></br>"
							+ "<br></br>"
							+ "int x = 5;<br></br>"
							+ "int y = x++;<br></br>"
							+ "System.out.println(x + \" \" + y);<br></br></html>");

	perguntaFinal[2].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será o valor de y?<br></br>"
							+ "<br></br>"
							+ "int x = 5;<br></br>"
							+ "int y = ++x + x++;<br></br>"
							+ "System.out.println(y);</html>");

	perguntaFinal[3].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será o valor de y?<br></br>"
							+ "<br></br>"
							+ "int x = 3;<br></br>"
							+ "int y = x++ + ++x + x;<br></br>"
							+ "System.out.println(y);</html>");

	perguntaFinal[4].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída?<br></br>"
							+ "<br></br>"
							+ "int[] arr = {10, 20, 30};<br></br>"
							+ "int i = 0;<br></br>"
							+ "arr[i++] = arr[++i];<br></br>"
							+ "System.out.println(arr[0] + \" \" + arr[1]);</html>");

	perguntaFinal[5].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída?<br></br>"
							+ "<br></br>"
							+ "int x = 1;<br></br>"
							+ "System.out.println(x++ + ++x + \" Java\");</html>");

	perguntaFinal[6].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída?<br></br>"
							+ "<br></br>"
							+ "public static void main(String[] args) {<br></br>"
							+ "    int x = 5;<br></br>"
							+ "    test(x++);<br></br>"
							+ "    System.out.println(x);<br></br>"
							+ "}<br></br>"
							+ "<br></br>"
							+ "static void test(int x) {<br></br>"
							+ "    x++;<br></br>"
							+ "}</html>");

	perguntaFinal[7].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída?<br></br>"
							+ "<br></br>"
							+ "int x = 0;<br></br>"
							+ "if (x++ == 0 && ++x == 2) {<br></br>"
							+ "    System.out.println(x);<br></br>"
							+ "}</html>");

	perguntaFinal[8].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída?<br></br>"
							+"<br></br>"
							+ "int i = 0;<br></br>"
							+ "while (i++ < 3) {<br></br>"
							+ "    System.out.print(i + \" \");<br></br>"
							+ "}</html>");

	perguntaFinal[9].setText("<html>" + Numero_Pergunta.getComeco() + "- Qual será a saída?<br></br>"
							+"<br></br>"
							+ "int x = 2;<br></br>"
							+ "int y = x++ * ++x;<br></br>"
							+ "System.out.println(y);</html>");
}

public static void setRespostasCertas() {
	
	for(ActionListener al: botoes[0][0].getActionListeners()) {
		
		botoes[0][0].removeActionListener(al);
	}
	
	botoes[0][0].addActionListener(e -> {

		botoes[0][0].setBackground(Color.GREEN);

		botoes[0][0].setEnabled(false);
		botoes[0][1].setEnabled(false);
		botoes[0][2].setEnabled(false);
		botoes[0][3].setEnabled(false);

		verificador[0] = 0;

		Premio.setFinal();

		Tempo.tempoFinal();

		Numero_Pergunta.setErrou();
	});
	
	for(ActionListener al: botoes[1][3].getActionListeners()) {
		
		botoes[1][3].removeActionListener(al);
	}
	
	botoes[1][3].addActionListener(e -> {

		botoes[1][3].setBackground(Color.GREEN);

		botoes[1][0].setEnabled(false);
		botoes[1][1].setEnabled(false);
		botoes[1][2].setEnabled(false);
		botoes[1][3].setEnabled(false);

		verificador[1] = 0;

		Premio.setFinal();

		Tempo.tempoFinal();

		Numero_Pergunta.setErrou();
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

		Premio.setFinal();

		Tempo.tempoFinal();

		Numero_Pergunta.setErrou();
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

		Premio.setFinal();

		Tempo.tempoFinal();

		Numero_Pergunta.setErrou();
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

		Premio.setFinal();

		Tempo.tempoFinal();

		Numero_Pergunta.setErrou();
	});
	
	for(ActionListener al: botoes[5][2].getActionListeners()) {
		
		botoes[5][2].removeActionListener(al);
	}
	
	botoes[5][2].addActionListener(e -> {

		botoes[5][2].setBackground(Color.GREEN);

		botoes[5][0].setEnabled(false);
		botoes[5][1].setEnabled(false);
		botoes[5][2].setEnabled(false);
		botoes[5][3].setEnabled(false);

		verificador[5] = 0;

		Premio.setFinal();

		Tempo.tempoFinal();

		Numero_Pergunta.setErrou();
	});
	
	for(ActionListener al: botoes[6][1].getActionListeners()) {
		
		botoes[6][1].removeActionListener(al);
	}
	
	botoes[6][1].addActionListener(e -> {

		botoes[6][1].setBackground(Color.GREEN);

		botoes[6][0].setEnabled(false);
		botoes[6][1].setEnabled(false);
		botoes[6][2].setEnabled(false);
		botoes[6][3].setEnabled(false);

		verificador[6] = 0;

		Premio.setFinal();

		Tempo.tempoFinal();

		Numero_Pergunta.setErrou();
	});
	
	for(ActionListener al: botoes[7][2].getActionListeners()) {
		
		botoes[7][2].removeActionListener(al);
	}
	
	botoes[7][2].addActionListener(e -> {

		botoes[7][2].setBackground(Color.GREEN);

		botoes[7][0].setEnabled(false);
		botoes[7][1].setEnabled(false);
		botoes[7][2].setEnabled(false);
		botoes[7][3].setEnabled(false);

		verificador[7] = 0;

		Premio.setFinal();

		Tempo.tempoFinal();

		Numero_Pergunta.setErrou();
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

		Premio.setFinal();

		Tempo.tempoFinal();

		Numero_Pergunta.setErrou();
	});
	
	for(ActionListener al: botoes[9][3].getActionListeners()) {
		
		botoes[9][3].removeActionListener(al);
	}
	
	botoes[9][3].addActionListener(e -> {

		botoes[9][3].setBackground(Color.GREEN);

		botoes[9][0].setEnabled(false);
		botoes[9][1].setEnabled(false);
		botoes[9][2].setEnabled(false);
		botoes[9][3].setEnabled(false);

		verificador[9] = 0;

		Premio.setFinal();

		Tempo.tempoFinal();

		Numero_Pergunta.setErrou();
	});
}

	public static int getRespostaCerta(int x) {
		
		switch(x) {
		
		case 0:
			x = 0;
			break;
			
		case 1:
			x = 3;
			break;
			
		case 2:
			x = 1;
			break;
			
		case 3:
			x = 1;
			break;
			
		case 4:
			x = 2;
			break;
			
		case 5:
			x = 2;
			break;
			
		case 6:
			x = 1;
			break;
			
		case 7:
			x = 2;
			break;
			
		case 8:
			x = 0;
			break;
			
		case 9:
			x = 3;
			break;
		}
		
		return x;
	}

}
