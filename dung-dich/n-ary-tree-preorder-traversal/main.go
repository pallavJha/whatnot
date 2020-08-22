package main

func main() {
	
}

type Node struct {
    Val int
    Children []*Node
}

func preorder(root *Node) []int {
	var values []int
	if root != nil {
		for _, n :=  range root.Children {
			values = append(values, preorder(n)...)
		}
		return append([]int{root.Val}, values...)
	}
	return values
}
