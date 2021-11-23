package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

	private final String immatriculation;
	private final List<Stationnement> myStationnements = new LinkedList<>();

	public Voiture(String i) {
		if (null == i) {
			throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
		}

		immatriculation = i;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Fait rentrer la voiture au garage 
         * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws java.lang.Exception Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) throws Exception {
		// Et si la voiture est déjà dans un garage ?
		Stationnement s = new Stationnement(this, g);
                if (this.estDansUnGarage()){
                        throw new IllegalArgumentException("La voiture est déjà dans le garage");
                }else{
                    myStationnements.add(s);
                }
	}

	/**
	 * Fait sortir la voiture du garage 
         * Précondition : la voiture doit être dans un garage
	 *
	 * @throws java.lang.Exception si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws Exception {
		//throw new UnsupportedOperationException("Pas encore implémenté");
		// TODO: Implémenter cette méthode
		// Trouver le dernier stationnement de la voiture
		// Terminer ce stationnement
                if (this.estDansUnGarage() == false){
                    throw new IllegalArgumentException("La voiture doit être dans un garage");

                }else{
                    myStationnements.get(myStationnements.size()-1).terminer();
                }
	}

	/**
	 * @return l'ensemble des garages visités par cette voiture
	 */
	public Set<Garage> garagesVisites() {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
                Set<Garage> listeGarage = new HashSet<Garage>();
                for (Stationnement s : myStationnements){
                    listeGarage.add(s.getGarage());
                }     
                return listeGarage;
	}

	/**
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
		// Vrai si le dernier stationnement est en cours
                boolean c = false;
                if (myStationnements.size() > 0){
                    if (myStationnements.get(myStationnements.size()-1).estEnCours()){
                        c = true;
                    }
                }
                return c;
	}

	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des dates d'entrée / sortie dans ce
	 * garage
	 * <br>Exemple :
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out)
	 */
	public void imprimeStationnements(PrintStream out) {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
                for (Garage g : this.garagesVisites()){
                    out.println(g.toString());
                    for (Stationnement s : myStationnements){
                        if (s.getGarage() == g){
                            out.println(s.toString());
                        }
                    }
                }
	}
}
