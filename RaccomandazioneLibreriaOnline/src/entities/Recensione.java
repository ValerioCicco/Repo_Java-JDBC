package entities;

public class Recensione {
	private int idLibro;
	private int idUtente;
	private int valutazione;
	private String commento;
	
	public Recensione (int libroId, int utenteId, int valutazione, String commento) {
		this.idLibro = libroId;
		this.idUtente = utenteId;
		this.valutazione = valutazione;
		this.commento = commento;
	}

	public int getUtenteId() {
		return idUtente;
	}

	public void setUtenteId(int utenteId) {
		this.idUtente = utenteId;
	}

	public int getLibroId() {
		return idLibro;
	}

	public void setLibroId(int libroId) {
		this.idLibro = libroId;
	}

	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}
	
	public String toString() {
		return "UtenteId: " + idUtente + "\nLibroId: " + idLibro + "\nValutazione: " + valutazione + "\nCommento: " + commento;
	}
}
