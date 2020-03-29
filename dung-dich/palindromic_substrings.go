package main

import "fmt"

func main() {
	fmt.Println(countSubstrings("abc"))
	fmt.Println(countSubstrings("aaa"))
	fmt.Println(countSubstrings("aaaaa"))
}

func countSubstrings(s string) int {
	numOfPalindromes := 0
	var cache = make([][]bool, len(s))
	for i := 0; i < len(cache); i++ {
		cache[i] = make([]bool, len(s))
		cache[i][i] = true
		numOfPalindromes++
	}

	r := []rune(s)
	for i := 0; i < len(r)-1; i++ {
		if r[i] == r[i+1] {
			cache[i][i+1] = true
			numOfPalindromes++
		}
	}

	for i := 2; i < len(r); i++ {
		for j := 0; j < len(r) && j+i < len(r); j++ {
			if r[j] == r[j+i] && cache[j+1][j+i-1] {
				cache[j][j+i] = true
				numOfPalindromes++
			}
		}
	}

	return numOfPalindromes
}
