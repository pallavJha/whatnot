package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(minFallingPathSum([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}))
	fmt.Println(minFallingPathSum([][]int{{-84, -36, 2}, {87, -79, 10}, {42, 10, 63}}))
}

func minFallingPathSum(A [][]int) int {
	lenMatrix := len(A)
	sumA := make([]int, lenMatrix)
	for i := 0; i < lenMatrix; i++ {
		sumA[i] = A[0][i]
	}

	for i := 1; i < lenMatrix; i++ {
		sumTemp := make([]int, lenMatrix)
		for j := 0; j < lenMatrix; j++ {
			if j == 0 {
				sumTemp[j] = A[i][j] + sumA[j]
				if sumTemp[j] > A[i][j]+sumA[j+1] {
					sumTemp[j] = A[i][j] + sumA[j+1]
				}
			} else if j == lenMatrix-1 {
				sumTemp[j] = A[i][j] + sumA[j-1]
				if sumTemp[j] > A[i][j]+sumA[j] {
					sumTemp[j] = A[i][j] + sumA[j]
				}
			} else {
				sumTemp[j] = A[i][j] + sumA[j-1]
				if sumTemp[j] > A[i][j]+sumA[j] {
					sumTemp[j] = A[i][j] + sumA[j]
				}
				if sumTemp[j] > A[i][j]+sumA[j+1] {
					sumTemp[j] = A[i][j] + sumA[j+1]
				}
			}
		}
		fmt.Println(sumTemp)
		sumA = sumTemp
	}

	minSum := math.MaxInt32
	for i := 0; i < len(sumA); i++ {
		if sumA[i] < minSum {
			minSum = sumA[i]
		}
	}

	return minSum
}
