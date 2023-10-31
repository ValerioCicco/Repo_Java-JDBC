package Entities;

import java.util.List;

public class Admin {
	
	private List<String> richieste;
	private String nomeUtente;
	private String password;
	private boolean isLogged;
	
	public Admin(List<String> richieste, String nomeUtente, String password) {
		this.richieste = richieste;
		this.nomeUtente = nomeUtente;
		this.password = password;
		this.isLogged = false;
	}
	
	//COSTRUTTORE DA USARE PER UTENTE
	public Admin(String nomeUtente2, String password2) {
		
	}
	
	//METODI LOGIN E LOGOUT
	
	public boolean login(String nomeUtente, String password) {
		if(this.nomeUtente.equals(nomeUtente) && this.password.equals(password)) {
			isLogged = true;
			System.out.println("Loggato con successo");
			return true;
		}
		return false;
	}
	
	public void logout() {
		isLogged = false;
	}
	
	public boolean isLoggedIn() {
		return isLogged;
	}

	//CREARE METODI DI GESTIONE RICHIESTE, AGGIUNTA RICHIESTE, MODIFICA RICHIESTE(?)
	//RIMOZIONE RICHIESTE
	
	public void aggiungiRichiesta(String ric) {
		richieste.add(ric);
	}
	
	public void rimuoviRichiesta(String ric) {
		richieste.remove(ric);
	}
	
	public void gestisciRichieste() {
		for(String ric : richieste) {
			if(!ric.isEmpty()) {
				System.out.println("Non ci sono richieste");
			}
			else {
				System.out.println(ric);
			}
		}
	}
}
