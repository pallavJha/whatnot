package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Printf("%f\n", knightProbability(3, 2, 0, 0))
	fmt.Printf("%f\n", knightProbability(3, 3, 0, 0))
	fmt.Printf("%f\n", knightProbability(4, 2, 0, 0))
	fmt.Printf("%f\n", knightProbability(8, 5, 6, 4))
	fmt.Printf("%f\n", knightProbability(8, 8, 6, 4))
	fmt.Printf("%f\n", knightProbability(8, 10, 6, 4))
	fmt.Printf("%f\n", knightProbability(8, 15, 6, 4))
	fmt.Printf("%f\n", knightProbability(8, 18, 6, 4))
	fmt.Printf("%f\n", knightProbability(8, 20, 6, 4))
	fmt.Printf("%f\n", knightProbability(8, 21, 6, 4))
	fmt.Printf("%f\n", knightProbability(8, 22, 6, 4))
	fmt.Printf("%f\n", knightProbability(8, 23, 6, 4))
	fmt.Printf("%f\n", knightProbability(8, 24, 6, 4))
	fmt.Printf("%f\n", knightProbability(8, 25, 6, 4))
	fmt.Printf("%f\n", knightProbability(8, 26, 6, 4))

	var a float64 = math.MaxUint64
	var b float64 = 1
	var c float64 = a + b
	fmt.Println(c)
}

func knightProbability(N int, K int, r int, c int) float64 {
	chessBoard := prepareNeighbours(N, K)
	return chessBoard[r][c] / math.Pow(8, float64(K))
}

func prepareNeighbours(N int, K int) [][]float64 {
	var chessBoard = make([][]float64, N)
	var tempChessBoard = make([][]float64, N)
	for i := range chessBoard {
		chessBoard[i] = make([]float64, N)
		tempChessBoard[i] = make([]float64, N)
		for j := range chessBoard[i] {
			chessBoard[i][j] = 1
		}
	}

	moves := [8][2]int{
		{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2},
	}

	for k := 1; k <= K; k++ {
		for i := 0; i < N; i++ {
			for j := 0; j < N; j++ {
				tempChessBoard[i][j] = float64(0)
				for m := 0; m < len(moves); m++ {
					R := i + moves[m][0]
					C := j + moves[m][1]
					if R >= 0 && C >= 0 && R < N && C < N {
						tempChessBoard[i][j] += chessBoard[R][C]
					}
				}
			}
		}
		chessBoard = tempChessBoard
		tempChessBoard = reCreate(N)
	}

	return chessBoard
}

func reCreate(N int) [][]float64 {
	var tempChessBoard = make([][]float64, N)
	for i := range tempChessBoard {
		tempChessBoard[i] = make([]float64, N)
	}
	return tempChessBoard
}
