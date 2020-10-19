package main

import (
	"fmt"
)

func main() {
	// fmt.Println(longestDiverseString(0, 8, 11))
	// fmt.Println(longestDiverseString(1, 1, 7))
	fmt.Println(longestDiverseString(1, 2, 7))
	// fmt.Println(longestDiverseString(2, 2, 1))
	// fmt.Println(longestDiverseString(7, 1, 0))
	// "ccbccbbccbbccbbccbc"
	// "ccbcbccbbccbbccbbcc"
	// "ccbbccbbccbbccbbcc"

}

func longestDiverseString(a int, b int, c int) string {
	var countMap = map[uint8]int{
		'a': a,
		'b': b,
		'c': c,
	}
	diverseString := ""
	for {
		currentOrder, cont := findLargest(countMap['a'], countMap['b'], countMap['c'])
		if !cont {
			return diverseString
		}
		if len(diverseString) == 0 {
			diverseString = appendToString(countMap, currentOrder, 0, diverseString)
			continue
		}
		if diverseString[len(diverseString)-1] == currentOrder[0] {
			if countMap[currentOrder[1]] > 0 {
				diverseString = appendToString(countMap, currentOrder, 1, diverseString)
			} else if countMap[currentOrder[2]] > 0 {
				diverseString = appendToString(countMap, currentOrder, 2, diverseString)
			} else {
				added := false
				for i := 0; i < len(diverseString)-1; i++ {
					if diverseString[i] != currentOrder[0] && diverseString[i+1] != currentOrder[0] {
						if countMap[currentOrder[0]] == 1 {
							diverseString = diverseString[:i+1] + string(currentOrder[0]) + diverseString[i+1:]
							countMap[currentOrder[0]]--
						} else {
							diverseString = diverseString[:i+1] + string(currentOrder[0]) + string(currentOrder[0]) + diverseString[i+1:]
							countMap[currentOrder[0]] -= 2
						}
						added = true
						break
					}
				}
				if !added {
					return diverseString
				}
			}
		} else {
			diverseString = appendToString(countMap, currentOrder, 0, diverseString)
		}
	}

}

func appendToString(countMap map[uint8]int, currentOrder [3]uint8, index int, diverseString string) string {
	if countMap[currentOrder[index]] == 1 {
		diverseString += string(currentOrder[index])
		countMap[currentOrder[index]]--
	} else {
		diverseString += string(currentOrder[index]) + string(currentOrder[index])
		countMap[currentOrder[index]] -= 2
	}
	return diverseString
}

func findLargest(a, b, c int) ([3]uint8, bool) {
	if a <= 0 && b <= 0 && c <= 0 {
		return [3]uint8{}, false
	}
	if a >= b && a >= c {
		if b >= c {
			return [3]uint8{'a', 'b', 'c'}, true
		} else {
			return [3]uint8{'a', 'c', 'b'}, true
		}
	} else if b >= a && b >= c {
		if a >= c {
			return [3]uint8{'b', 'a', 'c'}, true
		} else {
			return [3]uint8{'b', 'c', 'a'}, true
		}
	} else {
		if a >= b {
			return [3]uint8{'c', 'a', 'b'}, true
		} else {
			return [3]uint8{'c', 'b', 'a'}, true
		}
	}
}
