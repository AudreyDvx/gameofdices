package fr.unilim.iut.gameofdices;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Test;

public class DiceTest {
	Dice theDice;

	@Test
	public void rollReturnsAValue() {
		theDice = new Dice(new Random());
		for (int i = 0; i < 100; i++) {
			int result = theDice.roll();
			assertTrue(result >= 1);
			assertTrue(result <= 6);
		}
	}
	
	@Test(expected = RuntimeException.class)
 	public void identifyBadValuesGreaterThanNumberOfFaces() {
		Random alea = mock(Random.class);
		theDice = new Dice(alea);
		when(theDice.roll()).thenReturn(7);
     	theDice.roll();
 	}  
	
	
	@Test(expected = RuntimeException.class)
 	public void identifyBadValuesLesserThanOne() {
		Random alea = mock(Random.class);
		theDice = new Dice(alea);
		when(theDice.roll()).thenReturn(-1);
     	theDice.roll();
 	}
	
	
	
}
