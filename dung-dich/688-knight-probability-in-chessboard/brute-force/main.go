package main

import (
	"fmt"
)

func main() {
	fmt.Println(knightProbability(3, 2, 0, 0))
	fmt.Println(knightProbability(3, 3, 0, 0))
	// fmt.Println(knightProbability(8, 30, 6, 4))
}

type Position struct {
	R           int
	C           int
	Steps       int
	Probability float64
}

func NewPosition(position Position) Position {
	return Position{
		R:           position.R,
		C:           position.C,
		Steps:       position.Steps,
		Probability: position.Probability,
	}
}

func knightProbability(N int, K int, r int, c int) float64 {
	var totalProbability float64 = 0
	var positions []Position

	positions = append(positions, Position{
		R:           r,
		C:           c,
		Steps:       0,
		Probability: 1,
	})

	for i := 0; i < len(positions); i++ {
		currentPosition := positions[i]
		if currentPosition.Steps == K {
			totalProbability += currentPosition.Probability
			continue
		}

		pos1 := NewPosition(currentPosition)
		pos1.R -= 2
		pos1.C -= 1
		if pos1.R >= 0 && pos1.C >= 0 && pos1.R < N && pos1.C < N {
			pos1.Steps++
			pos1.Probability /= 8
			positions = append(positions, pos1)
		}

		pos1 = NewPosition(currentPosition)
		pos1.R -= 2
		pos1.C += 1
		if pos1.R >= 0 && pos1.C >= 0 && pos1.R < N && pos1.C < N {
			pos1.Steps++
			pos1.Probability /= 8
			positions = append(positions, pos1)
		}

		pos1 = NewPosition(currentPosition)
		pos1.R -= 1
		pos1.C += 2
		if pos1.R >= 0 && pos1.C >= 0 && pos1.R < N && pos1.C < N {
			pos1.Steps++
			pos1.Probability /= 8
			positions = append(positions, pos1)
		}

		pos1 = NewPosition(currentPosition)
		pos1.R += 1
		pos1.C += 2
		if pos1.R >= 0 && pos1.C >= 0 && pos1.R < N && pos1.C < N {
			pos1.Steps++
			pos1.Probability /= 8
			positions = append(positions, pos1)
		}

		pos1 = NewPosition(currentPosition)
		pos1.R += 2
		pos1.C += 1
		if pos1.R >= 0 && pos1.C >= 0 && pos1.R < N && pos1.C < N {
			pos1.Steps++
			pos1.Probability /= 8
			positions = append(positions, pos1)
		}

		pos1 = NewPosition(currentPosition)
		pos1.R += 2
		pos1.C -= 1
		if pos1.R >= 0 && pos1.C >= 0 && pos1.R < N && pos1.C < N {
			pos1.Steps++
			pos1.Probability /= 8
			positions = append(positions, pos1)
		}

		pos1 = NewPosition(currentPosition)
		pos1.R += 1
		pos1.C -= 2
		if pos1.R >= 0 && pos1.C >= 0 && pos1.R < N && pos1.C < N {
			pos1.Steps++
			pos1.Probability /= 8
			positions = append(positions, pos1)
		}

		pos1 = NewPosition(currentPosition)
		pos1.R -= 1
		pos1.C -= 2
		if pos1.R >= 0 && pos1.C >= 0 && pos1.R < N && pos1.C < N {
			pos1.Steps++
			pos1.Probability /= 8
			positions = append(positions, pos1)
		}
	}
	return totalProbability
}
