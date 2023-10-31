package dto;

import java.sql.SQLException;

import entities.Prodotti;

public class ProdottoDTO {
	
	public int insert(Prodotti prodotto) throws SQLException {
		return 0;
		
	}
	
    public int update(Prodotti prodotto) throws SQLException {
		return 0;
    	
    }
    public int delete(int id) throws SQLException {
		return id;
    	
    }
}
