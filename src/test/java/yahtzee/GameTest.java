package yahtzee;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameTest {
	
	@InjectMocks
	private Game underTest;
	
	@Mock
	private Random rng;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldGiveMeFiveDiceOnARoll() {
		Collection<Integer> results = underTest.roll();
		
		assertThat(results, hasSize(5));
	}
	
	@Test
	public void shouldGiveRollsFromSixSidedDice() {
		
		when(rng.nextInt(6)).thenReturn(1, 2, 3, 4, 5);
		
		Collection<Integer> results = underTest.roll();
		
		assertThat(results, containsInAnyOrder(5, 4, 3, 2, 1));
	}
}
