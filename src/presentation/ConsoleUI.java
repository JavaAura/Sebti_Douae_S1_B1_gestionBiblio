package present;

import metier.Bibliotheque;
import metier.Document;
import metier.Livre;
import metier.Magazine;
import utilitaire.DateUtils;

import java.util.Date;
import java.util.Scanner;

public class ConsoleUI {
    private Bibliotheque bibliotheque;
    private Scanner scanner;

    // Constructeur de la classe ConsoleUI
    public ConsoleUI() {
        bibliotheque = new Bibliotheque();
        scanner = new Scanner(System.in);
    }

    // Méthode pour afficher le menu et gérer les choix de l'utilisateur
    public void afficherMenu() {
        int choix;
        do {
            System.out.println("\n=== Menu de la Bibliothèque ===");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Emprunter un document");
            System.out.println("3. Retourner un document");
            System.out.println("4. Afficher tous les documents");
            System.out.println("5. Rechercher un document");
            System.out.println("6. Quitter");
            System.out.print("Veuillez entrer votre choix (1-6) : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne laissée par nextInt()

            switch (choix) {
                case 1:
                    ajouterDocument();
                    break;
                case 2:
                    emprunterDocument();
                    break;
                case 3:
                    retournerDocument();
                    break;
                case 4:
                    afficherTousLesDocuments();
                    break;
                case 5:
                    rechercherDocument();
                    break;
                case 6:
                    System.out.println("Merci d'avoir utilisé la bibliothèque !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 6);
    }

    // Méthode pour ajouter un document
    private void ajouterDocument() {
        System.out.print("Entrez le type de document (1: Livre, 2: Magazine) : ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        System.out.print("Entrez l'ID : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        System.out.print("Entrez le titre : ");
        String titre = scanner.nextLine();

        System.out.print("Entrez l'auteur : ");
        String auteur = scanner.nextLine();

        System.out.print("Entrez la date de publication (au format YYYY-MM-DD) : ");
        String dateStr = scanner.nextLine();
        Date datePublication = DateUtils.parseDate(dateStr);

        System.out.print("Entrez le nombre de pages : ");
        int nombreDePages = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        if (type == 1) { // Ajouter un livre
            System.out.print("Entrez l'ISBN : ");
            String isbn = scanner.nextLine();
            Livre livre = new Livre(id, titre, auteur, datePublication, nombreDePages, isbn);
            bibliotheque.ajouter(livre);
            System.out.println("Livre ajouté avec succès !");
        } else if (type == 2) { // Ajouter un magazine
            System.out.print("Entrez le numéro : ");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne
            Magazine magazine = new Magazine(id, titre, auteur, datePublication, nombreDePages, numero);
            bibliotheque.ajouter(magazine);
            System.out.println("Magazine ajouté avec succès !");
        } else {
            System.out.println("Type de document invalide.");
        }
    }

    // Méthode pour emprunter un document
    private void emprunterDocument() {
        System.out.print("Entrez le titre du document à emprunter : ");
        String titre = scanner.nextLine();
        boolean success = bibliotheque.emprunterDocument(titre);
        if (success) {
            System.out.println("Document emprunté avec succès !");
        } else {
            System.out.println("Échec de l'emprunt.");
        }
    }

    // Méthode pour retourner un document
    private void retournerDocument() {
        System.out.print("Entrez le titre du document à retourner : ");
        String titre = scanner.nextLine();
        boolean success = bibliotheque.retournerDocument(titre);
        if (success) {
            System.out.println("Document retourné avec succès !");
        } else {
            System.out.println("Échec du retour.");
        }
    }

    // Méthode pour afficher tous les documents
    private void afficherTousLesDocuments() {
        bibliotheque.afficherTousLesDocuments();
    }

    // Méthode pour rechercher un document par son titre
    private void rechercherDocument() {
        System.out.print("Entrez le titre du document à rechercher : ");
        String titre = scanner.nextLine();
        Document document = bibliotheque.rechercher(titre);
        if (document != null) {
            document.afficherDetails();
        } else {
            System.out.println("Document non trouvé.");
        }
    }
}
