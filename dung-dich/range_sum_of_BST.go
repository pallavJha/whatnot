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
	if root == nil {
		return sum
	}
	if root.Val >= L && root.Val <= R {
		sum += root.Val
	}
	if root.Left != nil && root.Left.Val >= L {
		sum += rangeSumBST(root.Left, L, R)
	}
	if root.Right != nil && root.Right.Val <= R {
		sum += rangeSumBST(root.Right, L, R)
	}

	return sum
}
