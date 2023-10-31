import java.util.ArrayList;

public class Utente {
	
	private String nome;
	//private ArrayList<Libro> libriAcquistati = new ArrayList<>();
	
	public Utente(String nome) {
        this.nome = nome;
        //this.libriAcquistati = new ArrayList<>();
    }
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
//	public ArrayList<Libro> getLibriAcquistati() {
//		return libriAcquistati;
//	}
//	
//	public void aggiungiLibro(Libro nuovoLibro) {
//		libriAcquistati.add(nuovoLibro);
//	}
//
//	public void setLibriAcquistati(ArrayList<Libro> libriAcquistati) {
//		this.libriAcquistati = libriAcquistati;
//	}

	public String toString() {
		return nome;
	}

}

