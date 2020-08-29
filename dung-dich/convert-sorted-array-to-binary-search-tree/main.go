package main

func main() {

}

// Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sortedArrayToBST(nums []int) *TreeNode {
	return findRootAndDivide(nums, 0, len(nums) - 1)
}

func findRootAndDivide(nums []int, startIndex, endIndex int) *TreeNode {
	if startIndex > endIndex {
		return nil
	}
	midIndex := (startIndex + endIndex) / 2
	return &TreeNode{
		Val:   nums[midIndex],
		Left:  findRootAndDivide(nums, startIndex, midIndex-1),
		Right: findRootAndDivide(nums, midIndex+1, endIndex),
	}
}
