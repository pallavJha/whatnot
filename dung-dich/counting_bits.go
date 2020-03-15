package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(countBits(2))
	fmt.Println(countBits(5))
}

func countBits(num int) []int {
	var ones []int
	ones = append(ones, 0, 1)
	for i := 1; ; i++ {
		startIndex := int(math.Pow(2, float64(i)))
		endIndex := int(math.Pow(2, float64(i+1)) - 1)
		var tempOnes = make([]int, endIndex-startIndex+1)
		for j := 0; j < len(tempOnes); j++ {
			tempOnes[j] = ones[j] + 1
		}
		ones = append(ones, tempOnes...)
		if num+1 < len(ones) {
			return ones[0 : num+1]
		}
	}
}
