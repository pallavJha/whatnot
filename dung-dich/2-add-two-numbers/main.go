package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil && l2 == nil {
		return nil
	}
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}

	var sumListHead, tmp *ListNode
	var l1Digit, l2Digit, carry int

	for l1 != nil || l2 != nil || carry > 0 {
		if l1 != nil {
			l1Digit = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			l2Digit = l2.Val
			l2 = l2.Next
		}
		sum := l1Digit + l2Digit + carry
		if sum >= 10 {
			carry = sum / 10
			sum = sum % 10
		} else {
			carry = 0
		}
		l1Digit = 0
		l2Digit = 0
		if sumListHead == nil {
			sumListHead = &ListNode{
				Val: sum,
			}
			tmp = sumListHead
		} else {
			tmp.Next = &ListNode{
				Val: sum,
			}
			tmp = tmp.Next
		}

	}

	return sumListHead
}
