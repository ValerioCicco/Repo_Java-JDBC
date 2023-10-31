package Entities;

public class VideogiocoAzione extends Videogioco {

	public VideogiocoAzione(String nome, String genere) {
		super(nome, genere);
	}
	
	public void combatti() {
		System.out.println("Combattimento in corso...");
	}
}
