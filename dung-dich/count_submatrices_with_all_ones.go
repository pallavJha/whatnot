package main

import "fmt"

func main() {
	output := 0
	output = numSubmat([][]int{
		{1, 0, 1},
		{1, 1, 0},
		{1, 1, 0},
	})
	fmt.Println(output)
	output = numSubmat([][]int{
		{0, 1, 1, 0},
		{0, 1, 1, 1},
		{1, 1, 1, 0},
	})
	fmt.Println(output)
	output = numSubmat([][]int{
		{1, 1, 1, 1, 1, 1},
	})
	fmt.Println(output)
}

func numSubmat(mat [][]int) int {
	numberOfSubMats := 0
	var depthWidthCache = make([][][2]int, len(mat))
	for i, matRow := range mat {
		depthWidthCache[i] = make([][2]int, len(matRow))
	}

	for i := 0; i < len(mat); i++ {
		totalWidth := 0
		for j := len(mat[i]) - 1; j > -1; j-- {
			if mat[i][j] == 1 {
				totalWidth++
				depthWidthCache[i][j][1] = totalWidth
			} else {
				totalWidth = 0
			}
		}
	}

	for j := 0; j < len(mat[0]); j++ {
		totalHeight := 0
		for i := len(mat) - 1; i > -1; i-- {
			if mat[i][j] == 1 {
				totalHeight++
				depthWidthCache[i][j][0] = totalHeight
			} else {
				totalHeight = 0
			}
		}
	}

	for _, arr := range depthWidthCache {
		fmt.Println("%v", arr)
	}

	for i := 0; i < len(mat); i++ {
		for j := 0; j < len(mat[0]); j++ {
			currentDepth := depthWidthCache[i][j][0]
			currentWidth := depthWidthCache[i][j][1]
			if currentDepth == 0 && currentWidth == 0 {
				// if the current element is 0 then don't proceed
				// and don't increase the count as well
				continue
			} else if currentDepth == 1 || currentWidth == 1 {
				if currentDepth == 1 && currentWidth == 1 {
					// this section means that we've found a 1
					// but it doesn't have any neighbour that is also 1
					numberOfSubMats++
				} else {
					// this section checks for the 1D matrix
					if currentDepth == 1 {
						// add the width
						numberOfSubMats += currentWidth
					} else {
						// add the height
						numberOfSubMats += currentDepth
					}
				}
			} else {
				numberOfSubMats += currentWidth
				for k := i + 1; k <= i+currentDepth-1; k++ {
					maxWidthFromNextRowElem := depthWidthCache[k][j][1]
					if maxWidthFromNextRowElem >= currentWidth {
						numberOfSubMats += currentWidth
					} else {
						numberOfSubMats += maxWidthFromNextRowElem
						currentWidth = maxWidthFromNextRowElem
					}
				}
			}
		}
	}

	return numberOfSubMats
}
