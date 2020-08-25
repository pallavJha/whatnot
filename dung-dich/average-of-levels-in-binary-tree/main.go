package main

func main() {
	
}

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

var levelAvgNodeCache map[int][2]float64

func averageOfLevels(root *TreeNode) []float64 {
	levelAvgNodeCache = make(map[int][2]float64)
	if root == nil {
		return []float64{}
	}
	preOrder(root, 0)
	var avgValues = make([]float64, len(levelAvgNodeCache))
	for k, v := range levelAvgNodeCache {
		avgValues[k] = v[0]
	}
	return avgValues

}

func preOrder(node *TreeNode, height int) {
	values, ok := levelAvgNodeCache[height]
	if !ok {
		levelAvgNodeCache[height] = [2]float64{float64(node.Val), 1}
	} else {
		newAvg := (float64(node.Val) + (values[0] * values[1])) / (values[1] + 1)
		levelAvgNodeCache[height] = [2]float64{newAvg, values[1] + 1}
	}
	if node.Left != nil {
		preOrder(node.Left, height + 1)
	}
	if node.Right != nil {
		preOrder(node.Right, height + 1)
	}
}
