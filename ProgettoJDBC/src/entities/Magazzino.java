package entities;

public class Magazzino {
	protected int idProdotto;
	protected int qta;
	
	public Magazzino() {
		
	}

	public Magazzino(int idProdotto, int qta) {
		this.idProdotto = idProdotto;
		this.qta = qta;
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
        StringBuilder result = new StringBuilder("Magazzino:\n");
        result.append("IdProdotto: ").append(idProdotto).append("\n")
        		.append("Quantità: ").append(qta).append("\n")
                .append("\n----------------------------");

        return result.toString();
    }
}
