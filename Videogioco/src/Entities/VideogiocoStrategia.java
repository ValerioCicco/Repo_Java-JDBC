package Entities;

public class VideogiocoStrategia extends Videogioco {

	public VideogiocoStrategia(String nome, String genere) {
		super(nome, genere);
	}
	
	public void pianifica() {
		System.out.println("Pianificazione strategica in corso...");
	}
}
