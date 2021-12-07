package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ 
	UniLifeGameTest.class, 
	UniLifeGameAppTest.class,
	FallingObjectTest.class,
	LifeBarTest.class })

public class TestSuite {
}