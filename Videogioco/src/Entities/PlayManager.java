package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayManager {

	private List<Admin> adminRegistrati;
	private List<Utente> utentiRegistrati;
	private Admin adminCorrente;
	private List<Videogioco> catalogoVideogiochi;

	public PlayManager() {
		adminRegistrati = new ArrayList<>();
		utentiRegistrati = new ArrayList<>();
		adminCorrente = null;
		catalogoVideogiochi = new ArrayList<>();
	}

	// QUA DEVO GESTIRE TUTTA LA LOGICA (MENU CON VARIE AZIONI)
	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("Benvenuto! Segli un'opzione: ");
			if (adminCorrente == null) {
				System.out.println("1. Registra un admin");
				System.out.println("2. Login");
				System.out.println("3. Esci");
			} else {
				System.out.println("1. Logout");
				System.out.println("2. Visualizza catalogo richieste");
				System.out.println("3. Aggiungi richiesta");
				System.out.println("4. Gestisci richieste");
				System.out.println("5. Esci");
			}

			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta) {
			case 1:
				if (adminCorrente == null) {
					registraAdmin();
				} else {
					logout();
				}
				break;
			case 2:
				if (adminCorrente == null) {
					login();
				} else {
					visualizzaCatalogoRichieste();
				}
				break;
			case 3:
				if (adminCorrente == null) {
					exit = true;
				} else {
					aggiungiRichiesta();
				}
				break;
			case 4:
				if (adminCorrente == null) {
					exit = true;
				} else {
					gestisciRichieste();
				}
				break;
			case 5:
				exit = true;
				break;
			default:
				System.out.println("Scelta non valida.");
				break;
			}
		}
	}

	// METODI per funzionalità

	private void registraAdmin() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Inserisci un nome utente: ");
		String nomeAdmin = scanner.nextLine();

		System.out.print("Inserisci una password: ");
		String password = scanner.nextLine();

		adminRegistrati.add(new Admin(nomeAdmin, password));
		adminCorrente = new Admin(nomeAdmin, password);
	}

	private void login() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nome utente: ");
		String nomeUtente = scanner.nextLine();

		System.out.print("Password: ");
		String password = scanner.nextLine();

		for (Admin utente : utentiRegistrati) {
			if (utente.login(nomeUtente, password)) {
				adminCorrente = utente;
				System.out.println("Accesso effettuato con successo.");
				return;
			}
		}

		System.out.println("Nome utente o password non validi.");
	}

	private void logout() {
		adminCorrente.logout();
		adminCorrente = null;
		System.out.println("Logout effettuato.");
	}

	private void visualizzaCatalogoRichieste() {
		for (Videogioco gioco : catalogoVideogiochi) {
			gioco.gioca();
		}
	}

	private void aggiungiRichiesta() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Inserisci nome gioco: ");
		String richiesta = scanner.nextLine();
		System.out.print("Inserisci genere gioco: ");
		String genere = scanner.nextLine();
		
		Videogioco videogioco = new Videogioco(richiesta, genere);
		catalogoVideogiochi.add(videogioco);

		adminCorrente.aggiungiRichiesta(richiesta);
		adminCorrente.aggiungiRichiesta(genere);
	}

	private void gestisciRichieste() {
		adminCorrente.gestisciRichieste();
	}
	
}
