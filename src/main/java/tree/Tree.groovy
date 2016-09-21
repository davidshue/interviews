package tree

import groovy.transform.ToString

/**
 * Created by dshue1 on 9/20/16.
 */
@ToString(includeNames = true, includePackage = false, ignoreNulls = true)
class Tree<T> {
	Node<T> root

	/**
	 tree representation is a map, with the key as the parent node, and a tuple as its immediate children.
	 a valid tree can have only one root. A root that has no parent. It should always be the first element of the
	 LinkedHashMap
	 */
	Tree(LinkedHashMap<T, Tuple2<T, T>> treeRepresentation){
		if (!treeRepresentation)
			throw new IllegalArgumentException('empty map passed to the tree')

		LinkedHashMap<T, Tuple2<T, T>> treeData = treeRepresentation.clone()

		T rootData = treeData.keySet().iterator().next()

		def root = new Node<T>(data: rootData)

		_populateNode(root, treeData)

		this.root = root
	}

	private void _populateNode(Node<T> parent, LinkedHashMap<T, Tuple2<T, T>> treeData) {
		Tuple2<T, T> tuple = treeData[parent.data]
		if (tuple) {
			treeData.remove(parent.data)
			if (tuple.first) {
				Node<T> leftChild = new Node<>(data: tuple.first)
				parent.left = leftChild
				_populateNode(leftChild, treeData)
			}
			if (tuple.second) {
				Node<T> rightChild = new Node<>(data: tuple.second)
				parent.right = rightChild
				_populateNode(rightChild, treeData)
			}
		}
	}

}
