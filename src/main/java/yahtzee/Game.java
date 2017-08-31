package yahtzee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Game {

	private Random rng = new Random();
	
	public Collection<Integer> roll() {
		Collection<Integer> rolls = new ArrayList<>();
		for(int count = 1; count <= 5; count++) {
			rolls.add(rollDie());
		}
		return rolls;
	}

	private int rollDie() {
		return rng.nextInt(6);
	}

}
