package hienpd.cp.leetcode.top150.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LengthOfLastWordTest {
	@Test
	public void testCase() {
		assertEquals("BDD",
				4,
				LengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
	}
}
