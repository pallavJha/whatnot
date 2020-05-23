package main

import (
	"fmt"
	"math"
)

func main() {
	// 11
	// 17
	// 19
	// 10
	// 6
	// 170
	// 44
	// fmt.Println(mincostTickets([]int{1, 4, 6, 7, 8, 20}, []int{2, 7, 15}))
	fmt.Println(mincostTickets([]int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, []int{2, 7, 15}))
	// fmt.Println(mincostTickets([]int{1, 5, 6, 8, 9, 10, 12, 13, 14, 16, 17, 18, 20, 21, 23, 24, 27, 28, 29}, []int{1, 6, 23}))
	// fmt.Println(mincostTickets([]int{4, 5, 9, 11, 14, 16, 17, 19, 21, 22, 24}, []int{1, 4, 18}))
	// fmt.Println(mincostTickets([]int{1, 4, 6, 7, 8, 20}, []int{7, 2, 15}))
	// fmt.Println(mincostTickets([]int{3, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 20, 21, 23, 25, 26, 27, 29, 30, 33, 34, 35, 36, 38, 39, 40, 42, 45, 46, 47, 48, 49, 51, 53, 54, 56, 57, 58, 59, 60, 61, 63, 64, 67, 68, 69, 70, 72, 74, 77, 78, 79, 80, 81, 82, 83, 84, 85, 88, 91, 92, 93, 96}, []int{3, 17, 57}))
	// fmt.Println(mincostTickets([]int{1, 4, 6, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 27, 28}, []int{3, 13, 200}))
}

func mincostTickets(days []int, costs []int) int {
	minTicketCost := make([]int, len(days))
	for i := range minTicketCost {
		minTicketCost[i] = math.MaxInt32
	}
	prevDayMinCost := 0
	for i := 0; i < len(days); i++ {
		nextCost1 := prevDayMinCost + costs[0]
		nextCost7 := prevDayMinCost + costs[1]
		for j := i + 1; j < len(days); j++ {
			if days[j] > days[i]+6 {
				break
			}
			if minTicketCost[j] > nextCost7 {
				minTicketCost[j] = nextCost7
			}
		}
		nextCost30 := prevDayMinCost + costs[2]
		for j := i + 1; j < len(days); j++ {
			if days[j] > days[i]+29 {
				break
			}
			if minTicketCost[j] > nextCost30 {
				minTicketCost[j] = nextCost30
			}
		}
		if nextCost1 <= nextCost7 && nextCost1 <= nextCost30 {
			prevDayMinCost = nextCost1
		} else if nextCost7 <= nextCost1 && nextCost7 <= nextCost30 {
			prevDayMinCost = nextCost7
		} else {
			prevDayMinCost = nextCost30
		}
		if prevDayMinCost < minTicketCost[i] {
			minTicketCost[i] = prevDayMinCost
		} else {
			prevDayMinCost = minTicketCost[i]
		}
		fmt.Println(minTicketCost)
	}

	return prevDayMinCost
}

func mincostTickerBruteForce(days []int, costs []int) int {
	return mincostNextDay(1, 0, 0, 0, days, costs)
}

func mincostNextDay(depth, currentDayIndex, validTill, totalCost int, days, cost []int) int {
	currentDay := days[currentDayIndex]
	if currentDayIndex == len(days)-1 {
		if currentDay <= validTill {
			return totalCost
		} else {
			nextCostToPick := 0
			if cost[0] <= cost[1] && cost[0] <= cost[2] {
				nextCostToPick = cost[0]
			} else if cost[1] <= cost[0] && cost[1] <= cost[2] {
				nextCostToPick = cost[1]
			} else {
				nextCostToPick = cost[2]
			}
			return totalCost + nextCostToPick
		}
	}
	minCost := math.MaxInt32
	if currentDay <= validTill {
		minCost = mincostNextDay(depth+1, currentDayIndex+1, validTill, totalCost, days, cost)
	} else {
		newCost := totalCost + cost[0]
		newValidTill := currentDay
		minCost = mincostNextDay(depth+1, currentDayIndex+1, newValidTill, newCost, days, cost)

		newCost = totalCost + cost[1]
		newValidTill = currentDay + 6
		thisCost := mincostNextDay(depth+1, currentDayIndex+1, newValidTill, newCost, days, cost)
		if thisCost < minCost {
			minCost = thisCost
		}

		newCost = totalCost + cost[2]
		newValidTill = currentDay + 29
		thisCost = mincostNextDay(depth+1, currentDayIndex+1, newValidTill, newCost, days, cost)
		if thisCost < minCost {
			minCost = thisCost
		}
	}
	return minCost
}
