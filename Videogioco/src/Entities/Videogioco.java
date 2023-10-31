package Entities;

public class Videogioco {
	private String nome;
	private String genere;
	
	public Videogioco(String nome, String genere) {
        this.nome = nome;
        this.genere = genere;
    }

    public void gioca() {
        System.out.println("Stai giocando a " + nome);
    }
}
