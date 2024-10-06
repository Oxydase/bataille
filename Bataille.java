package dm.bataille;

import java.util.ArrayList;
import java.util.Collections;

public class Bataille {
    public static void main(String[] args) {
        // ETAPE 1 : créer le jeu de cartes
        ArrayList<Carte> jeuDeCartes = new ArrayList<>();

        // Utilisation des constantes dans la classe Carte
        for (String couleur : Carte.tableauCouleurs) {
            for (String valeur : Carte.tableauValeurs) {
                jeuDeCartes.add(new Carte(couleur, valeur));
            }
        }

        // ETAPE 2 : mélanger aléatoirement le jeu de cartes
        Collections.shuffle(jeuDeCartes);

        // ETAPE 3 : créer les 2 joueurs
        Joueur joueur1 = new Joueur("Milton");
        Joueur joueur2 = new Joueur("Tonmil");

        // ETAPE 4 : distribuer le jeu de cartes mélangé aux 2 joueurs
        int milieu = jeuDeCartes.size() / 2;
        for (int i = 0; i < milieu; i++) {
            joueur1.ajouterCarte(jeuDeCartes.get(i));
        }
        for (int i = milieu; i < jeuDeCartes.size(); i++) {
            joueur2.ajouterCarte(jeuDeCartes.get(i));
        }

        // ETAPE 5 : la partie commence
        while (joueur1.getPaquet().size() > 0 && joueur2.getPaquet().size() > 0) {

            // Affichage du nombre de cartes restantes avant de tirer
            //System.out.println(joueur1.getNom() + " a " + joueur1.getPaquet().size() + " cartes restantes.");
            //System.out.println(joueur2.getNom() + " a " + joueur2.getPaquet().size() + " cartes restantes.");

            // Chaque joueur tire une carte
            Carte carteJ1 = joueur1.tirerCarte();
            Carte carteJ2 = joueur2.tirerCarte();

            // Comparaison des cartes
            int resultat = carteJ1.comparateurDeCarte(carteJ1, carteJ2);

            // Résultat tour
            if (resultat > 0) {
                // Joueur 1 gagne le tour
                joueur1.setScore(joueur1.getScore() + 1);
                System.out.println(joueur1.getNom() + " gagne ce tour avec " + carteJ1.getValeur() + " de " + carteJ1.getCouleur() + " contre " + carteJ2.getValeur() + " de " + carteJ2.getCouleur());
            } else if (resultat < 0) {
                // Joueur 2 gagne le tour
                joueur2.setScore(joueur2.getScore() + 1);
                System.out.println(joueur2.getNom() + " gagne ce tour avec " + carteJ2.getValeur() + " de " + carteJ2.getCouleur() + " contre " + carteJ1.getValeur() + " de " + carteJ1.getCouleur());
            } else {
                // Egalité
                System.out.println("Egalité entre " + carteJ1.getValeur() + " de " + carteJ1.getCouleur() + " et " + carteJ2.getValeur() + " de " + carteJ2.getCouleur());
            }

            // Affichage des scores
            System.out.println(joueur1.getNom() + " : " + joueur1.getScore() + " points");
            System.out.println(joueur2.getNom() + " : " + joueur2.getScore() + " points");
        }

        // ETAPE 6 : Affichage du vainqueur de la partie
        if (joueur1.getScore() > joueur2.getScore()) {
            System.out.println(joueur1.getNom() + " remporte la partie avec " + joueur1.getScore() + " points !");
        } else if (joueur1.getScore() < joueur2.getScore()) {
            System.out.println(joueur2.getNom() + " remporte la partie avec " + joueur2.getScore() + " points !");
        } else {
            System.out.println("La partie se termine avec une égalité !");
        }
    }
}
