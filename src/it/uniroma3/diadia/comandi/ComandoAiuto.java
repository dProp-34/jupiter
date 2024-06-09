package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	static final private String[] ELENCO_COMANDI = {
			"vai", "prendi", "posa", "guarda", "aiuto", "fine" };
	
	private final String NOME = "aiuto";

	/**
	 * Stampa informazioni di aiuto.
	 */
	@Override
	public String esegui(Partita partita) {
		StringBuilder out = new StringBuilder();
		for (String s : ComandoAiuto.ELENCO_COMANDI)
			out.append(s + " ");
		out.append("\n" + partita.getGiocatore().getBorsa().toString() +
				"\nCFU Rimanenti: " + partita.getGiocatore().getCfu());
		return out.toString();
	}

	@Override
	public String getNome() {
		return this.NOME;
	}

}
