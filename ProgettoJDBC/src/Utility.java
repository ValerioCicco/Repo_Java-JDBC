import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Utility {

	public static void StampaResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				ResultSetMetaData metaData = rs.getMetaData();
				int nColonne = metaData.getColumnCount();
				System.out.println("--- STAMPA " + metaData.getTableName(1) + " ---");
				String nomeColonne = "";
				for(int i = 1; i <= nColonne; i++) {
					nomeColonne += metaData.getColumnName(i) + " - ";
				}

				System.out.println(nomeColonne);
				
				while (rs.next()) {
					//MI SERVE UN getString di N valori (colonne)
					//RECUPERARE VALORE DI N
					//stringa in cui ci sono tutti i valori (n) aggiunti tramite loop
					String row = "";
					for(int i = 0; i < nColonne; i++) {
						row += rs.getString(i + 1) + " - ";
					}

					System.out.println(row);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore durante la stampa dei risultati.");
			}
		}

	}
}
