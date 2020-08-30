package main

import "fmt"

func main() {
	
}

type TreeNode struct {
     Val int
     Left *TreeNode
     Right *TreeNode
 }

var leaves []int
var index int

func leafSimilar(root1 *TreeNode, root2 *TreeNode) bool {
	leaves = []int{}
	index = 0
    // false is returned if both the tress are not non nil
	if !(root1 != nil && root2 != nil) {
		return false
	}
    // preOrder fills up the leaves list after traversing 
    // the first tree
	preOrder1(root1)
	// fmt.Println(leafs)
	return preOrder2(root2)
}

// addLeaf appends the passed value into the leaves list
func addLeaf(value int) {
	leaves = append(leaves, value)
}

// checkLeaf checks whether the element at the next index 
// matches with the passed value
func checkLeaf(value int) bool {
	index++
	if index == len(leafs) + 1{
		return false
	}
	return leafs[index-1] == value
}

// preOrder1 traverses over the first tree
// and fills up the leaves list
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

// preOrder2 traverses over the second tree
// and checks if the leaf node values are present
// in the leaves list
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
