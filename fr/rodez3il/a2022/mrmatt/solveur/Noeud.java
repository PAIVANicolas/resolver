package fr.rodez3il.a2022.mrmatt.solveur;


import fr.rodez3il.a2022.mrmatt.solveur.structures.DictionnaireChaine;
import fr.rodez3il.a2022.mrmatt.solveur.structures.ListeTableau;
import fr.rodez3il.a2022.mrmatt.sourcespartielles.Niveau;

public class Noeud {

    //dictionnaire qui va stocker les différentes configurations connues
    private DictionnaireChaine<String, Noeud> config;
    //référence vers l'état du niveau actuel
    private Niveau etat;
    //fils du noeud
    private ListeTableau<Noeud> fils;
    //représente la succession de commandes
    private String commandes;
    //permet de connaitre l'état de visite du noeud.
    private boolean visite;
    //chaine de caractère de la solution du niveau
    private String solution = null;
    //chaine de caractère représentant la succession des commandes
    private String suiteCommandes;
    //représente l'état du niveau sous forme de caractères
    String valChaine;

    /**
     * Constructeur pour la classe Noeud.
     *
     * @param config    Le dictionnaire associant une commande à un Noeud.
     * @param etat      Le niveau actuel.
     * @param commandes La succession de commandes associées à ce Noeud.
     * @return un nouveau noeud
     */
    public Noeud(DictionnaireChaine<String, Noeud> config, Niveau etat, String commandes) {
        this.config = config;
        this.etat = etat;
        this.fils = new ListeTableau<>();
        this.commandes = commandes;
        this.visite = false;
    }

    /**
     * Retourne la liste des fils du noeud actuel
     *
     * @return la liste du noeud actuel
     */
    public ListeTableau<Noeud> getFils() {
        return this.fils;
    }

    /**
     * Indique si le noeud à déjà été visité.
     *
     * @return vrai ssi le noeud à été visité
     */
    public void ajouterFils(Noeud fils) {
        if (fils != null) {
            this.fils.ajouter(fils);
        }
    }
}