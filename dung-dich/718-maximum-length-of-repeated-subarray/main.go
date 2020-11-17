package main

import "fmt"

func main() {
	fmt.Println(findLength([]int{1, 2, 3, 2, 1, 7}, []int{3, 2, 1, 7, 4, 7}))
	fmt.Println(findLength([]int{1, 1, 3, 4}, []int{1, 1, 3, 5}))
}

func findLength(A []int, B []int) int {
	var cache = make([][]int, len(A))
	for i := 0; i < len(A); i++ {
		cache[i] = make([]int, len(B))
	}

	for i := 0; i < len(A); i++ {
		for j := 0; j < len(B); j++ {
			if A[i] == B[j] {
				cache[i][j] = 1
			}
		}
	}

	max := 0
	for i := 0; i < len(A); i++ {
		for j := 0; j < len(B); j++ {
			if cache[i][j] == 1 {
				if i != 0 && j != 0 && cache[i-1][j-1] > 0 {
					cache[i][j] = 1 + cache[i-1][j-1]
				}
				if max < cache[i][j] {
					max = cache[i][j]
				}
			}
		}
	}
	return max
}
