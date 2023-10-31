package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

	public static Connection CreateConnection(String url, String user, String password) {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connessione al database riuscita.");
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore di connessione al database.");
			return null;
		}
	}
	
	public static ResultSet eseguiQuery(Connection conn, String query) {
		try {
			//CREAZIONE STATEMENT 
			Statement stmt = conn.createStatement();
			//ESECUZIONE STATEMENT
			ResultSet rs = stmt.executeQuery(query);
			//RETURN RESULTSET
			return rs;
		} catch (Exception e) {
			System.out.println("Errore di esecuzione query.");
			return null;
		}

	}
}