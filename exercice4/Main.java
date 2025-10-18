package exercice4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Entrez la capacité de la bibliothèque: ");
		int n = sc.nextInt();
		sc.nextLine();

		Bibliotheque biblio = new Bibliotheque(n);

		biblio.ajouter(new Roman("Les Misérables", "Victor Hugo", 1200, 49.99));
		biblio.ajouter(new Revue("Science Aujourd'hui", "Octobre", 2025));

		int choix;
		do {
			System.out.println("\n1. Ajouter un document");
			System.out.println("2. Afficher tous les documents");
			System.out.println("3. Supprimer un document");
			System.out.println("4. Afficher auteurs");
			System.out.println("0. Quitter");
			System.out.print("Votre choix: ");
			choix = sc.nextInt();
			sc.nextLine();

			switch (choix) {
			case 1:
				System.out.print("Type (1=Roman, 2=Revue, 3=Manuel, 4=Dictionnaire): ");
				int type = sc.nextInt();
				sc.nextLine();
				System.out.print("Titre: ");
				String titre = sc.nextLine();
				Document doc = null;
				switch (type) {
				case 1:
					System.out.print("Auteur: ");
					String auteur = sc.nextLine();
					System.out.print("Nb pages: ");
					int pages = sc.nextInt();
					System.out.print("Prix: ");
					double prix = sc.nextDouble();
					sc.nextLine();
					doc = new Roman(titre, auteur, pages, prix);
					break;
				case 2:
					System.out.print("Mois: ");
					String mois = sc.nextLine();
					System.out.print("Année: ");
					int annee = sc.nextInt();
					sc.nextLine();
					doc = new Revue(titre, mois, annee);
					break;
				case 3:
					System.out.print("Auteur: ");
					String auteurM = sc.nextLine();
					System.out.print("Nb pages: ");
					int pagesM = sc.nextInt();
					sc.nextLine();
					System.out.print("Niveau: ");
					String niveau = sc.nextLine();
					doc = new Manuel(titre, auteurM, pagesM, niveau);
					break;
				case 4:
					System.out.print("Langue: ");
					String langue = sc.nextLine();
					doc = new Dictionnaire(titre, langue);
					break;
				}
				if (doc != null && biblio.ajouter(doc)) {
					System.out.println("Document ajouté !");
				} else {
					System.out.println("Impossible d'ajouter le document.");
				}
				break;

			case 2:
				biblio.afficherDocuments();
				break;

			case 3:
				System.out.print("Numéro d'enregistrement à supprimer: ");
				int num = sc.nextInt();
				Document d = biblio.document(num);
				if (d != null && biblio.supprimer(d))
					System.out.println("Supprimé !");
				else
					System.out.println("Document non trouvé.");
				break;

			case 4:
				biblio.afficherAuteurs();
				break;

			case 0:
				System.out.println("Au revoir !");
				break;

			default:
				System.out.println("Choix invalide !");
			}

		} while (choix != 0);

		sc.close();
	}
}
