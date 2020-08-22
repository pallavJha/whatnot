package main

func main() {
	
}

type Node struct {
    Val int
    Children []*Node
}

func postorder(root *Node) []int {
	var values []int
	if root != nil {
		for _, n :=  range root.Children {
			values = append(values, postorder(n)...)
		}
		return append(values, root.Val)
	}
	return values
}
