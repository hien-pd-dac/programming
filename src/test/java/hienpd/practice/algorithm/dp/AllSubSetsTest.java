package hienpd.practice.algorithm.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Test;

public class AllSubSetsTest {
	@Test
	public void test() {
		assertEquals("GIVEN a 1-size set, THEN return all the sub-sets.",
				true, new AllSubSets(Set.of(2)).solve()
						.containsAll(List.of(Set.of(), Set.of(2))));
		// assertEquals("GIVEN a n-size set, THEN return all the sub-sets.",
		// true, new AllSubSets(Set.of(1, 3, 4)).solve()
		// .containsAll(List.of(
		// Set.of(),
		// Set.of(3),
		// Set.of(4),
		// Set.of(1, 3),
		// Set.of(1, 4),
		// Set.of(3, 4),
		// Set.of(1, 3, 4))));
		assertThat("GIVEN a n-size set, THEN return all the sub-sets.",
				new AllSubSets(Set.of(1, 3, 4)).solve(),
				containsInAnyOrder(List.of(
						Set.of(),
						Set.of(1),
						Set.of(3),
						Set.of(4),
						Set.of(1, 3),
						Set.of(1, 4),
						Set.of(3, 4),
						Set.of(1, 3, 4)).toArray()));
	}
}
