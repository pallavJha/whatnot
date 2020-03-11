package main

import "fmt"

func main() {
	fmt.Println(rob([]int{1}))
	fmt.Println(rob([]int{1, 2}))
	fmt.Println(rob([]int{1, 2, 3, 1}))
	fmt.Println(rob([]int{2, 7, 9, 3, 1}))
}

func rob(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	if len(nums) == 1 {
		return nums[0]
	}

	if len(nums) == 2 {
		if nums[0] > nums[1] {
			return nums[0]
		} else {
			return nums[1]
		}
	}

	if len(nums) == 3 {
		if nums[0]+nums[2] > nums[1] {
			return nums[0] + nums[2]
		} else {
			return nums[1]
		}
	}

	sumNums := make([]int, len(nums))

	sumNums[len(sumNums)-1] = nums[len(nums)-1]
	sumNums[len(sumNums)-2] = nums[len(nums)-2]
	sumNums[len(sumNums)-3] = nums[len(nums)-3] + nums[len(nums)-1]

	for i := len(sumNums) - 4; i > -1; i-- {
		if sumNums[i+2] > sumNums[i+3] {
			sumNums[i] = nums[i] + sumNums[i+2]
		} else {
			sumNums[i] = nums[i] + sumNums[i+3]
		}
	}

	if sumNums[0] > sumNums[1] {
		return sumNums[0]
	}
	return sumNums[1]
}
