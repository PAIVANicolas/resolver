package fr.rodez3il.a2022.mrmatt.solveur.structures;

import java.util.Arrays;

public class ListeTableau<E> implements Liste<E> {

    private static final int TAILLE_INITIALE = 10;
    private E[] elements;
    private int nbElement;

    /**
     * Constructeur qui initialise le tableau d'éléments à la taille TAILLE_INITIALE.
     */
    public ListeTableau() {
        this.elements = (E[]) new Object[TAILLE_INITIALE];
        this.nbElement = 0;
    }

/**
 Ajoute un élément à la fin de la liste.
 Si le tableau est plein, sa taille est doublée pour pouvoir ajouter l'élément.
 @param element l'élément à ajouter
 @throws NullPointerException si l'élément est null
 */
    @Override
    public void ajouter(E element) {
        if (element == null) {
            throw new NullPointerException("L'élément ne peut pas être null");
        }
        if (nbElement == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[nbElement++] = element;
    }

    /**
     * Indique si la liste est vide.
     *
     * @return true ssi la liste est vide.
     */
    @Override
    public boolean estVide() {
        return nbElement == 0;
    }

    /**
     * Indique la taille de la liste.
     *
     * @return La taille de la liste.
     */
    @Override
    public int taille() {
        return nbElement;
    }

    /**

     Cette méthode permet d'enlever l'élément à la position i dans la liste.
     @param i la position de l'élément à enlever
     @return L'élément qui a été enlevé de la liste
     @throws IndexOutOfBoundsException Si la position spécifiée n'est pas valide (inférieure à 0 ou supérieure à la taille de la liste - 1)
     */
    @Override
    public E enlever(int i) {
        if (i < 0 || i >= nbElement) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for the list with size " + nbElement);
        }
        E removedElement = elements[i];
        for (int j = i; j < nbElement - 1; j++) {
            elements[j] = elements[j + 1];
        }
        nbElement--;
        return removedElement;
    }

    /**

     Récupère l'élément situé à la position spécifiée.
     @param i la position de l'élément souhaité.
     @return l'élément situé à la position i.
     @throws IndexOutOfBoundsException si i est inférieur à 0 ou supérieur à la taille de la liste.
     */
    @Override
    public E element(int i) {
        if (i < 0 || i >= nbElement) {
            throw new IndexOutOfBoundsException();
        }
        return elements[i];
    }

    @Override
    public boolean contient(E e) {
        return false;
    }
}
