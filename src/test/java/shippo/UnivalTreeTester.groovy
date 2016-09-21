package shippo

import org.junit.Test

import static junit.framework.TestCase.assertTrue

/**
 * Created by dshue1 on 9/20/16.
 */
class UnivalTreeTester {
	@Test
	void test() {
		Object root = new Object()

		UnivalTree tree = new UnivalTree()

		assertTrue tree.isUnival(tree)
	}
}
