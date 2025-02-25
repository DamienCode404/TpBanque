package banque.model;

public class Premium extends Compte {

	public Premium(int code, double solde, Carte carte) {
		super(code, solde-150, 0,carte);
	}

	@Override
	public boolean verifierSolde(double montant) {
		return true;
	}

}
