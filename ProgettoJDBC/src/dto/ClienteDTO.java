package dto;
import java.sql.Connection;
import java.sql.SQLException;

import dao.ClientiDAO;
import dao.DatabaseManager;
import entities.Clienti;

public class ClienteDTO {
	
	ClientiDAO dao = new ClientiDAO(DatabaseManager.CreateConnection("jdbc:mysql://localhost:3306/negozio", "javauser", "eAbrfcjiGdMo88eE"));
	
	public void insert(Clienti cliente) throws SQLException {
		dao.insert(cliente);
	}
	
    public int update(Clienti cliente) throws SQLException {
		return 0;
    	
    }
    public int delete(int id) throws SQLException {
		return id;
    	
    }
}
