package main

import (
	"fmt"
	"math"
)

func main() {
	// f, err := os.Create("./cpu_profile_2")
	// if err != nil {
	// 	log.Fatal(err)
	// }
	// err = pprof.StartCPUProfile(f)
	// if err != nil {
	// 	log.Fatal(err)
	// }
	// defer pprof.StopCPUProfile()
	// 6
	fmt.Println(minScoreTriangulation([]int{1, 2, 3}))
	// 144
	fmt.Println(minScoreTriangulation([]int{3, 7, 4, 5}))
	// 38
	fmt.Println(minScoreTriangulation([]int{1, 2, 3, 4, 5}))
	// 68
	fmt.Println(minScoreTriangulation([]int{1, 2, 3, 4, 5, 6}))
	// 110
	fmt.Println(minScoreTriangulation([]int{1, 2, 3, 4, 5, 6, 7}))
	// 13
	fmt.Println(minScoreTriangulation([]int{1, 3, 1, 4, 1, 5}))
	// 98
	fmt.Println(minScoreTriangulation([]int{3, 5, 2, 5, 2, 6}))
	// 140295
	fmt.Println(minScoreTriangulation([]int{35, 73, 90, 27, 71, 80, 21, 33, 33, 13, 48, 12, 68, 70, 80, 36, 66, 3, 70, 58}))
	// 153657
	fmt.Println(minScoreTriangulation([]int{38, 76, 69, 32, 24, 35, 82, 30, 86, 77, 92, 3, 35, 20, 84, 67, 23, 58, 94, 10}))
	// 103598
	fmt.Println(minScoreTriangulation([]int{5, 80, 62, 45, 96, 100, 17, 72, 67, 64, 20, 66, 41, 68, 34, 67, 35, 24, 76, 2}))
}

var cache [][]int

func minScoreTriangulation(A []int) int {
	cache = make([][]int, len(A))
	for i := range cache {
		cache[i] = make([]int, len(A))
	}
	minScoreTriangulationLLC(A, 0, len(A)-1)
	return cache[0][len(A)-1]
}

func minScoreTriangulationLLC(A []int, start, end int) int {
	if math.Abs(float64(start-end)) == 1 {
		return 0
	}
	if cache[start][end] > 0 {
		return cache[start][end]
	}
	sum := math.MaxInt32
	for i := start + 1; i < end; i++ {
		tempSum := minScoreTriangulationLLC(A, start, i) + minScoreTriangulationLLC(A, i, end) + (A[start] * A[end] * A[i])
		if tempSum < sum {
			sum = tempSum
		}
	}
	cache[start][end] = sum
	return sum
}
