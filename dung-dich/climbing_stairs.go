package main

import "fmt"

func main() {
	fmt.Println(climbStairs(0))
	fmt.Println(climbStairs(1))
	fmt.Println(climbStairs(2))
	fmt.Println(climbStairs(3))
	fmt.Println(climbStairs(4))
	fmt.Println(climbStairs(5))
}

func climbStairs(n int) int {
	stairs := make([]int, n+1)
	if len(stairs) > 1 {
		stairs[1] = 1
	}
	if len(stairs) > 2 {
		stairs[2] = 1
	}

	for i := 1; i <= n; i++ {
		if i+1 < len(stairs) {
			stairs[i+1] = stairs[i+1] + stairs[i]
		}
		if i+2 < len(stairs) {
			stairs[i+2] = stairs[i+2] + stairs[i]
		}

		if i == n {
			return stairs[i]
		}
	}

	return 0;
}
