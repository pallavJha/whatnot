package main

import "fmt"

func main() {
	root := &TreeNode{
		Val: 1,
		Right: &TreeNode{
			Val: 2,
		},
	}
	fmt.Println(findMode(root))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var maxMode int
var maxModeMap map[int][]int
func findMode(root *TreeNode) []int {
	if root == nil {
		return nil
	}
	maxModeMap = make(map[int][]int)
	maxMode = 0
	preOrder(root, -1, 0)
	fmt.Println(maxModeMap)
	return maxModeMap[maxMode]
}

func preOrder(node *TreeNode, lastValue, lastMode int) (int, int) {
	if node.Left != nil {
		lastValue, lastMode = preOrder(node.Left, lastValue, lastMode)
	}
	if node.Val == lastValue {
		lastMode++
	} else {
		lastMode = 1
	}
	if lastMode >= maxMode {
		if lastMode > maxMode {
			delete(maxModeMap, maxMode)
		}
		valueToSet := lastValue
		if lastMode == 1 {
			valueToSet = node.Val
		}
		if _, ok := maxModeMap[lastMode]; ok {
			maxModeMap[lastMode] = append(maxModeMap[lastMode], valueToSet)
		} else {
			maxModeMap[lastMode] = []int{valueToSet}
		}
		maxMode = lastMode
	}
	if node.Right != nil {
		return preOrder(node.Right, node.Val, lastMode)
	}
	return node.Val, lastMode

}
