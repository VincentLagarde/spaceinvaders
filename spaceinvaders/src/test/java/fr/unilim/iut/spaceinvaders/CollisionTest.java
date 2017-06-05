package fr.unilim.iut.spaceinvaders;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import fr.unilim.iut.spaceinvaders.model.Collision;
import fr.unilim.iut.spaceinvaders.model.Dimension;
import fr.unilim.iut.spaceinvaders.model.Envahisseur;
import fr.unilim.iut.spaceinvaders.model.Missile;
import fr.unilim.iut.spaceinvaders.model.Position;

public class CollisionTest {
	
	private Missile sprite1;
	private Envahisseur sprite2;

	 @Test
	   public void test_pasDeCollision() {
		    sprite1 = new Missile(new Dimension(1,1), new Position(0,0), 1);
		    sprite2 = new Envahisseur(new Dimension(1,1), new Position(1,1), 1);
		    
		    assertEquals(false, Collision.detecterCollision(sprite1,sprite2));
	 }
	 
	 @Test
	   public void test_CollisionEnBasEnvahisseur() {
		    sprite1 = new Missile(new Dimension(1,1), new Position(3,0), 1);
		    sprite2 = new Envahisseur(new Dimension(3,3), new Position(3,1), 1);
		    
		    assertEquals(true, Collision.detecterCollision(sprite1,sprite2));
	 }
	 
	 @Test
	   public void test_CollisionCoteDroitEnvahisseur() {
		    sprite1 = new Missile(new Dimension(2,2), new Position(3,3), 1);
		    sprite2 = new Envahisseur(new Dimension(5,3), new Position(4,3), 1);
		    
		    assertEquals(true, Collision.detecterCollision(sprite1,sprite2));
	 }
	 
}
