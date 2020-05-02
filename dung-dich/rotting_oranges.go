package main

import "fmt"

func main() {
	value := orangesRotting([][]int{
		{2, 1, 1},
		{1, 1, 0},
		{0, 1, 1},
	})
	fmt.Println(value)

	value = orangesRotting([][]int{
		{2, 1, 1},
		{0, 1, 1},
		{1, 0, 1},
	})
	fmt.Println(value)

	value = orangesRotting([][]int{
		{0, 2},
	})
	fmt.Println(value)
}

func orangesRotting(grid [][]int) int {
	visited := make([][]int, len(grid))
	for i := range visited {
		visited[i] = make([]int, len(grid[0]))
	}

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == 2 {
				if visited[i][j] == 0 {
					visitOranges(i, j, grid, visited, 0)
				}
			}
		}
	}

	maxVisitCount := 0
	for i := 0; i < len(visited); i++ {
		for j := 0; j < len(visited[0]); j++ {
			if grid[i][j] == 1 && visited[i][j] == 0 {
				return -1
			} else {
				if maxVisitCount < visited[i][j] {
					maxVisitCount = visited[i][j]
				}
			}
		}
	}

	return maxVisitCount
}

func visitOranges(i, j int, grid [][]int, visited [][]int, currentMinute int) {
	// fmt.Println(i, j)
	if currentMinute == 0 || visited[i][j] == 0 || visited[i][j] > currentMinute {
		visited[i][j] = currentMinute
		if i-1 < len(grid) && i-1 > -1 && grid[i-1][j] == 1 {
			visitOranges(i-1, j, grid, visited, currentMinute+1)
		}
		if i+1 < len(grid) && i+1 > -1 && grid[i+1][j] == 1 {
			visitOranges(i+1, j, grid, visited, currentMinute+1)
		}
		if j-1 < len(grid[0]) && j-1 > -1 && grid[i][j-1] == 1 {
			visitOranges(i, j-1, grid, visited, currentMinute+1)
		}
		if j+1 < len(grid[0]) && j+1 > -1 && grid[i][j+1] == 1 {
			visitOranges(i, j+1, grid, visited, currentMinute+1)
		}
	}
	// fmt.Println(i, j)
	// printArray(visited)
}
