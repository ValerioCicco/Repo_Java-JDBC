package entities;

//QUESTA CLASSE RAPPRESENTA L'ENTITA' TAVOLO CON METODO COSTRUTTORE E GETTERS E SETTERS VARIABILI
public class Tavolo {
	
	private int idTavolo;
	private int nPosti;
	private boolean isLibero;
	
	public Tavolo(int idTavolo, int nPosti) {
		this.idTavolo = idTavolo;
		this.nPosti = nPosti;
		this.isLibero = true;
	}

	public int getIdTavolo() {
		return idTavolo;
	}

	public void setIdTavolo(int idTavolo) {
		this.idTavolo = idTavolo;
	}

	public int getnPosti() {
		return nPosti;
	}

	public void setnPosti(int nPosti) {
		this.nPosti = nPosti;
	}

	public boolean isLibero() {
		return isLibero;
	}

	public void setLibero(boolean isLibero) {
		this.isLibero = isLibero;
	}
	
	//METODI PER OCCUPARE E LIBERARE TAVOLI
	public void occupa() {
		isLibero = false;
	}
	
	public void libera() {
		isLibero = true;
	}

	@Override
	public String toString() {
		return "Tavolo [idTavolo=" + idTavolo + ", nPosti=" + nPosti + ", isLibero=" + isLibero + "]";
	}
	
	
}
