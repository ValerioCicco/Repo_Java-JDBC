package entities;

import java.util.ArrayList;

import interfacciaPrenotazione.PrenotazioneService;
//QUESTA CLASSE IMPLEMENTA L'INTERFACCIA PrenotazioneService E GESTIRO' QUI I METODI
public class PrenotazioneServiceImpl implements PrenotazioneService {
	
	private ArrayList<Tavolo> tavoli;
    private ArrayList<Prenotazione> prenotazioni;
    private int prossimoIdPrenotazione;
    
    public PrenotazioneServiceImpl(int nTavoli) {
    	tavoli = new ArrayList<>();
    	prenotazioni = new ArrayList<>();
    	prossimoIdPrenotazione = 1;
    	
    	for(int i = 1; i <= nTavoli; i++) {
    		tavoli.add(new Tavolo(i, 4)); //ES: TUTTI I TAVOLI CHE HANNO 4 POSTI
    	}
    }

	@Override
	public ArrayList<Tavolo> getTavoliDisponibili(String data, String orario, int numeroPersone) {
		ArrayList<Tavolo> tavoliDisponibili = new ArrayList<Tavolo>();
		//PRENOTI SOLO SE IL TAVOLO è LIBERO E IL NUMERO DEI POSTI è MAGGIOREUGUALE DEL NUMERO DI PERSONE
		for(Tavolo tavolo : tavoli) {
			if(tavolo.isLibero() == true && tavolo.getnPosti() >= numeroPersone) {
				tavoliDisponibili.add(tavolo);
			}
		}
		return tavoliDisponibili;
	}

	@Override
	public boolean prenotaTavolo(String data, String orario, int numeroPersone, Tavolo tavolo) {
		if(!tavolo.isLibero() || tavolo.getnPosti() < numeroPersone) {
			System.out.println("Non è possibile prenotare il tavolo");
			return false;
		}
		tavolo.occupa();
		Prenotazione prenotazione = new Prenotazione(prossimoIdPrenotazione++, data, orario, numeroPersone, tavolo);
		prenotazioni.add(prenotazione);
		System.out.println("Grazie per aver prenotato il tavolo");
		return true;
	}

	@Override
	public boolean annullaPrenotazione(Prenotazione prenotazione) {
		Tavolo tavolo = prenotazione.getTavolo();
		tavolo.libera();
		System.out.println("Prenotazione annullata con successo");
		return prenotazioni.remove(prenotazione);
	}

}
