package fr.rodez3il.a2022.mrmatt.solveur;

import fr.rodez3il.a2022.mrmatt.solveur.structures.ListeTableau;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;
import fr.rodez3il.a2022.mrmatt.sources.objets.*;

import java.util.ArrayList;
import java.util.List;

public class Solveur {

	/**
	 * Trouve la solution pour un niveau donné.
	 *
	 * @param niveau le niveau à résoudre
	 * @return la solution sous forme de chaîne de caractères, ou null s'il n'y en a pas
	 */
	public static String trouverSolution(Niveau niveau) {
		ListeTableau<Noeud> traites = new ListeTableau<>();
		ListeTableau<Noeud> aTraiter = new ListeTableau<>();
		aTraiter.ajouter(new Noeud(niveau, null, null));

		while (!aTraiter.estVide()) {
			Noeud n = aTraiter.enlever(0);
			traites.ajouter(n);

			// Si la solution est directement donnée par le nœud actuel, on retourne cette solution
			String solution = n.calculerFils();
			if (solution != null) {
				return solution;
			}

			// Sinon, on ajoute les nœuds fils du nœud actuel à la liste à traiter s'ils n'ont pas été déjà traités
			ListeTableau<Noeud> tabFils = n.getFils();
			for (int i = 0 ; i < tabFils.taille(); i++) {
				if (!traites.contient(tabFils.element(i)) && !aTraiter.contient(tabFils.element(i))) {
					aTraiter.ajouter(tabFils.element(i));
				}
			}
		}
	// Si on a parcouru tous les nœuds et qu'on n'a pas trouvé de solution, on retourne null
	return null;
}

	public static void main(String[] args) {
		String solution = trouverSolution(new Niveau("niveaux/1rocher.txt"));
		if (solution == null) {
			System.out.println("Pas de solution.");
		} else {
			System.out.println("Une solution est : " + solution);
		}
	}
}
