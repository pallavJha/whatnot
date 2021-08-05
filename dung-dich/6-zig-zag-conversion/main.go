package main

import "strings"

func convert(s string, numRows int) string {
	if len(s) == 0 {
		return s
	}
	if numRows == 1 {
		return s
	}
	var indexes = make([]int, len(s))
	currentIndex := 0
	action := true
	for i := 0; i < len(s); i++ {
		indexes[i] = currentIndex
		if currentIndex == 0 {
			action = true
		}
		if currentIndex == numRows-1 {
			action = false
		}
		if action {
			currentIndex++
		} else {
			currentIndex--
		}
	}

	var b strings.Builder
	b.Grow(len(s))
	for i := 0; i < numRows; i++ {
		for j := 0; j < len(s); j++ {
			if indexes[j] == i {
				b.WriteByte(s[j])
			}
		}
	}
	return b.String()
}
