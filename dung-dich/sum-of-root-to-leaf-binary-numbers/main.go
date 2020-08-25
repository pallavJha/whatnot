package main

import "strconv"

func main() {
	
}

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

var sum int

func sumRootToLeaf(root *TreeNode) int {
	sum = 0
	preOrder(root, "0")
	return sum
}

func preOrder(node *TreeNode, binaryTillNow string) {
	binaryTillNow = binaryTillNow + strconv.Itoa(node.Val)
	if node.Left != nil {
		preOrder(node.Left, binaryTillNow)
	}
	if node.Right != nil {
		preOrder(node.Right, binaryTillNow)
	}
	if node.Left == nil && node.Right == nil {
		i, _ := strconv.ParseInt(binaryTillNow, 2, 64)
		sum += int(i)
	}
}
