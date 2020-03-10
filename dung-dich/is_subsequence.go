package main

import "fmt"

func main() {
	fmt.Println(isSubsequence("abc", "baacaacbac"))
	fmt.Println(isSubsequence("cab", "baacaacbac"))
	fmt.Println(isSubsequence("cad", "baadcaacbac"))
	fmt.Println(isSubsequence("abc", "ahbgdc"))
	fmt.Println(isSubsequence("axc", "ahbgdc"))
}

func isSubsequence(s string, t string) bool {

	var positionCache = make(map[rune][]int)

	for i, r := range t {
		if _, ok := positionCache[r]; !ok {
			positionCache[r] = []int{i}
		} else {
			positionCache[r] = append(positionCache[r], i)
		}
	}

	lastRunePos := -1
	for _, r := range s {
		if _, ok := positionCache[r]; !ok {
			return false
		} else {
			found := false
			currRunePositions, _ := positionCache[r]
			for j := 0; j < len(currRunePositions); j++ {
				if currRunePositions[j] > lastRunePos {
					lastRunePos = currRunePositions[j]
					found = true
					break
				}
			}
			if !found {
				return false
			}
		}
	}

	return true
}
