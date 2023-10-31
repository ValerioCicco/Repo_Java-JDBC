package main;

import java.util.ArrayList;

import entities.PrenotazioneServiceImpl;
import entities.Tavolo;

public class Main {

	public static void main(String[] args) {
		// MAIN verrà utilizzato per test delle classi
		
		Tavolo tavolo1 = new Tavolo(1, 2);
		Tavolo tavolo2 = new Tavolo(2, 10);
		Tavolo tavolo3 = new Tavolo(3, 5);
		Tavolo tavolo4 = new Tavolo(4, 3);
		Tavolo tavolo5 = new Tavolo(5, 6);
		Tavolo tavolo6 = new Tavolo(6, 4);
		Tavolo tavolo7 = new Tavolo(7, 15);
		Tavolo tavolo8 = new Tavolo(8, 12);
		Tavolo tavolo9 = new Tavolo(9, 3);
		Tavolo tavolo10 = new Tavolo(10, 2);
		
		//Prenotazione prenotazione = new Prenotazione(1, "10/10/2023", "22:30", 2, tavolo1);
		PrenotazioneServiceImpl prenotazioneService = new PrenotazioneServiceImpl(10);
		//DATA ORARIO E NUMERO PERSONE
		ArrayList<Tavolo> tavoliDisponibili = prenotazioneService.getTavoliDisponibili("2023-10-10", "19:00", 3);
		
		if(!tavoliDisponibili.isEmpty()) {
			Tavolo tavoloPrenotato = tavoliDisponibili.get(0);
			boolean prenotazioneConfermata = prenotazioneService.prenotaTavolo("2023-10-10", "19:00", 3, tavoloPrenotato);
			
			if(prenotazioneConfermata) {
				System.out.println("Prenotazione effettuata con successo");
			} else {
				System.out.println("Impossibile effettuare la prenotazione");
			}
		} else {
			System.out.println("Nessun tavolo disponibile per la prenotazione richiesta");
		}
	}

}
