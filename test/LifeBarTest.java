package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.model.LifeBar;

public class LifeBarTest {
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
}
