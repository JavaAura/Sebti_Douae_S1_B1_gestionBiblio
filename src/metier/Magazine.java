package metier;

import java.util.Date;

public final class Magazine extends Document {
    private int numero;

    // Constructeur pour initialiser les attributs de Magazine
    public Magazine(int id, String titre, String auteur, Date datePublication, int nombreDePages, int numero) {
        super(id, titre, auteur, datePublication, nombreDePages); // Appel du constructeur de la classe mère (Document)
        this.numero = numero; // Initialisation de l'attribut spécifique à Magazine
    }

    // Méthode pour emprunter un document (à implémenter)
    @Override
    protected boolean emprunter() {
        // Implémentation future
        return false;
    }

    // Méthode pour retourner un document (à implémenter)
    @Override
    protected boolean retourner() {
        // Implémentation future
        return false;
    }

    // Méthode pour afficher les détails du document (à implémenter)
    @Override
    public void afficherDetails() {
        // Implémentation future
    }

    // Getter pour l'attribut numero
    public int getNumero() {
        return numero;
    }
}
