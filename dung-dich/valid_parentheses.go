package main

import (
	"fmt"
)

type stack []int32

func (s *stack) Push(v int32) {
	*s = append(*s, v)
}

func (s *stack) Pop() (int32, error) {
	l := len(*s)
	if l == 0 {
		return -1, fmt.Errorf("underflow")
	}
	poppedElem := (*s)[l-1]
	*s = (*s)[:l-1]
	return poppedElem, nil
}

func isValid(s string) bool {
	openingBrackets := map[rune]bool{
		'{': true,
		'[': true,
		'(': true,
	}
	closingBrackets := map[rune]rune{
		'}': '{',
		']': '[',
		')': '(',
	}
	myStack := new(stack)
	for _, c := range s {
		if openingBrackets[c] {
			myStack.Push(c)
		} else if c, ok := closingBrackets[c]; ok {
			r, err := myStack.Pop()
			if err != nil {
				return false
			}
			if r != c {
				return false
			}
		} else {
			return false
		}
	}
	return len(*myStack) == 0
}

func main() {
	inputs := []string{
		"()",
		"()[]{}",
		"(]",
		"([)]",
		"{[]}",
	}
	for _, v := range inputs {
		fmt.Println(v, isValid(v))
	}
}
