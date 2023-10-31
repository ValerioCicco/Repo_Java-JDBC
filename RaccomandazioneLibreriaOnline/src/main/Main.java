package main;

import dao.UtenteDAO;
import dao.LibroDAO;
import dao.RecensioneDAO;
import entities.Libro;
import entities.Recensione;
import entities.Utente;
import gestoreConnessioni.GestoreConnessioni;
import libreriaManager.LibreriaOnline;

public class Main {

	public static void main(String[] args) {
		// TESTING
		
		//UTENTI
		Utente utente1 = new Utente(1, "Alice", "alice@example.com");
	    Utente utente2 = new Utente(2, "Bob", "bob@example.com");
	    
	    //LIBRI
	    Libro libro1 = new Libro(1, "Il Signore degli Anelli", "J.R.R. Tolkien", "Fantasy", 20.0f);
        Libro libro2 = new Libro(2, "Cronache di Narnia", "C.S. Lewis", "Fantasy", 18.0f);
        Libro libro3 = new Libro(3, "1984", "George Orwell", "Fiction", 15.0f);
        
        // Recensioni
        Recensione recensione1 = new Recensione(utente1.getIdUtente(), libro1.getIdLibro(), 5, "Fantastico libro!");
        Recensione recensione2 = new Recensione(utente2.getIdUtente(), libro1.getIdLibro(), 4, "Molto interessante.");
        Recensione recensione3 = new Recensione(utente1.getIdUtente(), libro2.getIdLibro(), 4, "Mi è piaciuto molto.");
        
        
        System.out.println(utente1);
        System.out.println(utente2);
        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(libro3);
        libro1.mostraDettagli();
        libro2.mostraDettagli();
        libro3.mostraDettagli();
        System.out.println(recensione1);
        System.out.println(recensione2);
        System.out.println(recensione3);
        
        // TEST CONNESSIONE
		String url = "jdbc:mysql://localhost:3306/libreriaonline";
		String user = "javauser";
		String pwd = "eAbrfcjiGdMo88eE";
		
		LibreriaOnline libreriaOnline = new LibreriaOnline();
		
		GestoreConnessioni gc = new GestoreConnessioni(url, user, pwd);
		gc.stabilisciConnessione();
		
		libreriaOnline.setUtenti(UtenteDAO.prendiUtenti(gc, libreriaOnline));
		libreriaOnline.setLibri(LibroDAO.prendiLibri(gc, libreriaOnline));
		libreriaOnline.setRecensioni(RecensioneDAO.prendiRecensioni(gc, libreriaOnline));
		
		System.out.println(libreriaOnline.getUtenti());
		System.out.println(libreriaOnline.getLibri());
		System.out.println(libreriaOnline.getRecensioni());
		
		
	}

}
