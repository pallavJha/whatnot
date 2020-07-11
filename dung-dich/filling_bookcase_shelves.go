package main

import (
	"encoding/json"
	"fmt"
	"log"
	"math"
)

func main() {
	// books := [][]int{
	// 	{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2},
	// }
	// fmt.Println(minHeightShelves(books, 4))
	// books = [][]int{
	// 	{1, 1}, {1, 2}, {1, 2}, {1, 2}, {1, 1},
	// }
	// fmt.Println(minHeightShelves(books, 3))
	// books = [][]int{
	// 	{1, 1}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 1},
	// }
	// fmt.Println(minHeightShelves(books, 3))
	// books = [][]int{
	// 	{1, 2}, {1, 2}, {1, 2}, {1, 2},
	// }
	// fmt.Println(minHeightShelves(books, 1))
	books := [][]int{
		{7, 6}, {4, 4}, {1, 8}, {2, 4},
	}
	fmt.Println(minHeightShelves(books, 5))
	// books := [][]int{
	// 	{11, 83}, {170, 4}, {93, 80}, {155, 163}, {134, 118}, {75, 14}, {122, 192}, {123, 154}, {187, 29}, {160, 64}, {170, 152}, {113, 179}, {60, 102}, {28, 187}, {59, 95}, {187, 97}, {49, 193}, {67, 126}, {75, 45}, {130, 160}, {4, 102}, {116, 171}, {43, 170}, {96, 188}, {54, 15}, {167, 183}, {58, 158}, {59, 55}, {148, 183}, {89, 95}, {90, 113}, {51, 49}, {91, 28}, {172, 103}, {173, 3}, {131, 78}, {11, 199}, {77, 200},
	// }
	// fmt.Println(minHeightShelves(books, 200))
}

func minHeightShelves(books [][]int, shelf_width int) int {
	var shelf []arrangement
	var minShelfHeights []int
	shelf = append(shelf, arrangement{
		ShelfNo:            1,
		Width:              books[0][0],
		CurrentShelfHeight: books[0][1],
		TotalHeight:        books[0][1],
	})
	minShelfHeights = append(minShelfHeights, books[0][1])
	fmt.Println(0)
	fmt.Println(shelf)

	for i := 1; i < len(books); i++ {
		currentBook := books[i]
		var shelfWithCurrentBook []arrangement
		for _, elem := range shelf {
			if elem.Width+currentBook[0] <= shelf_width {
				newElem := arrangement{
					ShelfNo:            elem.ShelfNo,
					Width:              elem.Width + currentBook[0],
					CurrentShelfHeight: elem.CurrentShelfHeight,
					TotalHeight:        elem.TotalHeight,
				}
				if currentBook[1] > elem.CurrentShelfHeight {
					newElem.CurrentShelfHeight = currentBook[1]
					newElem.TotalHeight = newElem.TotalHeight + currentBook[1] - elem.CurrentShelfHeight
				}
				shelfWithCurrentBook = append(shelfWithCurrentBook, newElem)
			} else {
				newElem := arrangement{
					ShelfNo:            elem.ShelfNo + 1,
					Width:              currentBook[0],
					CurrentShelfHeight: currentBook[1],
					TotalHeight:        elem.TotalHeight + currentBook[1],
				}
				shelfWithCurrentBook = append(shelfWithCurrentBook, newElem)
			}
		}
		newElem := arrangement{
			ShelfNo:            shelf[len(shelf)-1].ShelfNo + 1,
			Width:              currentBook[0],
			CurrentShelfHeight: currentBook[1],
			TotalHeight:        minShelfHeights[i - 1] + currentBook[1],
		}
		shelfWithCurrentBook = append(shelfWithCurrentBook, newElem)

		minShelfHeight := math.MaxInt32
		for j := 0; j < len(shelfWithCurrentBook); j++ {
			if shelfWithCurrentBook[j].TotalHeight < minShelfHeight {
				minShelfHeight = shelfWithCurrentBook[j].TotalHeight
			}
		}
		minShelfHeights = append(minShelfHeights, minShelfHeight)
		shelf = shelfWithCurrentBook
		fmt.Println(i)
		fmt.Println(shelfWithCurrentBook)
	}

	return minShelfHeights[len(minShelfHeights)-1]
}

type arrangement struct {
	ShelfNo            int
	Width              int
	CurrentShelfHeight int
	TotalHeight        int
}

func (b arrangement) String() string {
	jsonBytes, err := json.Marshal(&b)
	if err != nil {
		log.Fatal(err)
	}
	return string(jsonBytes)
}
