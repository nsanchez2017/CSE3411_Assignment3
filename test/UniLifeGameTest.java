package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.model.FallingObject;
import com.company.model.FallingObjectType;
import com.company.model.LifeBar;
import com.company.model.UniLifeGame;

import static org.hamcrest.CoreMatchers.*;

public class UniLifeGameTest {

	/**
	 * Helper method to initialize UniLifeGameApp
	 */
	@Before
	public void setup() {
		System.out.println("Initlializing Test.");
	}

	/**
	 * Helper method to tearDown
	 */
	@After
	public void tearDown() {
		System.out.println("Exiting Test.");
	}

	@Test
	public void testUniLifeGame() throws NoSuchFieldException, SecurityException {
		UniLifeGame game = new UniLifeGame();

		// start game
		game.keyPressed(32);
		assertTrue(game.hasStarted());
		game.update();

		int studentX = game.getStudent().getX();

		// moving player left
		game.keyPressed(37);
		assertEquals(studentX - 10, game.getStudent().getX());
		// restart game
		game.keyPressed(82);
		assertEquals(studentX, game.getStudent().getX());
		// moving player right
		game.keyPressed(39);
		assertEquals(studentX + 10, game.getStudent().getX());
		// checking if game is over
		assertFalse(game.isGameOver());
		
		List<FallingObject> fallingObject = game.getFallingObjects();
		Map<FallingObjectType, LifeBar> lifeBar = game.getBars();
		
		List<FallingObject> emptyList = new ArrayList<>();
		
		assertThat(fallingObject, is(emptyList));
	}
}
