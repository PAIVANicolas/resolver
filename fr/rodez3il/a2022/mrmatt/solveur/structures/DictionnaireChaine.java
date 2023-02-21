package fr.rodez3il.a2022.mrmatt.solveur.structures;

import java.util.NoSuchElementException;

public class DictionnaireChaine<C, V> implements Dictionnaire<C, V> {

    private Liste<Entree<C, V>> entrees;

    /**
     * Classe interne représentant une entrée du dictionnaire (couple clé, valeur).
     */
    private static class Entree<C, V> {
        private C cle;
        private V valeur;

        public Entree(C cle, V valeur) {
            this.cle = cle;
            this.valeur = valeur;
        }

        public C getCle() {
            return cle;
        }

        public V getValeur() {
            return valeur;
        }

        public void setValeur(V valeur) {
            this.valeur = valeur;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entree<?, ?> entree = (Entree<?, ?>) o;
            return cle.equals(entree.cle);
        }

        @Override
        public int hashCode() {
            return cle.hashCode();
        }
    }

    public DictionnaireChaine() {
        entrees = new ListeChainee<>();
    }

    /**
     * Insère une nouvelle entrée dans le dictionnaire, en remplaçant la valeur associée à la clé
     * si elle existe déjà.
     *
     * @param cle    la clé associée à la valeur
     * @param valeur la valeur associée à la clé
     */
    public void inserer(C cle, V valeur) {
        Entree<C, V> nouvelleEntree = new Entree<>(cle, valeur);

        // Si la clé existe déjà, on remplace la valeur associée
        boolean trouve = false;
        int i = 0;
        while (!trouve && i < entrees.taille()) {
            Entree<C, V> entreeExistante = entrees.element(i);
            if (entreeExistante.getCle().equals(cle)) {
                entreeExistante.setValeur(valeur);
                trouve = true;
            }
            i++;
        }

        // Sinon, on ajoute une nouvelle entrée
        if (!trouve) {
            entrees.ajouter(nouvelleEntree);
        }
    }


    /**
     * Vérifie si le dictionnaire contient une entrée associée à la clé spécifiée.
     *
     * @param cle la clé à rechercher dans le dictionnaire
     * @return true si le dictionnaire contient la clé, false sinon
     */
    public boolean contient(C cle) {
        Entree<C, V> recherche = new Entree<>(cle, null);
        return entrees.contient(recherche);
    }

    /**
     * Récupère la valeur associée à la clé spécifiée.
     *
     * @param cle la clé associée à la valeur à récupérer
     * @return la valeur associée à la clé
     */
    public V valeur(C cle){

        V val = null;

        if (entrees.estVide()) {
            val = null;
        } else {
            for(int i = 0; i<entrees.taille();i++) {
                Entree<C, V> element = entrees.element(i);
                if(element.cle.equals(cle))
                    val = element.valeur;
            }
        }
        return val;
    }
}
