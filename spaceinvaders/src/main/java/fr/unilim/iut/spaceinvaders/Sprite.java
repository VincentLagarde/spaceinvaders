package fr.unilim.iut.spaceinvaders;

public abstract class Sprite {

	protected int vitesse;
	protected Position origine;
	protected Dimension dimension;

	public Sprite(Dimension dimension, Position origine, int vitesse) {
		super();
		this.dimension = dimension;
		this.origine = origine;
		this.vitesse = vitesse;
	}

	public Sprite() {
		super();
	}

	public boolean occupeLaPosition(int x, int y) {
			return (estAbscisseCouverte(x) && estOrdonneeCouverte(y));
	}

	private boolean estOrdonneeCouverte(int y) {
		return (ordonneeLaPlusBasse()<=y) && (y<=ordonneeLaPlusHaute());
	}

	public int ordonneeLaPlusHaute() {
		return this.origine.ordonnee();
	}

	public int ordonneeLaPlusBasse() {
		return ordonneeLaPlusHaute()-this.dimension.hauteur()+1;
	}

	private boolean estAbscisseCouverte(int x) {
		return (abscisseLaPlusAGauche()<=x) && (x<=abscisseLaPlusADroite());
	}

	public int abscisseLaPlusAGauche() {
		return this.origine.abscisse();
	}

	public int abscisseLaPlusADroite() {
		return abscisseLaPlusAGauche()+this.dimension.longueur()-1;
	}

	public void deplacerHorizontalementVers(Direction direction){
		this.origine.changerAbscisse(this.origine.abscisse() + direction.valeur()*vitesse);
	}
	
	public int abscisse() {
		return abscisseLaPlusAGauche();
	}

	public void positionner(int x, int y) {
		 this.origine.changerAbscisse(x);
		 this.origine.changerOrdonnee(y);
	}

	public int longueur() {
		return this.dimension.longueur();
	}

	public int hauteur() {
		return this.dimension.hauteur();
	}
	
	public void deplacerVerticalementVers(Direction direction){
		this.origine.changerOrdonnee(this.origine.ordonnee() + direction.valeur()*vitesse);
		
	}

}