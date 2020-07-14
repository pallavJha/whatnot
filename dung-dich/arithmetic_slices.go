package main

import "fmt"

func main() {
	fmt.Println(numberOfArithmeticSlices([]int{1, 2, 3}))
	fmt.Println(numberOfArithmeticSlices([]int{1, 2, 3, 4}))
	fmt.Println(numberOfArithmeticSlices([]int{1, 2, 3, 4, 5}))
}

func numberOfArithmeticSlices(A []int) int {
	from := 0
	totalNumOfArithmeticSlices := 0
	for {
		intoLoop := false
		numOfArithmeticSlices := 0
		start, diff, ok := findNextArithmeticSlice(A, from)
		if !ok {
			return totalNumOfArithmeticSlices
		}
		numOfArithmeticSlices++
		for j := start + 3; j < len(A); j++ {
			intoLoop = true
			if A[j]-A[j-1] == diff {
				numOfArithmeticSlices++
			} else {
				from = j - 1
				break
			}
			if j == len(A)-1 {
				from = len(A) - 2
			}
		}
		if numOfArithmeticSlices > 1 {
			numOfArithmeticSlices += (numOfArithmeticSlices - 1) * (numOfArithmeticSlices) / 2
		}
		totalNumOfArithmeticSlices += numOfArithmeticSlices
		if !intoLoop {
			return totalNumOfArithmeticSlices
		}
	}
}

func findNextArithmeticSlice(arr []int, from int) (int, int, bool) {
	for i := from; i < len(arr); i++ {
		curr := arr[i]
		next := curr
		next2 := curr
		if i+1 < len(arr) {
			next = arr[i+1]
		} else {
			return 0, 0, false
		}
		if i+2 < len(arr) {
			next2 = arr[i+2]
		} else {
			return 0, 0, false
		}

		if next-curr == next2-next {
			return i, next - curr, true
		}
	}
	return 0, 0, false
}
