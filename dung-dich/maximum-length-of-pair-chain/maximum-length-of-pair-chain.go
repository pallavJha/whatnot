package main

import (
	"fmt"
	"sort"
)

func main() {
	var result int
	result = findLongestChain([][]int{
		{1, 2},
		{3, 4},
		{2, 3},
	})
	fmt.Println(result)
	result = findLongestChain([][]int{
		{1, 2},
		{3, 4},
		{5, 6},
		{7, 8},
	})
	fmt.Println(result)
	result = findLongestChain([][]int{
		{1, 2},
		{3, 4},
		{4, 5},
		{7, 8},
	})
	fmt.Println(result)
	result = findLongestChain([][]int{
		{1, 2},
		{1, 2},
		{1, 2},
	})
	fmt.Println(result)
	result = findLongestChain([][]int{
		{3, 4},
		{2, 3},
		{1, 2},
	})
	fmt.Println(result)

	result = findLongestChain([][]int{
		{7, 8},
		{3, 10},
		{1, 7},
		{-10, 6},
		{1, 9},
	})
	fmt.Println(result)

}

func findLongestChain(pairs [][]int) int {
	sort.SliceStable(pairs, func(i, j int) bool {
		return pairs[i][0] <= pairs[j][0]
	})

	fmt.Println(pairs)

	maxLength := 0
	var counts = make([]int, len(pairs))
	for i := 0; i < len(pairs); i++ {
		startFrom := counts[i]
		for j := i + 1; j < len(pairs); j++ {
			if pairs[i][1] < pairs[j][0] {
				oldCount := counts[j]
				if oldCount < startFrom+1 {
					counts[j] = startFrom + 1
				}
				if maxLength < counts[j] {
					maxLength = counts[j]
				}
			}
		}
	}

	return maxLength + 1
}
