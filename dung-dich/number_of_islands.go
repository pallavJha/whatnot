package main

import "fmt"

func main() {
	value := numIslands2([][]byte{
		{'1', '1', '1', '1', '0'},
		{'1', '1', '0', '1', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '0', '0', '0'},
	})
	fmt.Println(value)

	value = numIslands2([][]byte{
		{'1', '1', '0', '0', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '1', '0', '0'},
		{'0', '0', '0', '1', '1'},
	})
	fmt.Println(value)

	value = numIslands2([][]byte{
		{'1', '1', '1'},
		{'0', '1', '0'},
		{'1', '1', '1'},
	})
	fmt.Println(value)

}

func numIslands2(grid [][]byte) int {
	islands := 0
	visited := make([][]int, len(grid))
	for i := range visited {
		visited[i] = make([]int, len(grid[0]))
	}

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				if visited[i][j] == 0 {
					islands++
					visit(i, j, grid, visited, islands)
				}
			}
		}
	}

	return islands
}

func visit(i, j int, grid [][]byte, visited [][]int, islandNum int) {
	//fmt.Println(i, j)
	if visited[i][j] == 0 {
		visited[i][j] = islandNum
		if i-1 < len(grid) && i-1 > -1 && grid[i-1][j] == '1' {
			visit(i-1, j, grid, visited, islandNum)
		}
		if i+1 < len(grid) && i+1 > -1 && grid[i+1][j] == '1' {
			visit(i+1, j, grid, visited, islandNum)
		}
		if j-1 < len(grid[0]) && j-1 > -1 && grid[i][j-1] == '1' {
			visit(i, j-1, grid, visited, islandNum)
		}
		if j+1 < len(grid[0]) && j+1 > -1 && grid[i][j+1] == '1' {
			visit(i, j+1, grid, visited, islandNum)
		}
	}
	//fmt.Println(i, j)
	//printArray(visited)
}

func printArray(visited [][]int) {
	for _, arr := range visited {
		fmt.Println(arr)
	}
}
