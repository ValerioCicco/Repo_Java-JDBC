
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.DatabaseManager;
import dto.ClienteDTO;
import entities.Clienti;

public class Shop {
	private Connection connection;
	private Scanner scanner;
	private Admin admin;
	private Utente utente;

	public Shop(Connection connection) {
		this.connection = connection;
		this.scanner = new Scanner(System.in);
	}

	public void esegui() throws ParseException, SQLException {
		boolean exit = false;
		while (!exit) {
			System.out.println("Benvenuto!");
			System.out.println("1. Accedi come admin");
			System.out.println("2. Accedi come utente");
			System.out.println("3. Esci");
			System.out.println("Risposta: ");

			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta) {
			case 1:
				admin = creaAdmin();
				gestisciAdmin();
				break;
			case 2:
				utente = creaUtente();
				gestisciUtente();
				break;
			case 3:
				exit = true;
				break;
			default:
				System.out.println("Scelta non valida. Riprova.");
			}
		}
	}

	public void gestisciAdmin() throws ParseException, SQLException {
		while (true) {
			System.out.println("Benvenuto, " + admin);
			System.out.println("Seleziona un'opzione:");
			System.out.println("1. Inserisci nuovo prodotto");
			System.out.println("2. Inserisci nuovo cliente");
			System.out.println("3. Inserisci nuovo ordine");
			System.out.println("4. Inserisci prodotto in magazzino");
			System.out.println("5. Inserisci prodotti ordinati");
			System.out.println("6. Modifica ordine esistente");
			System.out.println("7. Elimina ordine");
			System.out.println("8. Torna al menu principale");

			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta) {
			case 1:
				inserisciNuovoProdotto();
				break;
			case 2:
				inserisciNuovoCliente();
				break;
			case 3:
				inserisciNuovoOrdine();
				break;
			case 4:
				insertProduct();
				break;
			case 5:
				insertOrderedProducts();
				break;
			case 6:
				int idDaAggiornare = scanner.nextInt();
				modificaOrdineEsistente(idDaAggiornare);
				break;
			case 7:
				int idOrdine = scanner.nextInt();
				eliminaOrdine(idOrdine);
				break;
			case 8:
				return; // Per tornare al menu principale
			default:
				System.out.println("Opzione non valida. Riprova.");
			}
		}
	}
	
	public void gestisciUtente() {
		while (true) {
			System.out.println("Benvenuto, " + utente);
			System.out.println("Seleziona un'opzione:");
			System.out.println("1. Visualizza catalogo prodotti");

			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta) {
			case 1:
				Utility.StampaResultSet(DatabaseManager.eseguiQuery(connection, "SELECT * FROM prodotti"));
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			default:
				System.out.println("Opzione non valida. Riprova.");
			}
		}
	}

	// METODO PER FROMATTARE UNA DATE
	public static Date parseStringInDate(String string) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(string);
		return date;
	}

	private Admin creaAdmin() {
		System.out.println("Inserisci il nome dell'admin:");
		String nomeAdmin = scanner.nextLine();
		return new Admin(nomeAdmin);
	}
	
	private Utente creaUtente() {
		System.out.println("Inserisci il nome dell'utente:");
        String nomeUtente = scanner.nextLine();
        return new Utente(nomeUtente);
	}

	private void inserisciNuovoProdotto() {
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM prodotti",
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();

			// Sposta il cursore del result set nella posizione di inserimento
			rs.moveToInsertRow();

			System.out.print("Inserisci la marca: ");
			String marca = scanner.nextLine();
			System.out.print("Inserisci il modello: ");
			String modello = scanner.nextLine();
			System.out.print("Inserisci la descrizione: ");
			String descrizione = scanner.nextLine();

			float prezzo = 0;
			boolean inputValido = false;
			while (!inputValido) {
				try {
					System.out.print("Inserisci il prezzo: ");
					prezzo = scanner.nextFloat();
					scanner.nextLine();

					inputValido = true; // usciamo dal ciclo while se il prezzo inserito è valido
				} catch (Exception e) {
					System.out.println("Input non valido. Inserisci un numero!");
					scanner.nextLine(); // Per consumare l'input non valido
				}
			}

			// Imposto i valori per le colonne
			rs.updateString("marca", marca);
			rs.updateString("modello", modello);
			rs.updateString("descrizione", descrizione);
			rs.updateFloat("prezzo", prezzo);

			// Comando che esegue l'operazione di inserimento
			rs.insertRow();

			rs.moveToCurrentRow();

			System.out.println("Il prodotto è stato inserito correttamente.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante l'inserimento del prodotto.");
		}
	}

	private void inserisciNuovoCliente() throws SQLException {
			

			System.out.print("Inserisci la mail: ");
			String mail = scanner.nextLine();
			System.out.print("Inserisci l'username: ");
			String username = scanner.nextLine();
			System.out.print("Inserisci il nome: ");
			String nome = scanner.nextLine();
			System.out.print("Inserisci il cognome: ");
			String cognome = scanner.nextLine();
			System.out.print("Inserisci indirizzo: ");
			String indirizzo = scanner.nextLine();

			Clienti cliente = new Clienti(mail, username, nome, cognome, indirizzo);
			ClienteDTO dto = new ClienteDTO();
			dto.insert(cliente);
		
	}
	private void inserisciNuovoOrdine() throws ParseException {
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM ordini",
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();

			// Sposta il cursore del result set nella posizione di inserimento
			rs.moveToInsertRow();

			Date date;
			// java.util.Date utilDate = new java.util.Date();
			// java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			System.out.print("Inserisci la mail del cliente che ha effettuato l'ordine: ");
			String mail = scanner.nextLine();
			System.out.println("Inserisci la data dell'ordine (dd/MM/yyyy): ");
			date = parseStringInDate(scanner.nextLine());
			System.out.print("Inserisci il costo totale dell'ordine: ");
			float costoTotale = scanner.nextFloat();
			scanner.nextLine();

			// Imposto i valori per le colonne
			rs.updateString("EmailCliente", mail);
			rs.updateDate("DataOrdine", new java.sql.Date(date.getTime()));
			rs.updateFloat("CostoTotale", costoTotale);

			// Comando che esegue l'operazione di inserimento
			rs.insertRow();

			rs.moveToCurrentRow();

			System.out.println("L'ordine è stato inserito correttamente.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante l'inserimento dell'ordine.");
		}
	}
	
	private void insertProduct() {
		Utility.StampaResultSet(DatabaseManager.eseguiQuery(connection, "SELECT * FROM prodotti"));
		System.out.println("Inserisci l'id del prodotto da inserire in magazzino: ");
		int idProdotto = scanner.nextInt();
		inserisciProdottiMagazzino(idProdotto);
	}

	private void inserisciProdottiMagazzino(int idProdotto) {
		try {

			System.out.print("Inserisci la quantità di prodotto da inserire: ");
			int qta = scanner.nextInt();

			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM magazzino",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();

			// Sposta il cursore del result set nella posizione di inserimento
			rs.moveToInsertRow();

			// Imposto i valori per le colonne
			rs.updateInt("idProdotto", idProdotto);
			rs.updateInt("qta", qta);

			rs.insertRow();

			rs.moveToCurrentRow();

			System.out.println("Il prodotto è stato inserito correttamente in magazzino.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante l'inserimento.");
		}
	}
	
	private void insertOrderedProducts() {
		Utility.StampaResultSet(DatabaseManager.eseguiQuery(connection, "SELECT * FROM ordini"));
		System.out.println("Inserisci l'id dell' ordine da inserire nell'ordine: ");
		int idOrdineDaInserire = scanner.nextInt();
		Utility.StampaResultSet(DatabaseManager.eseguiQuery(connection, "SELECT * FROM prodotti"));
		System.out.println("Inserisci l'id del prodotto da inserire nell'ordine: ");
		int idProdottoDaInserire = scanner.nextInt();
		inserisciProdottiOrdinati(idOrdineDaInserire, idProdottoDaInserire);
	}
	
	private void inserisciProdottiOrdinati(int idOrdine, int idProdotto) {
		try {

			System.out.print("Inserisci la quantità di prodotto da inserire in tabella: ");
			int qta = scanner.nextInt();

			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM prodottiordinati",
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();

			// Sposta il cursore del result set nella posizione di inserimento
			rs.moveToInsertRow();

			// Imposto i valori per le colonne
			rs.updateInt("idOrdine", idOrdine);
			rs.updateInt("idProdotto", idProdotto);
			rs.updateInt("qta", qta);

			rs.insertRow();

			rs.moveToCurrentRow();

			System.out.println("Il prodotto è stato inserito correttamente in prodottiordinati.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante l'inserimento.");
		}
	}

	private void modificaOrdineEsistente(int idOrdine) throws ParseException {
		try {
			Utility.StampaResultSet(DatabaseManager.eseguiQuery(connection, "SELECT * FROM ORDINI"));
			System.out.println("Inserisci l'id dell'ordine da modificare");

			System.out.print("Inserisci l'email del cliente: ");
			scanner.nextLine();
			String emailCliente = scanner.nextLine();

			Date date;
			System.out.print("Inserisci la data dell'ordine (dd/MM/yyyy): ");
			date = parseStringInDate(scanner.nextLine());

			System.out.print("Inserisci il costo totale: ");
			float costoTotale = scanner.nextFloat();
			scanner.nextLine();

			PreparedStatement pstmt = connection.prepareStatement(
					"UPDATE ordini SET EmailCliente = ?, DataOrdine = ?, CostoTotale = ? WHERE idOrdine = " + idOrdine);
			pstmt.setString(1, emailCliente);
			pstmt.setDate(2, new java.sql.Date(date.getTime()));
			pstmt.setFloat(3, costoTotale);

			int rowsUpdated = pstmt.executeUpdate();

			if (rowsUpdated > 0)
				System.out.println("L'ordine è stato modificato correttamente.");
			else
				System.out.println("Nessun ordine trovato con ID " + idOrdine);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante la modifica dell'ordine.");
		}
	}

	private void eliminaOrdine(int idOrdine) {
		try {
			Utility.StampaResultSet(DatabaseManager.eseguiQuery(connection, "SELECT * FROM ORDINI"));
			System.out.println("Inserisci l'id dell'ordine da eliminare");

			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM ordini WHERE idOrdine = " + idOrdine);

			System.out.println("L'ordine è stato eliminato correttamente.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante l'eliminazione dell'ordine.");
		}
	}
}
