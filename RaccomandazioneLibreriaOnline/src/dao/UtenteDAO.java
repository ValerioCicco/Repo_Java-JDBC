package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Recensione;
import entities.Utente;
import gestoreConnessioni.GestoreConnessioni;
import libreriaManager.LibreriaOnline;

public class UtenteDAO {
	public static ArrayList<Utente> prendiUtenti(GestoreConnessioni gc, LibreriaOnline libreria) {
		String query = "SELECT * FROM Utente";
		
		ResultSet rs = gc.eseguiStatementQuery(query);
		
		ArrayList<Utente> utenti = libreria.getUtenti();
		
		try {
			while(rs.next()) {
				int idUtente = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				String email = rs.getString(3);
				
				Utente utente = new Utente(idUtente, nome, email);
				utenti.add(utente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return utenti;
		
		
	}
}
