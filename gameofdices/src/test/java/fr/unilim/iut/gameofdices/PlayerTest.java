package fr.unilim.iut.gameofdices;

import java.util.Random;  
import org.junit.Test;
import static org.junit.Assert.*;

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
}   
