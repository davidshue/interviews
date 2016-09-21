package fb

import org.junit.Test

import static org.junit.Assert.assertEquals

/**
 * Created by dshue1 on 9/20/16.
 */
class BubFinderTest {
	@Test
	void test() {
		BugFinder finder = new BugFinder()

		int output = finder.getBugVersion(100)

		int expected = finder.realBug

		println output
		println expected

		assertEquals expected, output
	}
}
