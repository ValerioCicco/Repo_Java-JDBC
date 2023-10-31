package entities;

import java.util.ArrayList;
import java.util.HashSet;

public class Utente {
	private int idUtente;
	private String nome;
	private String email;
	
	private ArrayList<Libro> libriAcquistati;
	private HashSet<String> generi;
	
	public Utente(int idUtente, String nome, String email) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.email = email;
		this.libriAcquistati = new ArrayList<>();
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int id) {
		this.idUtente = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Libro> getLibriAcquistati() {
		return libriAcquistati;
	}

	public void setLibriAcquistati(ArrayList<Libro> libriAcquistati) {
		this.libriAcquistati = libriAcquistati;
	}
	
	public Recensione lasciaRecensioni(Libro l, int valutazione, String commento) {
		return new Recensione(this.getIdUtente(), l.getIdLibro(), valutazione, commento);
	}
	
	public void acquistaLibro (Libro libro) {
		libriAcquistati.add(libro);
	}
	
	/*
	 * public ArrayList<Libro> raccomandaLibri() { if(libriAcquistati.isEmpty()) {
	 * // bisogna far vedere i libri più popolari nel sistema }
	 * 
	 * for(Libro libro : libriAcquistati) { String genere = libro.getGenere();
	 * generi.add(genere); }
	 * 
	 * // libri stesso genere e valutazione }
	 */
	
	public String toString() {
		return "Id: " + idUtente + "Nome: " + nome + "\nEmail: " + email + "\nLibriAcquistati: " + libriAcquistati;
	}
	
	
}
