package main

func main() {
    deepestLeavesSum(nil)
}


type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}
 
var maxDepth int
var sum int
func deepestLeavesSum(root *TreeNode) int {
    maxDepth = 0
    sum = 0
    if root == nil {
        return 0
    }
    preOrder(root, 0)
    fmt.Println(maxDepth)
    sumDeep(root, 0)
    return sum
}

func preOrder(node *TreeNode, depth int) {
    if depth > maxDepth {
        maxDepth = depth
    }
    if node.Left != nil {
        preOrder(node.Left, depth + 1)
    }
    if node.Right != nil {
        preOrder(node.Right, depth + 1)
    }
}

func sumDeep(node *TreeNode, depth int) {
    if depth == maxDepth {
        sum += node.Val
    }
    if node.Left != nil {
        sumDeep(node.Left, depth + 1)
    }
    if node.Right != nil {
        sumDeep(node.Right, depth + 1)
    }
}
