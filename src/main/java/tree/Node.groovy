package tree

import groovy.transform.ToString

/**
 * Created by dshue1 on 9/20/16.
 */
@ToString(includeNames = true, includePackage = false, ignoreNulls = true)
class Node<T> {
	T data
	Node<T> left
	Node<T> right

	boolean isLeaf() {
		!left && !right
	}
}
