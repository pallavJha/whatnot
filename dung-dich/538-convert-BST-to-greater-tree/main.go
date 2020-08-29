package main

func main() {

}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func convertBST(root *TreeNode) *TreeNode {
	rightOrder(root, 0)
	return root
}

func rightOrder(node *TreeNode, valueToAdd int) int {
	if node == nil {
		return 0
	}
	if node.Right != nil {
		valueToAdd = rightOrder(node.Right, valueToAdd)
	}
	node.Val += valueToAdd
	valueToAdd = node.Val
	if node.Left != nil {
		return rightOrder(node.Left, valueToAdd)
	}
	return valueToAdd
}
