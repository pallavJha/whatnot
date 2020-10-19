package main

import (
	"fmt"
	"math"
)

func main() {

	// [9183 4389 9284 9237 16364 8356 8046 27781 9773 23708]
	// [1 1 1 1 3 1 1 5 1 5]

	// fmt.Println(largestSumOfAverages3([]int{5, 2, 1, 3, 4}, 3))
	// fmt.Println(largestSumOfAverages4([]int{9, 1, 2, 3, 9}, 3))
	// fmt.Println(largestSumOfAverages3([]int{1, 2, 3, 4, 5, 6, 7}, 4))
	// fmt.Println(largestSumOfAverages3([]int{4, 1, 7, 5, 6, 2, 3}, 4))          // 18.16667
	// fmt.Println(largestSumOfAverages3([]int{3324, 8299, 5545, 6172, 5817}, 2)) // 11717.16667
	// fmt.Println(largestSumOfAverages3([]int{9183, 4389, 9284, 9237, 6853, 1630, 7881, 8356, 8046, 2738, 5834, 7916, 8260, 3033, 9773, 6566, 3629, 9581, 961, 2971}, 10)) // 74020.46667
	fmt.Println(largestSumOfAverages4([]int{9183, 4389, 9284, 9237, 6853, 1630, 7881, 8356, 8046, 2738, 5834, 7916, 8260, 3033, 9773, 6566, 3629, 9581, 961, 2971}, 10)) // 74020.46667
	// fmt.Println(largestSumOfAverages3([]int{4663, 3020, 7789, 1627, 9668, 1356, 4207, 1133, 8765, 4649, 205, 6455, 8864, 3554, 3916, 5925, 3995, 4540, 3487, 5444, 8259, 8802, 6777, 7306, 989, 4958, 2921, 8155, 4922, 2469, 6923, 776, 9777, 1796, 708, 786, 3158, 7369, 8715, 2136, 2510, 3739, 6411, 7996, 6211, 8282, 4805, 236, 1489, 7698}, 27))
}

type arrangement struct {
	arr        []int
	count      []int
	filledTill int
}

func largestSumOfAverages1(A []int, K int) float64 {
	var arrangements []arrangement
	arrangements = append(arrangements, arrangement{
		arr:        make([]int, 0),
		count:      make([]int, 0),
		filledTill: 0,
	})
	arrangements[0].arr = append(arrangements[0].arr, A[0])
	arrangements[0].count = append(arrangements[0].count, 1)

	for i := 1; i < len(A); i++ {
		var newArrangements []arrangement
		for _, curr := range arrangements {
			if curr.filledTill < K-1 {
				newArrangement := arrangement{
					arr:   make([]int, len(curr.arr)),
					count: make([]int, len(curr.count)),
				}
				copy(newArrangement.arr, curr.arr)
				copy(newArrangement.count, curr.count)
				newArrangement.arr = append(newArrangement.arr, A[i])
				newArrangement.count = append(newArrangement.count, 1)
				newArrangement.filledTill = curr.filledTill + 1
				newArrangements = append(newArrangements, newArrangement)
			}

			curr.arr[curr.filledTill] = curr.arr[curr.filledTill] + A[i]
			curr.count[curr.filledTill]++
			if (K - (curr.filledTill + 1)) < (len(A) - i) {
				newArrangements = append(newArrangements, curr)
			}
		}
		arrangements = newArrangements
		newArrangements = nil
	}

	var maxSum float64 = 0
	for _, curr := range arrangements {
		if len(curr.arr) == K {
			var sum float64 = 0
			for i := 0; i < len(curr.arr); i++ {
				sum += float64(curr.arr[i]) / float64(curr.count[i])
			}
			if maxSum < sum {
				maxSum = sum
			}
		}
	}

	return maxSum
}

type arrangement2 struct {
	totalSum   float64
	lastIndex  [2]float64
	filledTill int
}

func largestSumOfAverages2(A []int, K int) float64 {
	var arrangements []arrangement2
	arrangements = append(arrangements, arrangement2{
		totalSum:   float64(A[0]),
		lastIndex:  [2]float64{float64(A[0]), 1},
		filledTill: 0,
	})

	for i := 1; i < len(A); i++ {
		var newArrangements []arrangement2
		for _, curr := range arrangements {
			var newArrangement arrangement2
			if curr.filledTill < K-1 {
				newArrangement = arrangement2{
					totalSum:   curr.totalSum + float64(A[i]),
					lastIndex:  [2]float64{float64(A[i]), 1},
					filledTill: curr.filledTill + 1,
				}
				newArrangements = append(newArrangements, newArrangement)
			}

			if (K - (curr.filledTill + 1)) < (len(A) - i) {
				curr.totalSum -= curr.lastIndex[0] / curr.lastIndex[1]
				curr.lastIndex[0] += float64(A[i])
				curr.lastIndex[1]++
				curr.totalSum += curr.lastIndex[0] / curr.lastIndex[1]
				newArrangements = append(newArrangements, curr)
			}

		}
		arrangements = newArrangements
		newArrangements = nil
	}

	var maxSum float64 = 0
	for _, curr := range arrangements {
		if curr.filledTill+1 == K {
			if maxSum < curr.totalSum {
				maxSum = curr.totalSum
			}
		}
	}

	return maxSum
}

func largestSumOfAverages3(A []int, K int) float64 {
	// fmt.Println(A)
	count := make([]float64, len(A))
	for i := range count {
		count[i] = 1
	}
	for len(A) != K {
		var minDiff = math.MaxFloat64
		minDiffIndex := -1
		for i := 0; i < len(A)-1; i++ {
			consecutiveSum := (float64(A[i]) / count[i]) + (float64(A[i+1]) / count[i+1])
			clubbedSum := (float64(A[i]) + float64(A[i+1])) / (count[i] + count[i+1])
			diff := consecutiveSum - clubbedSum
			fmt.Println(i, diff)
			if minDiff > diff {
				minDiff = diff
				minDiffIndex = i
			}
		}
		fmt.Println("Picked", minDiffIndex)
		A[minDiffIndex] += A[minDiffIndex+1]
		count[minDiffIndex] += count[minDiffIndex+1]
		if minDiffIndex+1 == len(A)-1 {
			A = A[:minDiffIndex+1]
			count = count[:minDiffIndex+1]
		} else {
			A = append(A[:minDiffIndex+1], A[minDiffIndex+2:]...)
			count = append(count[:minDiffIndex+1], count[minDiffIndex+2:]...)
		}
		fmt.Println(A)
		fmt.Println(count)
	}

	var sum float64 = 0
	for i, element := range A {
		sum += float64(element) / count[i]
	}

	return sum
}

func largestSumOfAverages4(A []int, K int) float64 {
	// fmt.Println(A)
	count := make([]float64, len(A))
	for i := range count {
		count[i] = 1
	}
	for len(A) != K {
		var totalSum float64 = 0
		for i, element := range A {
			totalSum += float64(element) / count[i]
		}
		fmt.Println(totalSum)

		var maxSum float64 = 0
		minDiffIndex := -1

		for i := 0; i < len(A)-1; i++ {
			consecutiveSum := (float64(A[i]) / count[i]) + (float64(A[i+1]) / count[i+1])
			clubbedSum := (float64(A[i]) + float64(A[i+1])) / (count[i] + count[i+1])
			tempSum := totalSum - consecutiveSum + clubbedSum
			fmt.Println(i, tempSum, consecutiveSum, clubbedSum)
			if tempSum > maxSum {
				maxSum = tempSum
				minDiffIndex = i
			}
		}
		fmt.Println("Picked", minDiffIndex)
		A[minDiffIndex] += A[minDiffIndex+1]
		count[minDiffIndex] += count[minDiffIndex+1]
		if minDiffIndex+1 == len(A)-1 {
			A = A[:minDiffIndex+1]
			count = count[:minDiffIndex+1]
		} else {
			A = append(A[:minDiffIndex+1], A[minDiffIndex+2:]...)
			count = append(count[:minDiffIndex+1], count[minDiffIndex+2:]...)
		}
		fmt.Println(A)
		fmt.Println(count)
	}

	var sum float64 = 0
	for i, element := range A {
		sum += float64(element) / count[i]
	}

	return sum
}
