package entities;

public class Prodotti {
	
	protected int id;
	protected String Marca;
	protected String Modello;
	protected String Descrizione;
	protected float prezzo;
	
	public Prodotti() {
		
	}
	
	public Prodotti(int id, String marca, String modello, String descrizione, float prezzo) {
		this.id = id;
		Marca = marca;
		Modello = modello;
		Descrizione = descrizione;
		this.prezzo = prezzo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModello() {
		return Modello;
	}

	public void setModello(String modello) {
		Modello = modello;
	}

	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
    public String toString() {
        StringBuilder result = new StringBuilder("PRODOTTI:\n");
                result.append("\n-----------\n")
                .append("Id: ").append(id).append("\n")
                .append("Marca: ").append(Marca).append("\n")
                .append("Modello: ").append(Modello).append("\n")
                .append("Descrizione: ").append(Descrizione).append("\n")
                .append("Prezzo: ").append(prezzo);

        return result.toString();
    }
}
