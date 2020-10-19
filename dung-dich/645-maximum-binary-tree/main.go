package main

func main() {
}


type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func constructMaximumBinaryTree(nums []int) *TreeNode {
    if len(nums) == 0 {
        return nil
    }
    return createNode(nums, 0, len(nums) - 1)
}

func createNode(nums []int, start, end int) *TreeNode {
    if start > end {
        return nil
    }
    max, index := findMax(nums, start, end)
    if max == -1 || index == -1 {
        return nil
    }
    return &TreeNode {
        Val: max,
        Left: createNode(nums, start, index - 1),
        Right: createNode(nums, index + 1, end),
    }
}

func findMax(nums []int, start, end int) (int, int) {
    if start < 0 || end > len(nums) - 1 || start > end {
        return -1, -1
    }
    max := -1
    index := -1
    for i := start; i <= end; i++ {
        if nums[i] > max {
            max = nums[i]
            index = i
        } 
    }
    return max, index
}
