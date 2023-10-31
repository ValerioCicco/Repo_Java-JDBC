package interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import entities.Clienti;
import entities.Prodotti;

public interface ProdottiMethods {
public List<Prodotti> getAll() throws SQLException;
	
	public Optional<Prodotti> getById(int id) throws SQLException;
	
	public int insert(Prodotti prodotto) throws SQLException;
    public int update(Prodotti prodotto) throws SQLException;
    public int delete(int id) throws SQLException;
    public int delete(Prodotti prodotto) throws SQLException;
}
