package main

func main() {

}

// Input:
//	Tree 1                     Tree 2
//          1                         2
//         / \                       / \
//        3   2                     1   3
//       /                           \   \
//      5                             4   7
// Output:
// Merged tree:
//	     3
//	    / \
//	   4   5
//	  / \   \
//	 5   4   7
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func mergeTrees(t1 *TreeNode, t2 *TreeNode) *TreeNode {

	if t1 == nil && t2 == nil {
		return nil
	}
	if t1 == nil && t2 != nil {
		return t2
	}
	if t1 != nil && t2 == nil {
		return t1
	}
	if t1 != nil && t2 != nil {
		t1.Val += t2.Val
	}
	if t1.Left != nil && t2.Left != nil {
		mergeTrees(t1.Left, t2.Left)
	}
	if t1.Right != nil && t2.Right != nil {
		mergeTrees(t1.Right, t2.Right)
	}

	if t1.Left == nil && t2.Left != nil {
		t1.Left = t2.Left
	}
	if t1.Right == nil && t2.Right != nil {
		t1.Right = t2.Right
	}

	return t1
}
