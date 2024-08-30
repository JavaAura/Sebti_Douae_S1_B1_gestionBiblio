package metier;

import java.util.Date;

public abstract class Document {
    protected int id;
    protected String titre;
    protected String auteur;
    protected Date datePublication;
    protected int nombreDePages;

    // Constructeur de la classe Document
    public Document(int id, String titre, String auteur, Date datePublication, int nombreDePages) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages;
    }

    // Méthode abstraite pour emprunter un document
    protected abstract boolean emprunter();

    // Méthode abstraite pour retourner un document
    protected abstract boolean retourner();

    // Méthode abstraite pour afficher les détails du document
    public abstract void afficherDetails();

    // Getters pour les attributs de base
    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }
}
