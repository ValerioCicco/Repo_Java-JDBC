package Repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import entities.Clienti;
import interfaces.ClientiMethods;

public class ClientRepository implements ClientiMethods {

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
		
		return;
	}

	@Override
	public int update(Clienti cliente) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
