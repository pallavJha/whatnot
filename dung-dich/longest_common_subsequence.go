package main

import (
	"fmt"
)

// TODO: Not Solved
func main() {
	fmt.Println(longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq"))
	longestCommonSubsequenceBruteForce("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq")
}

func longestCommonSubsequence(text1 string, text2 string) int {
	var l, s []rune
	if len(text1) > len(text2) {
		l = []rune(text1)
		s = []rune(text2)
	} else {
		l = []rune(text2)
		s = []rune(text1)
	}

	var lCache = make(map[rune][]int)
	for i, r := range l {
		if _, ok := lCache[r]; !ok {
			lCache[r] = []int{i}
		} else {
			lCache[r] = append(lCache[r], i)
		}
	}

	maxLCSLength := 0
	length := 0
	prevIndex := -1
	for i := 0; i < len(s); i++ {
		for j := i; j < len(s); j++ {
			if indexes, ok := lCache[s[j]]; ok {
				for _, index := range indexes {
					if index > prevIndex {
						prevIndex = index
						length++
						break
					}
				}
			}
		}
		if maxLCSLength < length {
			maxLCSLength = length
		}
		length = 0
		prevIndex = -1
	}

	return maxLCSLength
}

func longestCommonSubsequenceBruteForce(text1 string, text2 string) int {
	var l, s []rune
	l = []rune(text1)
	s = []rune(text2)

	var startJ = 0
	for k := 0; k < len(l); k++ {
		println()
		println("----------------------")
		startJ = 0
		for i := k; i < len(l); i++ {
			for j := startJ; j < len(s); j++ {
				if l[i] == s[j] {
					print(string(l[i]))
					startJ = j + 1
					break
				}
			}
		}
	}

	return 0
}
