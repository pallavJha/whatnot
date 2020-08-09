package main

import (
	"fmt"
)

func main() {
	var numberOfTestCases int
	_, err := fmt.Scanln(&numberOfTestCases)
	dieIf("while reading number of test cases", err)

	calculate(numberOfTestCases)
}

// calculate executes for each of the test cases
// it first scan the number of array elements and then scans the array itself
// once the array is scanned, the sum function is called
func calculate(n int) {
	if n == 0 {
		return
	}
	var length int
	_, err := fmt.Scan(&length)
	dieIf("while reading length", err)
	arr := make([]int, length)
	readArrElement(arr, 0)
	fmt.Println(sum(arr, 0, 0))
	calculate(n - 1)
}

// readArrElement scans the array elements from the input
// the param i is the index for which the read would be done.
// This function is called recursively until the all the elements are scanned
func readArrElement(arr []int, i int) {
	if i == len(arr) {
		return
	}
	_, err := fmt.Scan(&arr[i])
	if err != nil {
		return
	}
	readArrElement(arr, i+1)
}

// sum finds the sum of all the positive elements in the array
func sum(arr []int, index, sumTillNow int) int {
	if index == len(arr) {
		return sumTillNow
	}
	currentElem := arr[index]
	if currentElem > 0 {
		sumTillNow += (currentElem * currentElem)
	}
	return sum(arr, index+1, sumTillNow)
}

// dieIf panics if the error parameter is not nil
func dieIf(msg string, err error) {
	if err != nil {
		fmt.Println(msg, ":", err)
		panic(err)
	}
}
