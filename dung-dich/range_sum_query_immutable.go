package main

import "fmt"

type NumArray struct {
	sumArray []int
}

func Constructor(nums []int) NumArray {
	numArray := NumArray{
		sumArray: make([]int, len(nums)),
	}

	sum := 0
	for i, num := range nums {
		sum += num
		numArray.sumArray[i] = sum
	}

	return numArray
}

func (this *NumArray) SumRange(i int, j int) int {
	if i > 0 {
		return this.sumArray[j] - this.sumArray[i-1]
	} else {
		return this.sumArray[j]
	}
}

func main() {
	numArr := Constructor([]int{-2, 0, 3, -5, 2, -1})
	fmt.Println(numArr.SumRange(0, 2))
	fmt.Println(numArr.SumRange(2, 5))
	fmt.Println(numArr.SumRange(0, 5))
}
