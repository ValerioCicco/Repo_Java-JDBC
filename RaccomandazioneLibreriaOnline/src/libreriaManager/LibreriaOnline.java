package libreriaManager;

import java.util.ArrayList;

import entities.Libro;
import entities.Utente;
import entities.Recensione;

public class LibreriaOnline {
	private ArrayList<Utente> utenti = new ArrayList<>();
	private ArrayList<Libro> libri = new ArrayList<>();
	private ArrayList<Recensione> recensioni = new ArrayList<>();
	
	public LibreriaOnline() {
		
	}
	
	public void aggiungiUtente(Utente u) {
		utenti.add(u);
	}
	
	public void rimuoviUtente(Utente u) {
		utenti.remove(u);
	}
	
	public void aggiungiLibro(Libro l) {
		libri.add(l);
	}
	
	public void rimuoviLibro(Libro l) {
		libri.remove(l);
	}
	
	public void aggiungiRecensione(Recensione r) {
		recensioni.add(r);
	}
	
	public void rimuoviRecensione(Recensione r) {
		recensioni.remove(r);
	}
	
	public void mostraLibri() {
		for(Libro libro: libri) {
			libro.mostraDettagli();
		}
	}
	
	// Getters & Setters
	public ArrayList<Utente> getUtenti() {
		return utenti;
	}
	public void setUtenti(ArrayList<Utente> utenti) {
		this.utenti = utenti;
	}
	public ArrayList<Libro> getLibri() {
		return libri;
	}
	public void setLibri(ArrayList<Libro> libri) {
		this.libri = libri;
	}
	public ArrayList<Recensione> getRecensioni() {
		return recensioni;
	}
	public void setRecensioni(ArrayList<Recensione> recensioni) {
		this.recensioni = recensioni;
	}
	
	
}
