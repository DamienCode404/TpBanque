package banque.model;

import banque.test.TestBanque;

public abstract class Compte {
	
	protected static int compteur;
	protected int code;
	protected double solde;
	protected double taxe;
	protected Carte carte;
	protected static double totTaxe;
	protected static int nbTransactions;

	@Override
	public String toString() {
		return "Compte [code=" + code + ", solde=" + solde + "]";
	}

	public Compte(int code, double solde, double taxe, Carte carte) {
		compteur++;
		this.code = code;
		this.taxe = taxe;
		this.carte = carte;
		this.solde = solde - carte.getPrix();
		TestBanque.listeDeComptes.add(this);
		
	}
	
	public void versement(double montant) {
		
		if(this.verifierSolde(0)) {
			this.solde = this.solde + montant - this.taxe;
			totTaxe+=this.taxe;
			nbTransactions++;
			System.out.println("Versement validé, le solde du compte "+this.code+ " est maintenant à " + this.getSolde());
		}else {
			System.out.println("Le versement ne peut pas etre effectué");
		}
		
		return;
	}
	
	public void retrait(double montant) {
		if(this.verifierSolde(montant)) {
			this.solde = this.solde - montant - this.taxe;
			totTaxe+=this.taxe;
			nbTransactions++;
			System.out.println("Retrait validé, le solde du compte "+this.code+ " est maintenant à " + this.getSolde());
		}else {
			System.out.println("Le retrait ne peut pas etre effectué");
		}
		return;
	}
	
	
	public void transfert(Compte rec, double montant) {
		if(this.verifierSolde(montant) && rec.verifierSolde(0)) {
			this.retrait(montant);
			rec.versement(montant);
			System.out.println("Transfert effectué !");
		}else {
			System.out.println("Il y a un problème lors du transfert");
		}
		
		return;
	}
	
	public abstract boolean verifierSolde(double montant);

	public static int getCompteur() {
		return compteur;
	}

	public static void setCompteur(int compteur) {
		Compte.compteur = compteur;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public double getTaxe() {
		return taxe;
	}

	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}
	
	public double getTotTaxe() {
		return totTaxe;
	}

	public int getNbTransactions() {
		return nbTransactions;
	}



}
