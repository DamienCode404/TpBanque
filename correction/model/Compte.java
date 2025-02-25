package banque.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {

	protected int numero;
	protected Carte carte;
	protected double solde;
	protected double taxe;
	
	private static int nbTransac=0;
	private static double totalTaxe = 0;
	
	private static List<Compte> banque = new ArrayList();
	
	public Compte(Carte carte, double solde, double taxe) {
		banque.add(this);
		this.numero= banque.size();
		this.carte = carte;
		this.taxe = taxe;
		this.solde = solde - carte.getPrix();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
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
	
	public static int getNbTransac() {
		return nbTransac;
	}

	public static double getTotalTaxe() {
		return totalTaxe;
	}

	public static List<Compte> getBanque() {
		return banque;
	}

	protected abstract boolean verif(double montant);
	
	
	public final void retrait(double montant) 
	{
		if(verif(-montant)) 
		{
			solde= solde-montant-taxe;
			totalTaxe+= taxe;
			nbTransac++;
			System.out.println("Retrait de "+montant+"€ ok");
		}
		else 
		{
			System.out.println("Retrait de "+montant+"€ refuse");
		}
	}
	
	
	
	public final void versement(double montant) 
	{
		if(verif(montant)) 
		{
			solde= solde+montant-taxe;
			totalTaxe+= taxe;
			nbTransac++;
			System.out.println("Versement de "+montant+"€ ok");
		}
		else 
		{
			System.out.println("Versement de "+montant+"€ refuse");
		}
	}
	
	
	public final void transfert(double montant, Compte destinataire) 
	{
		if(this.verif(-montant) && destinataire.verif(montant)) 
		{
			this.retrait(montant);
			destinataire.versement(montant);
			System.out.println("Transfert de "+montant+"€ ok");
		}
		else 
		{
			System.out.println("Transfert de "+montant+"€ refuse");
		}
	}
	
}
