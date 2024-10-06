package dm.bataille;

public class Carte {
    // attributs
    public static String [] tableauCouleurs= {"pic (noir)", "trefle (noir)","carreau (rouge)","coeur (rouge)",};
    public static String [] tableauValeurs = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};

    protected String couleur;
    protected String valeur;

    // constructeur
    public Carte(String couleur, String valeur){
        this.couleur= couleur;
        this.valeur= valeur;
    }

    // getters

    public String getCouleur(){
        return this.couleur;
    }

    public String getValeur(){
        return this.valeur;
    }

    // setters

    public void setCouleur(String couleur){
        this.couleur= couleur;
    }

    public void setValeur(String valeur){
        this.valeur= valeur;
    }

    // comparateur
    // etape 1 obtenir l'index de la carte dans le tableau de valeurs (trié du plus grand au plus petit)

    private int getIndexValeurCarte(String valeur){
        for(int i =0; i < tableauValeurs.length; i++){
            if(tableauValeurs[i].equals(valeur)){
                return i;
            }
        }
        return -1;
    }

    // comparateur
    // etape 2 utilisation de conditions if pour comparer les valeurs

    public int comparateurDeCarte(Carte CarteJ1, Carte CarteJ2) {
        int indexCarteJ1 = getIndexValeurCarte(CarteJ1.getValeur());
        int indexCarteJ2 = getIndexValeurCarte(CarteJ2.getValeur());

        // Utilisation des conditions if pour comparer les index
        if (indexCarteJ1 > indexCarteJ2) {
            return 1;  // CarteJ1 est plus forte
        } else if (indexCarteJ1 < indexCarteJ2) {
            return -1;  // CarteJ2 est plus forte
        }  else {
            return 0;  // Les deux cartes sont égales
        }
    }
}
