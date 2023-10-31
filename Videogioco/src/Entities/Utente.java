package Entities;

import java.util.List;
import java.util.Scanner;

public class Utente extends Admin {

	public Utente(String nomeUtente, String password) {
		super(nomeUtente, password);
	}
	
	//METODI LOGIN E LOGOUT EREDITATI DA ADMIN
	
	@Override
    public boolean login(String nomeUtente, String password) {
        return super.login(nomeUtente, password);
    }

    @Override
    public void logout() {
        super.logout();
    }
	
	
	//REGISTRARE IN MEMORIA PIù DI UN UTENTE MA UNI-NOMINATIVO
	//Stesso username va bene ma password diversa
}
