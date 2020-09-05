package main

func main() {
	
}

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func isSameTree(p *TreeNode, q *TreeNode) bool {
	if p == nil && q != nil {
		return false
	}
	if p != nil && q == nil {
		return false
	}
	if p == nil && q == nil {
		return true
	}
	if p.Val != q.Val {
		return false
	}
	isEqual := isSameTree(p.Left, q.Left)
	if !isEqual {
		return false
	}
	return isSameTree(p.Right, q.Right)
}
