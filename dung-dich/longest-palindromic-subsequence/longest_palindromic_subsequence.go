package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(longestPalindromicSubsequence("bbbab"))
	fmt.Println(longestPalindromicSubsequence("cbbd"))
}

func longestPalindromicSubsequence(text1 string) int {
	var builder strings.Builder
	for i := len(text1) - 1; i > -1; i-- {
		err := builder.WriteByte(text1[i])
		if err != nil {
			panic(err)
		}
	}

	text2 := builder.String()

	cache := make([][]int, len(text1))
	for i := range cache {
		cache[i] = make([]int, len(text2))
		for j := range cache[i] {
			cache[i][j] = -1
		}
	}
	return longestPalindromicSubsequenceBruteForceWithCaching(text1, text2, 0, 0, cache)
}

func longestPalindromicSubsequenceBruteForceWithCaching(text1 string, text2 string, i, j int, cache [][]int) int {
	if i == len(text1) {
		return 0
	} else if j == len(text2) {
		return 0
	}
	if -1 != cache[i][j] {
		return cache[i][j]
	}

	if text1[i] == text2[j] {
		return 1 + longestPalindromicSubsequenceBruteForceWithCaching(text1, text2, i+1, j+1, cache)
	}
	out1 := longestPalindromicSubsequenceBruteForceWithCaching(text1, text2, i, j+1, cache)
	out2 := longestPalindromicSubsequenceBruteForceWithCaching(text1, text2, i+1, j, cache)
	if out1 > out2 {
		cache[i][j] = out1
		return out1
	}
	cache[i][j] = out2
	return out2
}
