import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import dao.DatabaseManager;


public class MainJDBC {
	
	public final static String myUrl = "jdbc:mysql://localhost:3306/negozio";
	public static void main(String[] args) throws ParseException, SQLException {
		
		//SCRIVERE QUERY
		//String query = "SELECT * FROM prodotti;";
		//CREA CONNESSIONE
		Connection myConn = DatabaseManager.CreateConnection(myUrl, "javauser", "eAbrfcjiGdMo88eE");
		//ESEGUIRE LA QUERY
		//ResultSet rs = DatabaseManager.eseguiQuery(myConn, query);
		//STAMPARE RISULTATO
		//Utility.StampaResultSet(rs);
		Shop shop = new Shop(myConn);
		try {
			shop.esegui();
		} catch (ParseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
