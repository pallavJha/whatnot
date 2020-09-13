package main

import "math"

func main() {
	
}

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

var minimumDifference int
func getMinimumDifference(root *TreeNode) int {
	minimumDifference = math.MaxInt32
	if root == nil {
		return 0
	}
	inOrder(root, math.MaxInt32)
	return minimumDifference
}

func inOrder(node *TreeNode, lastValue int) int {
	if node.Left != nil {
		lastValue = inOrder(node.Left, lastValue)
	}
	difference := lastValue - node.Val
	if difference < 0 {
		difference = -difference
	}
	if difference < minimumDifference {
		minimumDifference = difference
	}
	lastValue = node.Val
	if node.Right != nil {
		lastValue = inOrder(node.Right, lastValue)
	}
	return lastValue
}
