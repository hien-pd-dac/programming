package hienpd.practice.algorithm.dp;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TowersOfHanoiTest {
	@Test
	public void test_Case() {
		assertEquals("n=1", List.of("A-C"),
				new TowersOfHanoi(1).solve());
		assertEquals("n=2", List.of("A-B", "A-C", "B-C"),
				new TowersOfHanoi(2).solve());
	}
}
