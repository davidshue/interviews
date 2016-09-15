package grid

import org.junit.Test

import static org.junit.Assert.assertEquals

/**
 * Created by dshue1 on 8/19/16.
 */
class GridPathFinderTest {
	@Test
	void testPath() {
		def grid = [[0,1,0,0], [0,0,0,0], [0,0,0,0], [0,0,0,0]]

		int expected = 6

		GridPathFinder finder = new GridPathFinder()
		int output = finder.findNumOfPath(grid)

		print output

		assertEquals expected, output
	}
}
