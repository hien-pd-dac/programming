package hienpd.practice.algorithm.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MagicIndexTest {

	@Test
	public void testNotFound() {
		assertEquals("WHEN no magic index is found, THEN return `-1`.", -1,
				new MagicIndex(new int[] { 1, 2, 3, 4 }).solve());
	}

	@Test
	public void testFound() {
		assertEquals("WHEN the magic index is the 1st-element, THEN return 0.", 0,
				new MagicIndex(new int[] { 0, 2, 3, 4 }).solve());
		assertEquals("WHEN the magic index is the last element, THEN return the last index.", 3,
				new MagicIndex(new int[] { -1, 0, 1, 3 }).solve());
		assertEquals("WHEN the magic index is in between the first and the last element, THEN return that index.", 2,
				new MagicIndex(new int[] { -1, 0, 2, 5 }).solve());
	}
}
