package main

func main() {
	
}

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

var maxDiameter int
func diameterOfBinaryTree(root *TreeNode) int {
	maxDiameter = 0
	postOrder(root)
	return maxDiameter
}

func postOrder(node *TreeNode) int {
	if node == nil {
		return 0
	}
	leftSize := postOrder(node.Left)
	rightSize := postOrder(node.Right)
	currentDiameter := leftSize + rightSize
	if currentDiameter > maxDiameter {
		maxDiameter = currentDiameter
	}
	if leftSize > rightSize {
		return leftSize + 1
	}
	return rightSize + 1
}
