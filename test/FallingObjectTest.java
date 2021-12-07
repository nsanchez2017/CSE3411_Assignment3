package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.model.FallingObject;
import com.company.model.FallingObjectType;

public class FallingObjectTest {
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
	 * Helper method to test falling objects class
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
}
