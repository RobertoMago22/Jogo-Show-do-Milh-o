package Jogo_ShowMilhao;

public class Numero_Pergunta {

	private static int numero = 1;
	
	public static int getComeco() {
		
		return numero;
	}
	
	public static void setAcertou() {
		
		numero++;
		
	}
	
	public static void setErrou() {
		
		numero = 1;
		
	}
	
}
