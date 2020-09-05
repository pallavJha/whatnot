package main

func main() {
	
}

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

var sum int
func sumOfLeftLeaves(root *TreeNode) int {
	if root == nil {
		return 0
	}
	sum = 0
	if root.Left != nil {
		preOrder(root.Left, true)
	}
	if root.Right != nil {
		preOrder(root.Right, false)
	}
	return sum
}

func preOrder(node *TreeNode, left bool) {
	if node.Left == nil && node.Right == nil && left {
		sum += node.Val
	}
	if node.Left != nil {
		preOrder(node.Left, true)
	}
	if node.Right != nil {
		preOrder(node.Right, false)
	}
}
