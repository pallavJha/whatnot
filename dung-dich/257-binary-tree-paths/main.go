package main

import (
	"strconv"
	"strings"
)

func main() {
	
}

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

var paths []string
func binaryTreePaths(root *TreeNode) []string {
	paths = make([]string, 0)
	if root == nil {
		return paths
	}
	var elements []string
	preOrder(root, elements)
	return paths

}

func preOrder(node *TreeNode, elements []string) {
	if node != nil {
		elements = append(elements, strconv.Itoa(node.Val))
	}
	if node.Left != nil {
		preOrder(node.Left, elements)
	}
	if node.Right != nil {
		preOrder(node.Right, elements)
	}
	if node.Left == nil && node.Right == nil {
		paths = append(paths, strings.Join(elements[:], "->"))
	}
}
