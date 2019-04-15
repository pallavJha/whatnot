package main

import (
	"github.com/davecgh/go-spew/spew"
)

type ListNode struct {
    Val int
    Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	output := &ListNode{}
	response := output
	carry := 0
	for l1 != nil || l2 != nil {
		output.Val = carry
		if l1 != nil {
			output.Val = output.Val + l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			output.Val = output.Val + l2.Val
			l2 = l2.Next
		}
		carry = output.Val / 10
		output.Val = output.Val % 10
		if l1 != nil || l2 != nil {
			output.Next = &ListNode{}
			output = output.Next
		}
	}
	if carry > 0 {
		output.Next = &ListNode{}
		output.Next.Val = carry
	}
	return response
}


func main() {
	arr1 := []int{6, 2, 4}
	arr2 := []int{4, 5, 6}

	l1 := &ListNode{}
	actualL1 := l1
	for i, element := range arr1 {
		l1.Val = element
		if i != len(arr1) - 1 {
			l1.Next = &ListNode{}
			l1 = l1.Next
		}
	}

	l2 := &ListNode{}
	actualL2 := l2
	for i, element := range arr2 {
		l2.Val = element
		if i != len(arr2) - 1 {
			l2.Next = &ListNode{}
			l2 = l2.Next
		}
	}
	spew.Dump(actualL1)
	spew.Dump(actualL2)
	output := addTwoNumbers(actualL1, actualL2)
	spew.Dump(output)
}
