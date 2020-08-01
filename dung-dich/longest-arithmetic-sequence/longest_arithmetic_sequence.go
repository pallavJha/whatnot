package main

import "fmt"

func main() {
	fmt.Println(longestArithSeqLength([]int{3, 6, 9, 12}))
	fmt.Println(longestArithSeqLength([]int{9, 4, 7, 2, 10}))
	fmt.Println(longestArithSeqLength([]int{9, 4, 7, 2, 10, 13}))
	fmt.Println(longestArithSeqLength([]int{20, 1, 15, 3, 10, 5, 8}))
}

func longestArithSeqLength(A []int) int {
	var cache = make([]map[int]int, len(A))

	for i := range cache {
		cache[i] = make(map[int]int)
	}

	maxLength := 0

	for i := 0; i < len(A); i++ {
		for j := i + 1; j < len(A); j++ {
			diff := A[j] - A[i]
			cacheMap := cache[i]
			increment := false
			oldCount, ok := cacheMap[diff]
			if ok {
				increment = true
			}
			cacheMap = cache[j]
			_, ok = cacheMap[diff]
			if !ok {
				cacheMap[diff] = 1
			}
			if increment {
				cacheMap[diff] = oldCount + 1
				if maxLength < oldCount+1 {
					maxLength = oldCount + 1
				}
			}
		}
	}

	if maxLength == 0 {
		return 2
	}

	// fmt.Println(cache)

	return maxLength + 1
}
