package banque.model;

public class Payant extends Compte {
	
	private double montantDecouvert;

	public Payant(int code, double solde,Carte carte, double montantDecouvert) {
		super(code, solde-50, 1, carte);
		this.montantDecouvert = -montantDecouvert;
		// TODO Auto-generated constructor stub
	}

	public double getMontantDecouvert() {
		return montantDecouvert;
	}

	public void setMontantDecouvert(double montantDecouvert) {
		this.montantDecouvert = montantDecouvert;
	}

	@Override
	public boolean verifierSolde(double montant) {
		if(this.solde-this.taxe-montant>this.montantDecouvert) {
			System.out.println("Le montant est validé");
		
			return true;
		}
		System.out.println("Solde: "+ this.solde);
		System.out.println("taxe: "+ this.taxe);
		System.out.println("Il y a un problème dans votre solde");
		return false;
	}

}
