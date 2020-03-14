package main

import "fmt"

func main() {
	fmt.Println(countSquares([][]int{
		{0, 1, 1, 1},
		{1, 1, 1, 1},
		{0, 1, 1, 1},
	}))
	fmt.Println(countSquares([][]int{
		{1, 0, 1},
		{1, 1, 0},
		{1, 1, 0},
	}))
	fmt.Println(countSquares([][]int{
		{0, 1, 1, 1},
		{1, 1, 0, 1},
		{1, 1, 1, 1},
		{1, 0, 1, 0},
	}))
	fmt.Println(countSquares([][]int{
		{1, 1, 0, 0, 1},
		{1, 0, 1, 1, 1},
		{1, 1, 1, 1, 1},
		{1, 0, 1, 0, 1},
		{0, 0, 1, 0, 1},
	}))
}

func countSquares(matrix [][]int) int {
	var squareSize = make([][]int, len(matrix))
	for i := 0; i < len(matrix); i++ {
		squareSize[i] = make([]int, len(matrix[i]))
	}

	type intTuple struct {
		i int
		j int
	}

	var cacheList = make([]intTuple, 0, 300)
	var cacheList2 = make([]intTuple, 0, 300)

	numSquares := 0

	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			if matrix[i][j] == 1 {
				numSquares++
				squareSize[i][j] = 1
				cacheList = append(cacheList, intTuple{i: i, j: j})
			}
		}
	}

	maxSize := len(matrix)
	if len(matrix[0]) < maxSize {
		maxSize = len(matrix[0])
	}

	for ss := 2; ss <= maxSize; ss++ {
		numOfSqForSS := 0
		for _, tuple := range cacheList {
			i := tuple.i
			j := tuple.j
			loopRun := false
			broken := false
			if squareSize[i][j] == ss-1 {
				if i+ss-1 < len(matrix) && j+ss-1 < len(matrix[0]) {
					loopRun = true
				here1:
					for is, js := i, j; is < i+ss && js < j+ss; is, js = is+1, js+1 {
						if matrix[is][j+ss-1] != 1 {
							broken = true
							break here1
						}
						if matrix[i+ss-1][js] != 1 {
							broken = true
							break here1
						}
					}
				}
			}
			if !broken && loopRun {
				numOfSqForSS++
				squareSize[i][j] = ss
				cacheList2 = append(cacheList, intTuple{i: i, j: j})
			}
		}
		if numOfSqForSS == 0 {
			break
		} else {
			numSquares += numOfSqForSS
			cacheList = cacheList2
			cacheList2 = make([]intTuple, 0, 300)
		}
	}

	return numSquares
}
