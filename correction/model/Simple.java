package banque.model;

public class Simple extends Compte {

	public Simple(Carte carte, double solde) {
		super(carte, solde, 5);
	}

	@Override
	protected boolean verif(double montant) {
		return solde+montant-taxe>=0;
		/*if(solde+montant-taxe>=0) {return true;}
		return false;*/
	}

	@Override
	public String toString() {
		return "Simple [numero=" + numero + ", carte=" + carte + ", solde=" + solde + ", taxe=" + taxe + "]";
	}

	
	
}
