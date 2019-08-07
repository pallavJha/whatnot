package main

import (
	"github.com/davecgh/go-spew/spew"
)

func main() {
	solution := twoSum([]int{3, 3, 2, 4}, 6)
	spew.Dump(solution)
}

func twoSum(nums []int, target int) []int {
	elementToIndex := make(map[int]int)
	duplicateElementToIndex := make(map[int]int)
	for i, e := range nums {
		if _, ok := elementToIndex[e]; !ok {
			elementToIndex[e] = i
		} else {
			duplicateElementToIndex[e] = i
		}
	}
	spew.Dump(elementToIndex)
	spew.Dump(duplicateElementToIndex)
	for index, elem := range nums {
		otherElement := target - elem
		if elem == otherElement {
			indexOfOtherElement, ok := duplicateElementToIndex[otherElement]
			if ok {
				return []int{index, indexOfOtherElement}
			} else {
				continue
			}
		}
		indexOfOtherElement, ok := elementToIndex[otherElement]
		if ok {
			if indexOfOtherElement > index {
				return []int{index, indexOfOtherElement}
			}
			return []int{indexOfOtherElement, index}
		}
	}
	return []int{}
}
