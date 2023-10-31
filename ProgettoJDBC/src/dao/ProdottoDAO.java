package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import entities.Prodotti;
import interfaces.ProdottiMethods;

public class ProdottoDAO implements ProdottiMethods{
	
	private final Connection conn;
	
	
	public ProdottoDAO(Connection conn) {
		this.conn = conn;
	}

	public ProdottoDAO(String dbName, String user, String password) throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, user, password);
    }

	@Override
	public List<Prodotti> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Prodotti> getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int insert(Prodotti prodotto) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO prodotti (Marca, Modello, Descrizione, Prezzo)" +
				"VALUES (?, ?, ?, ?);");
		
		pstmt.setString(1, prodotto.getMarca());
		pstmt.setString(2, prodotto.getModello());
		pstmt.setString(3, prodotto.getDescrizione());
		pstmt.setFloat(4, prodotto.getPrezzo());
		
		int result = pstmt.executeUpdate();
		pstmt.close();
		
		
		return result;
	}

	@Override
	public int update(Prodotti prodotto) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("UPDATE prodotti " + 
				"SET " +
				"Marca = ?, "+
				"Modello = ?, " +
				"Descrizione = ?, " + 
				"Prezzo = ?, " +
				"WHERE id = " + prodotto.getId());
				
				
		pstmt.setString(1, prodotto.getMarca());
		pstmt.setString(2, prodotto.getModello());
		pstmt.setString(3, prodotto.getDescrizione());
		pstmt.setFloat(4, prodotto.getPrezzo());
		
		int result = pstmt.executeUpdate();
		
		return result;
	}

	@Override
	public int delete(int id) throws SQLException {
		PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM prodotti WHERE idProdotto = ?");
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
        preparedStatement.close();

        return result;
	}

	@Override
	public int delete(Prodotti prodotto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
