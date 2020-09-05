package main

func main() {
	
}

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func isCousins(root *TreeNode, x int, y int) bool {
	parent1, height1 := preOrder(root, nil, x, 0)
	parent2, height2 := preOrder(root, nil, y, 0)
	if height1 == height2 && height1 != -1{
		return parent1 != parent2
	}
	return false
}

func preOrder(node, parent *TreeNode, val, height int) (*TreeNode, int) {
	if node.Val == val {
		return parent, height
	}
	if node.Left != nil {
		foundParent, foundHeight := preOrder(node.Left, node, val, height + 1)
		if foundParent != nil && foundHeight != -1 {
			return foundParent, foundHeight
		}
	}
	if node.Right != nil {
		foundParent, foundHeight := preOrder(node.Right, node, val, height + 1)
		if foundParent != nil && foundHeight != -1 {
			return foundParent, foundHeight
		}
	}
	return nil, -1
}
