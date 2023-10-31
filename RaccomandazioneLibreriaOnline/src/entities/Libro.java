package entities;

import java.util.ArrayList;

public class Libro {
	private int idLibro;
	private String titolo;
	private String autore;
	private String genere;
	private float prezzo;
	
	private ArrayList<Recensione> recensioni;
	
	public Libro(int idLibro, String titolo, String autore, String genere, float prezzo) {
		this.idLibro = idLibro;
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.prezzo = prezzo;
		this.recensioni = new ArrayList<>();
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int id) {
		this.idLibro = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public ArrayList<Recensione> getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(ArrayList<Recensione> recensioni) {
		this.recensioni = recensioni;
	}
	
	public String mostraDettagli() {
		return "Id: " + idLibro + "\nTitolo: " + titolo + "\nAutore: " + autore + "\nGenere: " + genere + "\nPrezzo: " + prezzo + " €" + "\nRecensioni: " + recensioni;
	}
	
	public String toString() {
		return mostraDettagli();
	}
	
	
}
