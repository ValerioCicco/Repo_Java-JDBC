package entities;

import java.text.DateFormat;
import java.util.Date;

public class Ordini {
	protected int idOrdine;
	protected String EmailCliente;
	protected Date DataOrdine;
	protected float CostoTotale;
	
	public Ordini() {
		
	}

	public Ordini(int idOrdine, String emailCliente, Date dataOrdine, float costoTotale) {
		this.idOrdine = idOrdine;
		EmailCliente = emailCliente;
		DataOrdine = dataOrdine;
		CostoTotale = costoTotale;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public String getEmailCliente() {
		return EmailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		EmailCliente = emailCliente;
	}

	public Date getDataOrdine() {
		return DataOrdine;
	}

	public void setDataOrdine(Date dataOrdine) {
		DataOrdine = dataOrdine;
	}

	public float getCostoTotale() {
		return CostoTotale;
	}

	public void setCostoTotale(float costoTotale) {
		CostoTotale = costoTotale;
	}
	
	//Utilizzo il metodo privato perché lo utilizzerò solo all'interno del toString
	private String parseDate(Date date) {   
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        String formattedDate = dateFormat.format(date);
        return formattedDate;
    }
	
	@Override
    public String toString() {
        StringBuilder result = new StringBuilder("ORDINI:\n");
        result.append("IdOrdine: ").append(idOrdine).append("\n")
        		.append("Email Cliente: ").append(EmailCliente).append("\n")
                .append("Data Ordine: ").append(parseDate(DataOrdine)).append("\n")
                .append("Costo Totale: ").append(CostoTotale)
                .append("\n----------------------------");

        return result.toString();
    }
}
