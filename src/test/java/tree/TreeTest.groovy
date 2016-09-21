package tree

import org.junit.Test

/**
 * Created by dshue1 on 9/21/16.
 */
class TreeTest {
	private def treeData = [
	    30: new Tuple2(12, 24),
	    12: new Tuple2(6, 15),
		25: new Tuple2(20, 27),
		6: new Tuple2(4, 5),
		20: new Tuple2(18, null)
	]
	@Test
	void testTree() {
		Tree tree = new Tree(treeData)

		println tree
	}
}
