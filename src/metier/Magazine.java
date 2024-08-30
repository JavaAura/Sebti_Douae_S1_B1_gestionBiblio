package metier;

import java.util.Date;

public final class Magazine extends Document {
    private final int numero;
    private boolean estEmprunte;

    // Constructeur pour initialiser les attributs de Magazine
    public Magazine(int id, String titre, String auteur, Date datePublication, int nombreDePages, int numero) {
        super(id, titre, auteur, datePublication, nombreDePages);
        this.numero = numero;
        this.estEmprunte = false;
    }

    // Méthode pour emprunter un magazine
    @Override
    protected boolean emprunter() {
        if (!estEmprunte) {
            estEmprunte = true;
            System.out.println("Le magazine '" + getTitre() + "' (Numéro: " + numero + ") a été emprunté.");
            return true;
        } else {
            System.out.println("Le magazine '" + getTitre() + "' (Numéro: " + numero + ") est déjà emprunté.");
            return false;
        }
    }

    // Méthode pour retourner un magazine
    @Override
    protected boolean retourner() {
        if (estEmprunte) {
            estEmprunte = false;
            System.out.println("Le magazine '" + getTitre() + "' (Numéro: " + numero + ") a été retourné.");
            return true;
        } else {
            System.out.println("Le magazine '" + getTitre() + "' (Numéro: " + numero + ") n'est pas emprunté.");
            return false;
        }
    }

    // Méthode pour afficher les détails du magazine
    @Override
    public void afficherDetails() {
        System.out.println("Magazine:");
        System.out.println("ID: " + getId());
        System.out.println("Titre: " + getTitre());
        System.out.println("Auteur: " + getAuteur());
        System.out.println("Date de Publication: " + getDatePublication());
        System.out.println("Nombre de Pages: " + getNombreDePages());
        System.out.println("Numéro: " + getNumero());
        System.out.println("Statut: " + (estEmprunte ? "Emprunté" : "Disponible"));
    }

    // Getter pour l'attribut numéro
    public int getNumero() {
        return numero;
    }
}
