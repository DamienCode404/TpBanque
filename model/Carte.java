package banque.model;

public enum Carte {
	cb(0),visa(5),mastercard(10);

	private double prix;
	
	private Carte(double prix) {
		this.prix = prix;
	}
	
	
	public double getPrix(){
		return prix;
		
	}
	
	

}
