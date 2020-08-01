package main

func main() {
	longestZigZag(nil)
}

// Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func longestZigZag(root *TreeNode) int {
	if root == nil {
		return 0
	}
	if root.Left == nil && root.Right == nil {
		return 0
	}
	leftLength := 0
	rightLength := 0
	if root.Left != nil {
		traverse(root.Left, 1, true, &leftLength)
	}
	if root.Right != nil {
		traverse(root.Right, 1, false, &rightLength)
	}
	if leftLength > rightLength {
		return leftLength
	}
	return rightLength
}

func traverse(node *TreeNode, length int, left bool, maxLength *int) {
	if length > *maxLength {
		*maxLength = length
	}
	if node.Left != nil {
		if left {
			traverse(node.Left, 1, true, maxLength)
		} else {
			traverse(node.Left, length+1, true, maxLength)
		}
	}
	if node.Right != nil {
		if left {
			traverse(node.Right, length+1, false, maxLength)
		} else {
			traverse(node.Right, 1, false, maxLength)
		}
	}
}
