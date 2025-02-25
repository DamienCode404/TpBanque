package banque.model;

public class Simple extends Compte {

	public Simple(int code, double solde,Carte carte) {
		super(code, solde,5,carte);
	}

	@Override
	public boolean verifierSolde(double montant) {
		if(this.solde-montant>this.taxe) {
			return true;
		}
		System.out.println("Il y a un problème dans votre solde");
		System.out.println("Solde: "+ this.solde);
		System.out.println("taxe: "+ this.taxe);
		return false;
	}


}
