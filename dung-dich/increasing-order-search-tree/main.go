package main

func main() {
	
}


type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

var dummyRoot *TreeNode

func increasingBST(root *TreeNode) *TreeNode {
	dummyRoot = &TreeNode{}
	currentValue := dummyRoot
	inOrder(root)
	return currentValue.Right
}

func inOrder(root *TreeNode) {
	if root.Left != nil {
		inOrder(root.Left)
	}
	dummyRoot.Right = &TreeNode{
		Val:  root.Val,
	}
	dummyRoot = dummyRoot.Right
	if root.Right != nil {
		inOrder(root.Right)
	}
}
