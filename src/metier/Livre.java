package metier;

import java.util.Date;

public final class Livre extends Document {
    private final String isbn;
    private boolean estEmprunte;

    // Constructeur pour initialiser les attributs de Livre
    public Livre(int id, String titre, String auteur, Date datePublication, int nombreDePages, String isbn) {
        super(id, titre, auteur, datePublication, nombreDePages);
        this.isbn = isbn;
        this.estEmprunte = false;
    }

    // Méthode pour emprunter un livre
    @Override
    protected boolean emprunter() {
        if (!estEmprunte) {
            estEmprunte = true;
            System.out.println("Le livre '" + getTitre() + "' a été emprunté.");
            return true;
        } else {
            System.out.println("Le livre '" + getTitre() + "' est déjà emprunté.");
            return false;
        }
    }

    // Méthode pour retourner un livre
    @Override
    protected boolean retourner() {
        if (estEmprunte) {
            estEmprunte = false;
            System.out.println("Le livre '" + getTitre() + "' a été retourné.");
            return true;
        } else {
            System.out.println("Le livre '" + getTitre() + "' n'est pas emprunté.");
            return false;
        }
    }

    // Méthode pour afficher les détails du livre
    @Override
    public void afficherDetails() {
        System.out.println("Livre:");
        System.out.println("ID: " + getId());
        System.out.println("Titre: " + getTitre());
        System.out.println("Auteur: " + getAuteur());
        System.out.println("Date de Publication: " + getDatePublication());
        System.out.println("Nombre de Pages: " + getNombreDePages());
        System.out.println("ISBN: " + getIsbn());
        System.out.println("Statut: " + (estEmprunte ? "Emprunté" : "Disponible"));
    }

    // Getter pour l'attribut ISBN
    public String getIsbn() {
        return isbn;
    }
}
