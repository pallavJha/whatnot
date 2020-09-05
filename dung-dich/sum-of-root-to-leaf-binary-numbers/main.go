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

// preOrder gets the node to traverse and the binary string found till now
func preOrder(node *TreeNode, binaryTillNow string) {
    // while traversing the node
    // we append the current node's value to the binaryTillNow string
    // and this value will be passed to all its child 
	binaryTillNow = binaryTillNow + strconv.Itoa(node.Val)
	if node.Left != nil {
		preOrder(node.Left, binaryTillNow)
	}
	if node.Right != nil {
		preOrder(node.Right, binaryTillNow)
	}
	if node.Left == nil && node.Right == nil {
	    // if the node is a leaf node
        // we convert the binary to integer
		i, _ := strconv.ParseInt(binaryTillNow, 2, 64)
        // and add that value to the sum variable
		sum += int(i)
	}
}
