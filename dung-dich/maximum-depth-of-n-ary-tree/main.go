var maxDepthValue  int

func maxDepth(root *Node) int {
    maxDepthValue = 0
    if root == nil {
        return 0
    }
    preOrder(root, 0)
    return maxDepthValue
}

func preOrder(root *Node, currentDepth int) int {
    currentDepth++
    if currentDepth > maxDepthValue {
        maxDepthValue = currentDepth
    }
    if root.Children != nil {
        for _, child := range root.Children {
            preOrder(child, currentDepth)
        } 
    }
    return 0
}
