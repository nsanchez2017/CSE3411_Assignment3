package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.company.UniLifeGameApp;

import static org.junit.Assert.*;

public class UniLifeGameAppTest {

	UniLifeGameApp gameApp;

	/**
	 * Helper method to initialize UniLifeGameApp
	 */
	@Before
	public void setup() {
		System.out.println("Initlializing Test.");
		gameApp = new UniLifeGameApp();
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
	@Ignore
	public void testUniLifeGameApp() {
		System.out.println("Testing Inizilation of the UniLifeGameApp.");
		assertNotNull(gameApp);
	}
}
