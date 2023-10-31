package entities;

public class ProdottiOrdinati {
	protected int idOrdine; 
	protected int idProdotto; 
	protected int qta; 
	
	public ProdottiOrdinati() {
		
	}

	public ProdottiOrdinati(int idOrdine, int idProdotto, int qta) {
		this.idOrdine = idOrdine;
		this.idProdotto = idProdotto;
		this.qta = qta;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public int getQta() {
		return qta;
	}

	public void setQta(int qta) {
		this.qta = qta;
	}
	
	@Override
    public String toString() {
        StringBuilder result = new StringBuilder("Prodotti Ordinati:\n");
        result.append("IdOrdine: ").append(idOrdine).append("\n")
        		.append("IdProdotto: ").append(idProdotto).append("\n")
        		.append("Quantità: ").append(qta).append("\n")
                .append("\n----------------------------");

        return result.toString();
    }
}
