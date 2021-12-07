package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.UniLifeGameApp;
import com.company.model.FallingObject;
import com.company.model.FallingObjectType;
import com.company.model.LifeBar;
import com.company.model.Student;
import com.company.model.UniLifeGame;

import java.lang.reflect.Field;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UniLifeGameAppTest {

	UniLifeGameApp gameApp;

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

	/**
	 * Helper method to check game is getting initialize
	 */
	@Test
	public void testUniLifeGameApp() {
		System.out.println("Testing Inizilation of the UniLifeGameApp.");
		gameApp = new UniLifeGameApp();
		assertNotNull(gameApp);
	}

	/**
	 * Helper method testing the functionality of the lifeBar
	 */
	@Test
	public void testLifeBar() {
		System.out.println("Testing the Life Bar.");
		LifeBar lifeBar = new LifeBar();

		int expected = 80;
		// initial value for level is the MAX = 80
		assertEquals(expected, lifeBar.getLevel());
		// dropLevel = -1 so this will drop the value until we react 60
		while (lifeBar.getLevel() > 60) {
			lifeBar.dropLevel();
			expected--;
		}
		assertEquals(expected, lifeBar.getLevel());

		// increasing level by the INC_SPEED = 8
		expected = 68;
		lifeBar.increaseLevel();
		assertEquals(expected, lifeBar.getLevel());
	}

	@Test
	public void testStudent()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		System.out.println("Testing the Student.");
		Student student = new Student();

		Field drunkStatus = student.getClass().getDeclaredField("isDrunk");
		drunkStatus.setAccessible(true);

		assertThat("false", is(drunkStatus.get(student).toString()));
		student.changeDrunkStatus(true);
		assertNotEquals("false", drunkStatus.get(student).toString());
		student.changeDrunkStatus(false);

		// get student coordinates
		int expectedX = student.getX();

		// center student
		student.center();
		assertEquals(expectedX, student.getX());

		// move student to the left
		student.moveLeft();
		assertNotEquals(expectedX, student.getX());

		// move student to the right
		student.moveRight();
		assertEquals(expectedX, student.getX());

		// center student
		student.center();
		student.drinkCoffee();
		student.moveLeft();
		assertTrue(expectedX - 20 == student.getX());
	}

	/**
	 * Helper method to test the falling objects
	 */
	@Test
	public void testFallingObject() {
		System.out.println("Testing the Falling Object.");
		FallingObjectType food = FallingObjectType.Food;
		FallingObject fallingObject = new FallingObject(food, 10);

		assertFalse(fallingObject.isCollected());
		fallingObject.setCollected();
		assertTrue(fallingObject.isCollected());
		assertSame(food, fallingObject.getType());

		assertEquals(0, fallingObject.getY());
		assertEquals(10, fallingObject.getX());

		fallingObject.fall();
		assertEquals(15, fallingObject.getY());

		FallingObjectType beer = FallingObjectType.Beer;
		assertNotSame(food, beer);
	}

	@Test
	public void testUniLifeGame() throws NoSuchFieldException, SecurityException {
		System.out.println("Testing the Uni Life Game.");
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
		
		
	}
}
