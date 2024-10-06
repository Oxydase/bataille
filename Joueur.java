package dm.bataille;

import dm.bataille.Carte;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    // attributs
    protected String nom;
    protected List<Carte> paquet;
    protected int score;

    // constructeur
    public Joueur(String nom) {
        this.nom = nom;
        this.paquet = new ArrayList<>();  // Initialisation d'une liste vide de cartes
        this.score = 0;  // Score initial à 0
    }

    // getters
    public String getNom() {
        return nom;
    }

    public List<Carte> getPaquet() {
        return paquet;
    }

    public int getScore() {
        return score;
    }

    // setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Méthode pour tirer une carte
    public Carte tirerCarte() {
        if (!paquet.isEmpty()) {
            Carte carte = paquet.remove(0);
            System.out.println(this.nom + " tire " + carte.getValeur() + " de " + carte.getCouleur());
            return carte;
        }
        System.out.println(this.nom + " n'a plus de cartes !");
        return null; // Si le paquet est vide
    }

    public void retirerCarte(Carte carte) {
        this.paquet.remove(carte);
    }


    // Méthode pour ajouter une carte au paquet
    public void ajouterCarte(Carte carte) {
        paquet.add(carte);  // Ajouter la carte à la fin du paquet
    }

    // Méthode toString() pour afficher les informations du joueur
    public String toString() {
        return "Le Joueur: " + nom + " a un score de " + score + " et à ce nombre de cartes: " + paquet.size();
    }
}

