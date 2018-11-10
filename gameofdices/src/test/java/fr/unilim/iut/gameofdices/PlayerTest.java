package fr.unilim.iut.gameofdices;

import java.util.Random;  
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

		Player player;

		@Test
		public void lastValueNotInitialized() {
			player = new Player("John Doe", new Dice(new Random()));
			assertEquals(player.getLastValue(), -1);
		}

		@Test
		public void lastValueInitialized() {
			player = new Player("John Doe", new Dice(new Random()));
			player.play();
			assertNotEquals(player.getLastValue(), -1);
		}

}
