package it.uniroma3.diadia.simulatore;

import java.util.List;
import java.util.Scanner;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Direzione;


public class Simulatore {
	public static IOSimulator creaSimulazionePartitaFacile(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Scanner scannerDiLinee = new Scanner(System.in);
		Labirinto labirinto = Labirinto.newLabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 1)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", Direzione.nord)
				.addAdiacenza("Biblioteca", "Atrio", Direzione.sud)
				.getLabirinto();
		DiaDia gioco = new DiaDia(labirinto, io);
		gioco.gioca(scannerDiLinee);
		return io;
	}

	public static IOSimulator creaSimulazionePartitaDifficile(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Scanner scannerDiLinee = new Scanner(System.in);
		Labirinto labirinto = Labirinto.newLabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 1)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", Direzione.nord)
				.addAdiacenza("Biblioteca", "Atrio", Direzione.sud)
				.addStanza("Bagno")
				.addAttrezzo("carta igenica", 1)
				.addAdiacenza("Bagno", "Atrio", Direzione.nord)
				.addAdiacenza("Atrio", "Bagno", Direzione.sud)
				.addStanza("Studio")
				.addAdiacenza("Studio", "Atrio", Direzione.est)
				.addAdiacenza("Atrio", "Studio", Direzione.ovest)
				.getLabirinto();
		DiaDia gioco = new DiaDia(labirinto, io);
		gioco.gioca(scannerDiLinee);
		return io;
	}

	public static IOSimulator creaSimulazionePartitaMonolocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Scanner scannerDiLinee = new Scanner(System.in);
		Labirinto monolocale = Labirinto.newLabirintoBuilder()
				.addStanzaIniziale("salotto") 
				.addStanzaVincente("salotto") 
				.getLabirinto();
		DiaDia gioco = new DiaDia(monolocale, io);
		gioco.gioca(scannerDiLinee);
		return io;
	}
	
	
	public static IOSimulator creaSimulazionePartitaBilocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Scanner scannerDiLinee = new Scanner(System.in);
		Labirinto bilocale = Labirinto.newLabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanzaVincente("camera")
				.addAttrezzo("letto",10) // dove? fa riferimento all’ultima stanza aggiunta
				.addAdiacenza("salotto", "camera", Direzione.ovest) // camera si trova a nord di salotto
				.getLabirinto();
		DiaDia gioco = new DiaDia(bilocale, io);
		gioco.gioca(scannerDiLinee);
		return io;
	}
	
	public static IOSimulator creaSimulazionePartitaTrilocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Scanner scannerDiLinee = new Scanner(System.in);
		Labirinto trilocale = Labirinto.newLabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", Direzione.nord)
				.addAdiacenza("cucina", "camera", Direzione.est)
				.getLabirinto();
		DiaDia gioco = new DiaDia(trilocale, io);
		gioco.gioca(scannerDiLinee);
		return io;
	}

	public static Attrezzo creaAttrezzoEAggiungiAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}
}
