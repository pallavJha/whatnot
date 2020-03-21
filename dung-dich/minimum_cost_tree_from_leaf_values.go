package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(mctFromLeafValues([]int{6, 2, 4}))
	fmt.Println(mctFromLeafValues([]int{15, 13, 5, 3, 15}))
}

func mctFromLeafValues(arr []int) int {
	sum := 0
	for ; len(arr) > 1; {
		minProd := math.MaxInt32
		start := 0
		valueToAdd := 0
		for i := 0; i < len(arr)-1; i++ {
			prod := arr[i] * arr[i+1]
			if prod < minProd {
				minProd = prod
				start = i
			}
		}
		valueToAdd = arr[start]
		if arr[start+1] > arr[start] {
			valueToAdd = arr[start+1]
		}
		sum += arr[start] * arr[start+1]
		newArr := append(arr[0:start], valueToAdd)
		if start+2 < len(arr) {
			newArr = append(newArr, arr[start+2:]...)
		}
		arr = newArr
	}
	return sum
}
