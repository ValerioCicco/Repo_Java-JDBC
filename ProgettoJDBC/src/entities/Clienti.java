package entities;

public class Clienti {
	protected String EmailClienti;
	protected String Username;
	protected String Nome;
	protected String Cognome;
	protected String Indirizzo;
	
	

	public Clienti(String emailClienti, String username, String nome, String cognome, String indirizzo) {
		EmailClienti = emailClienti;
		Username = username;
		Nome = nome;
		Cognome = cognome;
		Indirizzo = indirizzo;
	}

	public String getEmailClienti() {
		return EmailClienti;
	}

	public void setEmailClienti(String emailClienti) {
		EmailClienti = emailClienti;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public String getIndirizzo() {
		return Indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}
	
	@Override
    public String toString() {
        StringBuilder result = new StringBuilder("CLIENTI:\n");
                result.append("\n-----------\n")
                .append("EmailCliente: ").append(EmailClienti).append("\n")
                .append("Username: ").append(Username).append("\n")
                .append("Nome: ").append(Nome).append("\n")
                .append("Cognome: ").append(Cognome).append("\n")
                .append("Indirizzo: ").append(Indirizzo);

        return result.toString();
    }
}
