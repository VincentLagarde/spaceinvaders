package fr.unilim.iut.spaceinvaders;

public class Vaisseau {
	
	private int vitesse;
	private Position origine;
	private Dimension dimension;

	public Vaisseau(int longueur, int hauteur) {
	    this(longueur, hauteur, 0, 0);
    }

   public Vaisseau(int longueur, int hauteur, int x, int y) {
	   this(new Dimension(longueur, hauteur), new Position(x, y));
    }

    public Vaisseau(Dimension dimension, Position positionOrigine) {
    	this(dimension, positionOrigine, 1);
    }
    
    public Vaisseau(Dimension dimension, Position positionOrigine, int vitesse) {
		this.dimension = dimension;
		this.origine = positionOrigine;
		this.vitesse = vitesse;
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

	public void seDeplacerVersLaDroite() {
		this.origine.changerAbscisse(this.origine.abscisse()+vitesse);
		
	}

	public int abscisse() {
		return abscisseLaPlusAGauche();
	}

	public void seDeplacerVersLaGauche() {
		this.origine.changerAbscisse(this.origine.abscisse()-vitesse);
		
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

}
