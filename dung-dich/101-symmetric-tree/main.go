package main

func main() {

}

type TreeNode struct {
  Val int
  Left *TreeNode
  Right *TreeNode
}

func isSymmetric(root *TreeNode) bool {
    return preOrder(root, root)
}

func preOrder(node1 *TreeNode, node2 *TreeNode) bool {
    if node1 == nil && node2 != nil {
        return false
    }
    if node1 != nil && node2 == nil {
        return false
    }
    if node1 == nil && node2 ==nil {
        return true
    }
    if node1.Val != node2.Val {
        return false
    }
    isEqual := preOrder(node1.Left, node2.Right)
    if !isEqual {
        return false
    }
    return preOrder(node1.Right, node2.Left)
}
