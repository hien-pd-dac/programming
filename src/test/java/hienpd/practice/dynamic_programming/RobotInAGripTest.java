package hienpd.practice.dynamic_programming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RobotInAGripTest {
	@Test
	public void testNotFound() {
		assertEquals("WHEN not found any path, THEN return null.", "not found",
				new RobotInAGrip(2, 3, new int[][] {
						{ 0, 1, 0 },
						{ 1, 0, 0 },
				}).solve());
	}

	@Test
	public void testFound() {
		assertEquals("WHEN found a path in a 2x3, THEN return the path.", "D-R-R",
				new RobotInAGrip(2, 3, new int[][] {
						{ 0, 1, 0 },
						{ 0, 0, 0 },
				}).solve());
		assertEquals("WHEN found a path in a 4x3, THEN return the path.", "D-D-R-D-R",
				new RobotInAGrip(4, 3, new int[][] {
						{ 0, 0, 1 },
						{ 0, 1, 0 },
						{ 0, 0, 1 },
						{ 1, 0, 0 },
				}).solve());
	}
}
