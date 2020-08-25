package main

import "fmt"

func main() {
	
}

 type TreeNode struct {
     Val int
     Left *TreeNode
     Right *TreeNode
 }

var leafs []int
var index int

func leafSimilar(root1 *TreeNode, root2 *TreeNode) bool {
	leafs = []int{}
	index = 0
	if !(root1 != nil && root2 != nil) {
		return false
	}
	preOrder1(root1)
	fmt.Println(leafs)
	return preOrder2(root2)
}

func addLeaf(value int) {
	leafs = append(leafs, value)
}

func checkLeaf(value int) bool {
	index++
	if index == len(leafs) + 1{
		return false
	}
	return leafs[index-1] == value
}

func preOrder1(node *TreeNode) {
	if node.Left != nil {
		preOrder1(node.Left)
	}
	if node.Right != nil {
		preOrder1(node.Right)
	}
	if node.Left == nil && node.Right == nil {
		addLeaf(node.Val)
	}
}

func preOrder2(node *TreeNode) bool {
	if node.Left != nil {
		equal := preOrder2(node.Left)
		if !equal {
			return false
		}
	}
	if node.Right != nil {
		equal := preOrder2(node.Right)
		if !equal {
			return false
		}
	}
	if node.Left == nil && node.Right == nil {
		return checkLeaf(node.Val)
	}
	return true
}
