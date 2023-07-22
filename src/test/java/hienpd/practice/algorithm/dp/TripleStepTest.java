package hienpd.practice.algorithm.dp;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TripleStepTest {
	@Test
	public void test() {
		var task = new TripleStep();
		assertEquals("When n=1", 1, task.maxWaysToRunUpStairs(1));
		assertEquals("When n=2", 2, task.maxWaysToRunUpStairs(2));
		assertEquals("When n=3", 4, task.maxWaysToRunUpStairs(3));
		assertEquals("When n=4", 7, task.maxWaysToRunUpStairs(4));
	}
}
