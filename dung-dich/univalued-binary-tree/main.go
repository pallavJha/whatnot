package main

func main() {
	
}


type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

var rootValue int

func isUnivalTree(root *TreeNode) bool {
	if root == nil {
		return false
	}
	rootValue = root.Val
	return preOrder(root)
}

func preOrder(root *TreeNode) bool {
	currentStatus := true
	if root.Val != rootValue {
		return false
	}
	leftStatus := true
	if root.Left != nil {
		leftStatus = preOrder(root.Left)
	}
	rightStatus := true
	if root.Right != nil {
		rightStatus = preOrder(root.Right)
	}
	return currentStatus && leftStatus && rightStatus
}
