package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Libro;
import gestoreConnessioni.GestoreConnessioni;
import libreriaManager.LibreriaOnline;

public class LibroDAO {

	public static ArrayList<Libro> prendiLibri(GestoreConnessioni gc, LibreriaOnline libreria) {
		String query = "SELECT * FROM Libro";

		ResultSet rs = gc.eseguiStatementQuery(query);

		ArrayList<Libro> libri = libreria.getLibri();

		try {
			while (rs.next()) {
				int idLibro = Integer.parseInt(rs.getString(1));
				String titolo = rs.getString(2);
				String autore = rs.getString(3);
				String genere = rs.getString(4);
				float prezzo = Float.parseFloat(rs.getString(5));
				Libro libro = new Libro(idLibro, titolo, autore, genere, prezzo);
				libri.add(libro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return libri;
	}
}
