package exercice4;

public class Bibliotheque {
	private int capacite;
	private Document[] documents;
	private int nbDocuments;

	public Bibliotheque(int capacite, Document[] documents, int nbDocuments) {

		this.capacite = capacite;
		this.documents = new Document[capacite];
		this.nbDocuments = 0;
	}

	public boolean ajouter(Document doc) {
		if (nbDocuments >= capacite)
			return false;
		documents[nbDocuments++] = doc;
		return true;
	}

	public boolean supprimer(Document doc) {
		for (int i = 0; i < nbDocuments; i++) {
			if (documents[i].getNumEnreg() == doc.getNumEnreg()) {
				documents[i] = documents[nbDocuments - 1]; // remplacer par le dernier
				documents[nbDocuments - 1] = null;
				nbDocuments--;
				return true;
			}
		}
		return false;
	}

	public Document document(int numEnreg) {
		for (int i = 0; i < nbDocuments; i++) {
			if (documents[i].getNumEnreg() == numEnreg)
				return documents[i];
		}
		return null;
	}

	public void afficherDocuments() {
		for (int i = 0; i < nbDocuments; i++) {
			System.out.println(documents[i]);
		}
	}

	public void afficherAuteurs() {
		for (int i = 0; i < nbDocuments; i++) {
			if (documents[i] instanceof Livre) {
				Livre livre = (Livre) documents[i];
				System.out.println(livre.getAuteur());
			}
		}
	}
}
