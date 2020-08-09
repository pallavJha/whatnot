package main

import (
	"fmt"
)

func main() {
	fmt.Println(arrayJourney2([]int{10, 2, -10, 5, 20}, 2)) // 37
	fmt.Println(arrayJourney2([]int{10, -20, -5}, 2)) // 5
	fmt.Println(arrayJourney2([]int{100, -70, -90, -80, 100}, 3)) // 130
	fmt.Println(arrayJourney2([]int{3, -4, -3, -5, 0}, 2)) // 0
	fmt.Println(arrayJourney2([]int{3, -4, -3, -5, 0}, 1)) // -9
	fmt.Println(arrayJourney2([]int{3, -4, -3, -5, 0}, 0)) // -1 << 63
}

func arrayJourney(path []int, k int) int64 {
	var cache = make([][]int64, len(path))
	cache[0] = append(cache[0], int64(path[0]))

	for i := 0; i < len(cache); i++ {
		currentCache := cache[i]
		for _, c := range currentCache {
			for j := i + 1; j <= i+k && j < len(cache); j++ {
				cache[j] = append(cache[j], c+int64(path[j]))
			}
		}
	}

	fmt.Println(cache)

	var maxSum int64 = -1 << 63
	for _, sum := range cache[len(cache)-1] {
		if maxSum < sum {
			maxSum = sum
		}
	}

	return maxSum
}

func arrayJourney2(path []int, k int) int64 {
	var cache = make([]int64, len(path))
	for i := range cache {
		cache[i] = -1 << 63
	}
	cache[0] = int64(path[0])

	for i := 0; i < len(cache); i++ {
		currentCache := cache[i]
		for j := i + 1; j <= i+k && j < len(cache); j++ {
			if cache[j] < currentCache+int64(path[j]) {
				cache[j] = currentCache + int64(path[j])
			}
		}
	}

	return cache[len(cache) - 1]
}
