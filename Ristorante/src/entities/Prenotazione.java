package entities;

import java.util.Date;
//QUESTA CLASSE RAPPRESENTA L'ENTITA' PRENOTAZIONE EFFETTUATA DA UN UTENTE CON METODO COSTRUTTORE E GETTERS E SETTERS VARIABILI
public class Prenotazione {
	private int id;
	private String dataPrenotazione;	//Gestisco momentaneamente come stringa, in caso di problemi provo booleano
	private String orario;	//Gestisco momentaneamente come stringa, in caso di problemi provo booleano
	private int nPersone;
	private Tavolo tavolo;
	
	public Prenotazione(int id, String dataPrenotazione, String orario, int nPersone, Tavolo tavolo) {
		this.id = id;
		this.dataPrenotazione = dataPrenotazione;
		this.orario = orario;
		this.nPersone = nPersone;
		this.tavolo = tavolo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(String dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public int getnPersone() {
		return nPersone;
	}

	public void setnPersone(int nPersone) {
		this.nPersone = nPersone;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", dataPrenotazione=" + dataPrenotazione + ", orario=" + orario
				+ ", nPersone=" + nPersone + ", tavolo=" + tavolo + "]";
	}
	
	
}
