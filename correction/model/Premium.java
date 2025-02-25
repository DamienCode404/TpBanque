package banque.model;

public class Premium extends Compte{


	public Premium(Carte carte, double solde) {
		super(carte, solde-150, 0);
	}

	@Override
	protected boolean verif(double montant) {
		return true;
	}

	@Override
	public String toString() {
		return "Premium [numero=" + numero + ", carte=" + carte + ", solde=" + solde + ", taxe=" + taxe + "]";
	}

	
}
