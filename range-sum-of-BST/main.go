package main

func main() {
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func rangeSumBST(root *TreeNode, L int, R int) int {
	sum := 0
	inOrder(root, L, R, &sum)
	return sum
}

func inOrder(node *TreeNode, L int, R int, sum *int) {
	sendLeft := false
	sendRight := false
	if node.Val >= L && node.Val <= R {
		*sum = *sum + node.Val
	}
	if node.Left != nil && node.Val > L {
		sendLeft = true
	}
	if node.Right != nil && node.Val < R {
		sendRight = true
	}

	if sendLeft {
		inOrder(node.Left, L, R, sum)
	}
	if sendRight {
		inOrder(node.Right, L, R, sum)
	}

}
