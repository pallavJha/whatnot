package main

import "fmt"

func main() {
	fmt.Println(matrixBlockSum([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1))
	fmt.Println(matrixBlockSum([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2))
}

func matrixBlockSum(mat [][]int, K int) [][]int {
	rows := len(mat)
	cols := len(mat[0])
	var answers = make([][]int, rows)
	for i := 0; i < rows; i++ {
		answers[i] = make([]int, cols)
	}

	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			sum := 0
			for tempI := i - K; tempI <= i+K; tempI++ {
				if tempI < 0 || tempI >= rows {
					continue
				}
				for tempJ := j - K; tempJ <= j+K; tempJ++ {
					if tempJ < 0 || tempJ >= cols {
						continue
					}
					sum += mat[tempI][tempJ]
				}
			}
			answers[i][j] = sum
		}
	}

	return answers
}
