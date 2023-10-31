package interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import entities.Clienti;

public interface ClientiMethods {
	public List<Clienti> getAll() throws SQLException;
	
	public Optional<Clienti> getById(int id) throws SQLException;
	
	public void insert(Clienti cliente) throws SQLException;
    public int update(Clienti cliente) throws SQLException;
    public int delete(int id) throws SQLException;
    public int delete(Clienti cliente) throws SQLException;
}
