package fr.unilim.iut.spaceinvaders.model;

public class Collision {
	
	public static boolean detecterCollision(Sprite sprite1, Sprite sprite2){	
		for(int i=0; i<sprite1.dimension.longueur(); i++){
			for(int j=0; j<sprite1.dimension.hauteur(); j++){
				if(sprite2.occupeLaPosition(sprite1.origine.abscisse()+i, sprite1.origine.ordonnee()+j)){
					return true;
				}
			}
		}
		return false;
		
	}

}
