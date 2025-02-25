package banque.test;

import java.util.ArrayList;

import banque.model.Carte;
import banque.model.Compte;
import banque.model.Payant;
import banque.model.Premium;
import banque.model.Simple;

public class TestBanque {

	public static ArrayList<Compte> listeDeComptes = new ArrayList<Compte>();

	public TestBanque() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		Simple s1 = new Simple(1,5000,Carte.cb);
		Simple s2 = new Simple(2,5000,Carte.cb);
		Payant p1 = new Payant(3,2500,Carte.visa,250);
		Payant p2= new Payant(4,2500,Carte.visa,250);
		Premium pr1 = new Premium(5,60000,Carte.mastercard);
		Premium pr2 = new Premium(6,60000,Carte.mastercard);

		s1.versement(5000);	
		s1.transfert(pr1, 300);
		
		s2.retrait(60000);
		
		s2.retrait(60);
		
		
		p1.retrait(1450);
		
		System.out.println("Nombre de comptes: "+Compte.getCompteur());
		for(Compte compte : listeDeComptes) {
			System.out.println(compte);
		}

	}

}
