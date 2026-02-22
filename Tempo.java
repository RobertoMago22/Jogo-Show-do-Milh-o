package Jogo_ShowMilhao;

import javax.swing.*;

public class Tempo {
	
	private static Timer timer;
	private static Timer timer2;
	private static Timer timer3;
	private static Timer timer4;
	
	public static void tempo() {
		
		timer = new Timer(3000, e-> {
			
			if(Numero_Pergunta.getComeco() <= 5) {
				
				Janela.setAddTela(Janela_PerguntasFaceis.getPerguntas(), "Tela Pergunta");
				Janela.setTela("Tela Pergunta");
			}
			
			else if(Numero_Pergunta.getComeco() <= 10) {
				
				Janela.setAddTela(Janela_PerguntasMedias.getPerguntas(), "Tela Pergunta");
				Janela.setTela("Tela Pergunta");
			}
			
			else if(Numero_Pergunta.getComeco() <= 15) {
				
				Janela.setAddTela(Janela_PerguntasDificeis.getPerguntas(), "Tela Pergunta");
				Janela.setTela("Tela Pergunta");
			}
			
			else if(Numero_Pergunta.getComeco() == 16) {
	
				Janela.setAddTela(Janela_PerguntasFinais.getPerguntas(), "Tela Pergunta");
				Janela.setTela("Tela Pergunta");
			}
			
		});
		
		timer.setRepeats(false);
		
		timer.start();
		
	}
	
	public static void tempoPergunta() {
		
		timer2 = new Timer(3000, e->{
			
			Janela.setAddTela(Premio.getProximoPremio(), "Tela Premio");
			Janela.setTela("Tela Premio");
			
			
			if(Numero_Pergunta.getComeco() <= 5) {
				
				Janela_PerguntasFaceis.setPerguntas();
			}
			
			else if(Numero_Pergunta.getComeco() <= 10) {
				
				Janela_PerguntasMedias.setPerguntas();
			}
			
			else if(Numero_Pergunta.getComeco() <= 15) {
				
				Janela_PerguntasDificeis.setPerguntas();
			}
			
			else if(Numero_Pergunta.getComeco() == 16) {
				
				Janela_PerguntasFinais.setPerguntas();
			}
			
			Tempo.tempo();
		});
		timer2.setRepeats(false);
		timer2.start();
	}
	
	public static void tempoComeco() {
		
		timer4 = new Timer(3000, e->{
			
			Janela.setTela("Tela 1");
		});
		
		timer4.setRepeats(false);
		timer4.start();
		
	}
	
	public static void tempoFim() {
		
		timer3 = new Timer(3000, e->{
			
			Janela.setAddTela(Premio.getFim(), "Tela Fim");
			Janela.setTela("Tela Fim");
			
			Tempo.tempoComeco();
		
		});
		
		timer3.setRepeats(false);
		timer3.start();
	}
	
	public static void tempoFinal() {
		
		timer3 = new Timer(3000, e->{
			
			Janela.setAddTela(Premio.getFinal(), "Tela Final");
			Janela.setTela("Tela Final");
			
			Tempo.tempoComeco();
		
		});
		
		timer3.setRepeats(false);
		timer3.start();
	}
	

}
