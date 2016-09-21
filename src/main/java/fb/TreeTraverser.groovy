package fb

/**
 * Created by dshue1 on 9/20/16.
 */
class TreeTraverser {
	void printTree(int parent) {
		println parent
		Tuple2<Integer, Integer> children = getChildren(parent)
		if (children.first) {
			printTree(children.first)
		}
		if (children.second) {
			printTree(children.second)
		}
	}

	private Tuple2<Integer, Integer> getChildren(int parent) {
		new Tuple2(first: null, second: null)
	}

}
