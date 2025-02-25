package banque.model;

public class Payant extends Compte{

	private double decouvert;
	
	public Payant(Carte carte, double solde, double decouvert) {
		super(carte, solde-50, 1);
		this.decouvert=Math.abs(decouvert);
	}
	
	@Override
	protected boolean verif(double montant) {
		if(solde+montant+decouvert-taxe>=0) {return true;}
		return false;
	}

	@Override
	public String toString() {
		return "Payant [numero=" + numero + ", carte=" + carte + ", solde=" + solde + ", taxe=" + taxe + ", decouvert="
				+ decouvert + "]";
	}

	
}
