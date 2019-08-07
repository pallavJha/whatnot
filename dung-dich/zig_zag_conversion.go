package main

import (
	"fmt"
	"time"
)

// convert
// PAYPALISHIRING
// P   A   H   N
// A P L S I I G
// Y   I   R
// PAHNAPLSIIGYIR

var incr = true

func NextVal(currentValue int, numRows int) int {
	if incr {
		currentValue = currentValue + 1
		if currentValue == numRows {
			currentValue = currentValue - 2
			incr = false
		}
	} else {
		currentValue = currentValue - 1
		if currentValue == -1 {
			currentValue = currentValue + 2
			incr = true
		}
	}
	return currentValue
}

func main() {
	numRows := 4
	currentValue := -1
	for {
		currentValue = NextVal(currentValue, numRows)
		fmt.Println(currentValue)
		time.Sleep(1 * time.Second)
	}
}
