package main

import (
	"fmt"
)

func main() {
	fmt.Println(longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq"))
	fmt.Println(longestCommonSubsequence("abcde", "ade"))
}

func longestCommonSubsequence(text1 string, text2 string) int {
	cache := make([][]int, len(text1))
	for i, _ := range cache {
		cache[i] = make([]int, len(text2))
		for j, _ := range cache[i] {
			cache[i][j] = -1
		}
	}
	return longestCommonSubsequenceBruteForceWithCaching(text1, text2, 0, 0, cache)
}

func longestCommonSubsequenceDP(text1, text2 string) int {
	cache := make([][]int, len(text1)+1)
	for i, _ := range cache {
		cache[i] = make([]int, len(text2)+1)
		for j, _ := range cache[i] {
			cache[i][j] = 0
		}
	}
}

func longestCommonSubsequenceBruteForceWithCaching(text1 string, text2 string, i, j int, cache [][]int) int {
	if i == len(text1) {
		return 0
	} else if j == len(text2) {
		return 0
	}
	if -1 != cache[i][j] {
		return cache[i][j]
	}

	if text1[i] == text2[j] {
		return 1 + longestCommonSubsequenceBruteForceWithCaching(text1, text2, i+1, j+1, cache)
	}
	out1 := longestCommonSubsequenceBruteForceWithCaching(text1, text2, i, j+1, cache)
	out2 := longestCommonSubsequenceBruteForceWithCaching(text1, text2, i+1, j, cache)
	if out1 > out2 {
		cache[i][j] = out1
		return out1
	}
	cache[i][j] = out2
	return out2
}

func longestCommonSubsequenceBruteForce(text1 string, text2 string, i, j int) int {
	if i == len(text1) {
		return 0
	} else if j == len(text2) {
		return 0
	}

	if text1[i] == text2[j] {
		return 1 + longestCommonSubsequenceBruteForce(text1, text2, i+1, j+1)
	}
	out1 := longestCommonSubsequenceBruteForce(text1, text2, i, j+1)
	out2 := longestCommonSubsequenceBruteForce(text1, text2, i+1, j)
	if out1 > out2 {
		return out1
	}
	return out2
}
