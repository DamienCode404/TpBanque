package banque.test;

import banque.model.Carte;
import banque.model.Compte;
import banque.model.Payant;
import banque.model.Simple;

public class Test {

	public static void main(String[] args) {
		
		Simple s1 = new Simple(Carte.MasterCard,100);
		Payant p1 = new Payant(Carte.MasterCard,160,200);
		s1.versement(1);
		p1.retrait(10);
		p1.transfert(20, s1);
		
		System.out.println("Nombre de transaction : "+Compte.getNbTransac());
		System.out.println("Total taxe : "+Compte.getTotalTaxe());
		System.out.println(p1);
		
		
		System.out.println("Liste des comptes dans la banque : ");

		for(Compte c : Compte.getBanque()) 
		{
			System.out.println(c);
		}
		
	}

}
