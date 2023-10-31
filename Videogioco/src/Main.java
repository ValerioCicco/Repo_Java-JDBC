import Entities.PlayManager;
import Entities.Videogioco;
import Entities.VideogiocoAzione;
import Entities.VideogiocoStrategia;

public class Main {

	public static void main(String[] args) {
		// Creare array di videogioco per dimostrare polimorfismo
//		VideogiocoAzione gioco1 = new VideogiocoAzione("Call of duty", "azione");
//		VideogiocoStrategia gioco2 = new VideogiocoStrategia("Cluedo", "strategia");
//		
//		Videogioco[] giochi = new Videogioco[2];
//		giochi[0] = gioco1;
//		giochi[1] = gioco2;
//		
//		for(Videogioco gioco : giochi) {
//			gioco.gioca();
//		}
		
		PlayManager playManager = new PlayManager();
		playManager.start();
        

	}

}
