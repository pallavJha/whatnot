package main

import "fmt"

func main() {
	fmt.Println(nthPersonGetsNthSeatBruteForce(24))
}

func nthPersonGetsNthSeat(n int) float64 {
	if n == 1 {
		return 1
	}
	return 0.5
}

func nthPersonGetsNthSeatBruteForce(n int) float64 {
	if n == 1 {
		return 1
	}
	totalChances := 0
	bestChances := 0
	for i := 1; i <= n; i++ {
		var seatsAllocated = make([]int, n+1)
		seatsAllocated[i] = 1
		nextPersonChance(n, 2, seatsAllocated, &totalChances, &bestChances)
	}

	return float64(bestChances) / float64(totalChances)
}

func nextPersonChance(n int, nextN int, seatsAllocated []int, totalChances, bestChances *int) {
	if nextN == n {
		*totalChances++
		if 1 != seatsAllocated[nextN] {
			*bestChances++
		}
		return
	}
	if 1 == seatsAllocated[nextN] {
		for i := 1; i <= n; i++ {
			if 1 != seatsAllocated[i] {
				seatsAllocated[i] = 1
				nextPersonChance(n, nextN+1, seatsAllocated, totalChances, bestChances)
				seatsAllocated[i] = 0
			}
		}
	} else {
		seatsAllocated[nextN] = 1
		nextPersonChance(n, nextN+1, seatsAllocated, totalChances, bestChances)
		seatsAllocated[nextN] = 0
	}
}
