package main

func main() {
  sumEvenGrandparent(nil)
}

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}


func sumEvenGrandparent(root *TreeNode) int {
    var sum int
    if root == nil {
        return 0
    }
    sum = 0
    preOrder(root, nil, nil, &sum)
    return sum
}

func preOrder(node, parent, grandParent *TreeNode, sum *int) {
    if grandParent != nil && grandParent.Val % 2 == 0 {
        *sum += node.Val
    }
    if node.Left != nil {
        preOrder(node.Left, node, parent, sum)
    }
    if node.Right != nil {
        preOrder(node.Right, node, parent, sum)
    }
}
