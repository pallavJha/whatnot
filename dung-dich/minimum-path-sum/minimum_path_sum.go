package main

import "fmt"

func main() {
	// fmt.Println(minPathSum([][]int{
	// 	{1, 3, 1},
	// 	{1, 5, 1},
	// 	{4, 2, 1},
	// }))
	fmt.Println(minPathSum([][]int{
		{1, 2, 5},
		{3, 2, 1},
	}))

}

func minPathSum(grid [][]int) int {
	sumGrid := make([][]int, len(grid))
	for i := range sumGrid {
		sumGrid[i] = make([]int, len(grid[0]))
		for j := 0; j < len(grid[i]); j++ {
			sumGrid[i][j] = 1<<31 - 1
		}
	}

	sumGrid[0][0] = grid[0][0]

	for i := 0; i < len(sumGrid); i++ {
		for j := 0; j < len(sumGrid[0]); j++ {
			if j+1 < len(sumGrid[0]) && sumGrid[i][j+1] > sumGrid[i][j]+grid[i][j+1] {
				sumGrid[i][j+1] = sumGrid[i][j] + grid[i][j+1]
			}
			if i+1 < len(sumGrid) && sumGrid[i+1][j] > sumGrid[i][j]+grid[i+1][j] {
				sumGrid[i+1][j] = sumGrid[i][j] + grid[i+1][j]
			}
		}
	}


	return sumGrid[len(sumGrid)-1][len(sumGrid[0])-1]
}
