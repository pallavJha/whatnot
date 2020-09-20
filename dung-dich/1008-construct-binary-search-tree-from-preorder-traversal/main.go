package main

func main() {
  bstFromPreorder(nil)
}

// Definition for a binary tree node.
type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}
 
func bstFromPreorder(preorder []int) *TreeNode {
    if len(preorder) == 0 {
        return nil
    }
    return construct(preorder, 0, len(preorder) - 1)
}

func construct(preorder []int, start, end int) *TreeNode {
    if start > len(preorder) || start < 0 || end > len(preorder)  || start > end {
        return nil
    }
    val := preorder[start]
    partition := findPartition(preorder, val, start, end)
    node := &TreeNode {
        Val: val,
    }
    if partition == -1 {
        node.Left = construct(preorder, start + 1, end)    
    } else {
        node.Left = construct(preorder, start + 1, partition - 1)    
    }
    node.Right =  construct(preorder, partition, end)
    return node
}

func findPartition(preorder []int, val, start, end int) int {
    fmt.Println(val, start, end)
    if start > len(preorder) || start < 0 || end > len(preorder)  || start > end {
        fmt.Println(-1)
        return -1
    }
    for i := start; i <= end; i++ {
        if preorder[i] > val {
            fmt.Println(i)
            return i
        }
    }
    fmt.Println(-1)
    return -1
}
