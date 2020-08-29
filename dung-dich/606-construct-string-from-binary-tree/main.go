package main

import (
	"bytes"
	"strconv"
)

func main() {
	
}

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func tree2str(t *TreeNode) string {
	if t == nil {
		return ""
	}
	return preOrder(t)
}

func preOrder(t *TreeNode) string {
	var buffer bytes.Buffer
	buffer.WriteString(strconv.Itoa(t.Val))
	if t.Left == nil && t.Right == nil {
		return buffer.String()
	}
	if t.Left != nil {
		buffer.WriteString("(")
		buffer.WriteString(preOrder(t.Left))
		buffer.WriteString(")")
	} else {
		buffer.WriteString("()")
	}
	if t.Right != nil {
		buffer.WriteString("(")
		buffer.WriteString(preOrder(t.Right))
		buffer.WriteString(")")
	}
	return buffer.String()
}
