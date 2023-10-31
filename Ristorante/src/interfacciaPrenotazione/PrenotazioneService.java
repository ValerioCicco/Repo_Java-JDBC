package interfacciaPrenotazione;

import java.util.ArrayList;

import entities.Prenotazione;
import entities.Tavolo;

//QUESTA INTERFACCIA IMPLEMENTA LA FIRMA DEI METODI CHE VERRANNO UTILIZZATI ALL'INTERNO DELLA CLASSE PrenotazioneServiceImpl
public interface PrenotazioneService {
	
	ArrayList<Tavolo> getTavoliDisponibili(String data, String orario, int numeroPersone);
	
	boolean prenotaTavolo(String data, String orario, int numeroPersone, Tavolo tavolo);

    boolean annullaPrenotazione(Prenotazione prenotazione);
}
