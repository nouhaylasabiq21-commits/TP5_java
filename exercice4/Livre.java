package exercice4;

public class Livre {
	private String auteur;
	private int nbrPages;

	public Livre(String titre, String auteur, int nbrPages) {
		this.auteur = auteur;
		this.auteur = auteur;
		this.nbrPages = nbrPages;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getNbrPages() {
		return nbrPages;
	}

	public void setNbrPages(int nbrPages) {
		this.nbrPages = nbrPages;
	}

	@Override
	public String toString() {
		return "Livre [auteur=" + auteur + ", nbrPages=" + nbrPages + "]";
	}

}
