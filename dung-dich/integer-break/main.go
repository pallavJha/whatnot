package main

import "fmt"

func main() {
	fmt.Println(integerBreak(10))
	// fmt.Println(integerBreak(58))
}

func integerBreak(n int) int {
	var products = make([]int, 59)
	products[1] = 1
	for i := 1; i <= n; i++ {
		for j := i; j <= n; j++ {
			sum := i + j
			if sum <= n {
				productI := products[i]
				if productI < i {
					productI = i
				}

				productJ := products[j]
				if productJ < j {
					productJ = j
				}

				oldProduct := products[sum]
				if oldProduct < productI*productJ {
					products[sum] = productI * productJ
				}
			} else {
				break
			}
		}
		fmt.Println(products)
	}

	return products[n]
}
