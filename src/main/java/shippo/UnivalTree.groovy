package shippo

/**
 * Created by dshue1 on 9/20/16.
 */
class UnivalTree {
	boolean isUnival(Object root) {
		return _isUnival(root, getChildren(root))
	}

	private boolean _isUnival(Object parent, Tuple2<Object, Object> children) {
		if (isLeaf(parent)) {
			return true
		}

		if ((parent != children.first && children.first) ||
			(parent != children.second && children.second)) {
			return false
		}

		if (!children.first && children.second) {
			return  _isUnival(children.second, getChildren(children.second))
		}
		else if (children.first && !children.second) {
			return _isUnival(children.first, getChildren(children.first))
		}

		return _isUnival(children.first, getChildren(children.first)) && _isUnival(children.second, getChildren(children.second))
	}

	private Tuple2<Object, Object> getChildren(Object parent) {
		// TODO: assume this is implemented
		new Tuple2<Object, Object>(null, null)
	}

	private boolean isLeaf(Object node) {
		// TODO: assume this is implemented
		return true
	}
}
