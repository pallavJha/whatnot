package main

func main() {
	
}

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func findTarget(root *TreeNode, k int) bool {
	theRoot := root
	return preOrder(root, theRoot, k)
}


func preOrder(node, theRoot *TreeNode, k int) bool {
	if node == nil {
		return false
	}
	if (binarySearch(theRoot, node, k - node.Val)) {
		return true
	}
	return preOrder(node.Left, theRoot, k) || preOrder(node.Right, theRoot, k)

}

func binarySearch(root, nodeToIgnore *TreeNode, k int) bool {
	if root == nil {
		return false
	}
	if root.Val == k && root != nodeToIgnore {
		return true
	} else if root.Val > k {
		return binarySearch(root.Left, nodeToIgnore, k)
	} else {
		return binarySearch(root.Right, nodeToIgnore, k)
	}
}
