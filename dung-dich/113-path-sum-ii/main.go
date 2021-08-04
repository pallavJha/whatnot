package main

import (
	"fmt"
)

const NullArr = 999999

func main() {
	// [[-260,-903,-858,-35,817,222,307,-301,-947,-76,445,579,814,-47]]
	var inputTree = []int{-260, -202, -903, -980, -570, -858, 218, 764, -300, 205, 999999, -35, 999999, 999999, -204, 950, -769, 258, -652, 614, -584, 76, 817, -192, 999999, 999999, -114, 880, 999999, -200, 71, 671, 344, 801, 193, -18, 876, -920, -730, 222, 679, 999999, -680, 999999, 999999, 999999, -859, 744, -261, 692, 999999, -341, -163, 999999, 999999, 482, -979, 205, 999999, 146, 165, 801, 100, -656, 714, -629, 995, 474, 307, -581, -150, -941, 999999, 999999, 999999, -937, -69, -23, 82, 999999, -139, -591, 999999, -453, -861, -370, 999999, 999999, 999999, 216, 233, 999999, 430, 999999, 5, -110, 999999, 999999, -660, 624, -510, -588, 999999, 999999, 381, 999999, 368, 559, 999999, 521, -301, 999999, 522, 379, 999999, 999999, 999999, 999999, 456, 519, 999999, 999999, 482, 349, 999999, 999999, 19, 999999, 999999, 288, -811, 999999, -372, 999999, 999999, -536, 999999, -404, -457, -740, 860, 999999, 999999, -636, 999999, 999999, 342, -874, -462, -504, 781, 855, -392, 999999, 999999, 999999, 406, 999999, -758, 541, 999999, -947, 999999, 999999, 999999, 999999, 999999, -964, 999999, 600, -45, 999999, 999999, 999999, 999999, 999999, 999999, 999999, 999999, 999999, -194, 999999, 999999, 999999, -802, 999999, 999999, 999999, -3, 999999, -792, 672, 643, 999999, 14, 999999, 999999, 489, 457, 999999, 999999, 999999, 999999, 412, 999999, 558, 999999, 999999, 999999, 999999, -846, 158, -146, 999999, 999999, -76, -650, 999999, -782, 999999, -127, 999999, -678, 999999, 999999, 999999, 999999, 999999, 999999, -464, -426, 999999, -366, 999999, 999999, 999999, 999999, 999999, 81, -607, 716, 999999, 999999, -213, 999999, 379, 999999, 999999, 999999, 999999, 644, 445, 999999, 999999, -419, -845, -720, 999999, 999999, -915, 999999, 999999, 999999, 999999, 999999, 999999, -686, 594, -243, 999999, 496, 999999, 907, 999999, 999999, 999999, 999999, 999999, 999999, 579, 873, 702, 999999, 999999, 999999, -834, 999999, 999999, 999999, 999999, 999999, -300, -214, -466, 999999, 999999, 972, 999999, 999999, 999999, 814, 999999, -940, 999999, 763, 999999, 999999, 999999, 999999, -449, -844, 999999, 999999, 999999, 999999, -47}
	// var inputTree = []int{5, 4, 8, 11, NullArr, 13, 4, 7, 2, NullArr, NullArr, 5, 1}

	var targetSum = -243
	// var targetSum = 22
	root := prepareNode(inputTree, 1, 2)
	result := pathSum(root, targetSum)
	fmt.Println(result)
}

func prepareNode(inputTree []int, leftIndex, rightIndex int) *TreeNode {
	var nodes = make([]*TreeNode, len(inputTree))
	for i := 0; i < len(nodes); i++ {
		if inputTree[i] != NullArr {
			nodes[i] = &TreeNode{
				Val: inputTree[i],
			}
		} else {
			nodes[i] = nil
		}
	}
	for i := 0; i < len(nodes); i++ {
		if nodes[i] != nil {
			nodes[i].Left = nodes[leftIndex]
			if rightIndex < len(nodes) {
				nodes[i].Right = nodes[rightIndex]
			}
			leftIndex += 2
			rightIndex += 2
			if leftIndex >= len(nodes) {
				break
			}
		}
	}
	return nodes[0]
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var paths [][]int

func pathSum(root *TreeNode, targetSum int) [][]int {
	paths = nil
	var parents []int
	preOrder(root, parents, 0, targetSum)
	return paths
}

func preOrder(node *TreeNode, parents []int, currentSum int, targetSum int) {
	if node == nil {
		return
	}
	if node.Val == -47 {
		fmt.Println("found")
	}
	if isLeaf(node) {
		if node.Val+currentSum == targetSum {
			var tmp = make([]int, len(parents)+1)
			copy(tmp, append(parents, node.Val))
			paths = append(paths, tmp)
		}
	} else {
		currentSum = currentSum + node.Val
		preOrder(node.Left, append(parents, node.Val), currentSum, targetSum)
		preOrder(node.Right, append(parents, node.Val), currentSum, targetSum)
	}

}

func isLeaf(node *TreeNode) bool {
	return node != nil && node.Left == nil && node.Right == nil
}
