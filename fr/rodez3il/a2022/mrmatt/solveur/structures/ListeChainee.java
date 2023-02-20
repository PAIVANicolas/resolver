package fr.rodez3il.a2022.mrmatt.solveur.structures;

public class ListeChainee<T> implements Liste<T> {

    private class Maillon {
        private T donnee;
        private Maillon suivant;

        public Maillon(T donnee) {
            this.donnee = donnee;
            this.suivant = null;
        }
    }

    private Maillon tete;
    private int taille;

    public ListeChainee() {
        tete = null;
        taille = 0;
    }

    /**
     * Ajoute un élément à la fin de la liste.
     *
     * @param element l'élément à ajouter
     */
    public void ajouter(T element) {
        Maillon nouveauMaillon = new Maillon(element);
        if (tete == null) {
            tete = nouveauMaillon;
        } else {
            Maillon dernierMaillon = tete;
            while (dernierMaillon.suivant != null) {
                dernierMaillon = dernierMaillon.suivant;
            }
            dernierMaillon.suivant = nouveauMaillon;
        }
        taille++;
    }

    /**
     * Vérifie si la liste est vide.
     * @return true si la liste est vide, false sinon.
     **/
    public boolean estVide() {
        return tete == null;
    }

    /**
     * Renvoie le nombre d'éléments dans la liste.
     * @return la taille de la liste
     **/
    public int taille() {
        return taille;
    }

    /**
     * Enlève l'élément situé à l'indice spécifié dans cette liste.
     * Décale les éléments suivants pour combler le vide laissé par l'élément supprimé.
     *
     * @param i l'indice de l'élément à enlever
     * @return l'élément enlevé de la liste
     * @throws IndexOutOfBoundsException si l'indice est hors limites (i < 0 || i >= taille())
     */
    public T enlever(int i) {
        if (i < 0 || i >= taille) {
            throw new IndexOutOfBoundsException();
        }
        T elementEnleve;
        if (i == 0) {
            elementEnleve = tete.donnee;
            tete = tete.suivant;
        } else {
            Maillon maillonPrecedent = tete;
            for (int j = 0; j < i - 1; j++) {
                maillonPrecedent = maillonPrecedent.suivant;
            }
            elementEnleve = maillonPrecedent.suivant.donnee;
            maillonPrecedent.suivant = maillonPrecedent.suivant.suivant;
        }
        taille--;
        return elementEnleve;
    }

    /**
     * Retourne l'élément à l'index spécifié dans la liste chaînée.
     * @param i l'index de l'élément à récupérer (0-indexé)
     * @return l'élément à l'index spécifié dans la liste chaînée
     * @throws IndexOutOfBoundsException si l'index est hors de la plage valide (0 <= index < taille())
     **/
    public T element(int i) {
        if (i < 0 || i >= taille) {
            throw new IndexOutOfBoundsException();
        }
        Maillon maillonCourant = tete;
        for (int j = 0; j < i; j++) {
            maillonCourant = maillonCourant.suivant;
        }
        return maillonCourant.donnee;
    }

    /**
     * Retourne vrai si l'élément spécifié est présent dans la liste.
     * @param e l'élément à rechercher dans la liste.
     * @return vrai si l'élément est présent dans la liste, faux sinon.
     **/
    public boolean contient(T e) {
        Maillon maillonCourant = tete;
        while (maillonCourant != null) {
            if (maillonCourant.donnee.equals(e)) {
                return true;
            }
            maillonCourant = maillonCourant.suivant;
        }
        return false;
    }
}
