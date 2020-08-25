package main

func main() {
	
}


type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

var maxDepthInt int

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	maxDepthInt = 0
	preOrder(root, 0)
	return maxDepthInt
}

func preOrder(root *TreeNode, currentDepth int) {
	currentDepth++
	if currentDepth > maxDepthInt {
		maxDepthInt = currentDepth
	}
	if root.Left != nil {
		preOrder(root.Left, currentDepth)
	}
	if root.Right != nil {
		preOrder(root.Right, currentDepth)
	}
}