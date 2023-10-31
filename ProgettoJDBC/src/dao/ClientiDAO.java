package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import entities.Clienti;
import interfaces.ClientiMethods;

public class ClientiDAO implements ClientiMethods {
	
	private final Connection conn;
	
	
	public ClientiDAO(Connection conn) {
		this.conn = conn;
	}

	public ClientiDAO(String dbName, String user, String password) throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, user, password);
    }

	@Override
	public List<Clienti> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Clienti> getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void insert(Clienti cliente) throws SQLException {
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM clienti",
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();

			// Sposta il cursore del result set nella posizione di inserimento
			rs.moveToInsertRow();

//			System.out.print("Inserisci la mail: ");
//			String mail = scanner.nextLine();
//			System.out.print("Inserisci l'username: ");
//			String username = scanner.nextLine();
//			System.out.print("Inserisci il nome: ");
//			String nome = scanner.nextLine();
//			System.out.print("Inserisci il cognome: ");
//			String cognome = scanner.nextLine();
//			System.out.print("Inserisci indirizzo: ");
//			String indirizzo = scanner.nextLine();

			// Imposto i valori per le colonne
			rs.updateString("EmailClienti", cliente.getEmailClienti());
			rs.updateString("Username", cliente.getUsername());
			rs.updateString("Nome", cliente.getNome());
			rs.updateString("Cognome", cliente.getCognome());
			rs.updateString("Indirizzo", cliente.getIndirizzo());

			// Comando che esegue l'operazione di inserimento
			rs.insertRow();

			rs.moveToCurrentRow();
			

			System.out.println("L'utente è stato inserito correttamente.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante l'inserimento dell'utente.");
		}
	}

	@Override
	public int update(Clienti cliente) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("UPDATE clienti " + 
				"SET " +
				"EmailClienti = ?, "+
				"Username = ?, " +
				"Nome = ?, " + 
				"Cognome = ?, " +
				"Indirizzo = ? ");
				
				
		pstmt.setString(1, cliente.getEmailClienti());
		pstmt.setString(2, cliente.getUsername());
		pstmt.setString(3, cliente.getNome());
		pstmt.setString(4, cliente.getCognome());
		pstmt.setString(5, cliente.getIndirizzo());
		
		int result = pstmt.executeUpdate();
		
		return result;
	}

	@Override
	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Clienti cliente) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
