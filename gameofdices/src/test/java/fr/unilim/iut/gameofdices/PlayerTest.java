package fr.unilim.iut.gameofdices;

import java.util.Random;   
import org.junit.Test;
import static org.junit.Assert.*;
import fr.unilim.iut.gameofdices.Dice;
import static org.mockito.Mockito.mock; 
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PlayerTest {
	Player player;

	@Test
	public void lastValueNotInitialized() {
		player = new Player("John Doe", new Dice(new Random()));
		assertFalse(player.getLastValue().isPresent());
	}

	@Test
	public void lastValueInitialized() {
		player = new Player("John Doe", new Dice(new Random()));
		player.play();
		assertTrue(player.getLastValue().isPresent());
	}
	
	@Test
	public void throwDiceOnlyTwice() {
		Dice dice = mock(Dice.class);
		player = new Player("John Doe", dice);
		player.play();
		verify(dice, times(2)).roll();
	}  
	
	@Test
	public void keepTheMaximum() {
		Dice dice = mock(Dice.class);
		player = new Player("John Doe", dice);

		when(dice.roll()).thenReturn(2).thenReturn(5);
		player.play();
		assertEquals(player.getLastValue().get(), new Integer(5));

		when(dice.roll()).thenReturn(6).thenReturn(1);
		player.play();
		assertEquals(player.getLastValue().get(), new Integer(6));
	}
	
}   
