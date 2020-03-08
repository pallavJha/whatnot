package main

import "fmt"

func main() {
	fmt.Println(maxProfit([]int{7, 1, 5, 3, 6, 4}))
	fmt.Println(maxProfit([]int{7, 6, 4, 3, 1}))
	fmt.Println(maxProfit([]int{3, 3, 5, 0, 0, 3, 1, 4}))
	fmt.Println(maxProfit([]int{1, 2}))
}

func maxProfit(prices []int) int {
	if len(prices) == 0 {
		return 0
	}

	localMinimum := prices[0]
	localMinimumIndex := 0
	localMaximum := prices[0]
	localMaximumIndex := 0
	maxProfit := 0
	profit := 0
	for i := 0; i < len(prices); i++ {
		curr := prices[i]
		if curr <= localMinimum {
			localMinimum = curr
			localMinimumIndex = i

			localMaximum = curr
			localMaximumIndex = i
		}

		if localMaximum <= curr {
			localMaximum = curr
			localMaximumIndex = i
		}

		if localMinimumIndex <= localMaximumIndex {
			profit = localMaximum - localMinimum
		}

		if maxProfit < profit {
			maxProfit = profit
		}

	}
	return maxProfit
}
