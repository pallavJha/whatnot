package main

import "fmt"

func main() {
	fmt.Println(minSteps(3))
	fmt.Println(minSteps(2))
	fmt.Println(minSteps(111))
}

type Operation int

const (
	COPY  Operation = 1
	PASTE Operation = 2
)

type State struct {
	A             int
	Clipboard     int
	Steps         int
	LastOperation Operation
}

func minSteps(n int) int {
	if n == 1 {
		return 0
	}
	firstState := State{
		A:             1,
		Clipboard:     1,
		LastOperation: COPY,
		Steps:         1,
	}

	var states []State
	states = append(states, firstState)

	for i := 0; i < len(states); i++ {
		if states[i].A == n {
			return states[i].Steps
		}
		if states[i].LastOperation == COPY {
			if states[i].A+states[i].Clipboard <= n {
				states = append(states, State{
					A:             states[i].A + states[i].Clipboard,
					Clipboard:     states[i].Clipboard,
					LastOperation: PASTE,
					Steps:         states[i].Steps + 1,
				})
			}
		} else {
			states = append(states, State{
				A:             states[i].A,
				Clipboard:     states[i].A,
				LastOperation: COPY,
				Steps:         states[i].Steps + 1,
			})
			if states[i].A+states[i].Clipboard <= n {
				states = append(states, State{
					A:             states[i].A + states[i].Clipboard,
					Clipboard:     states[i].Clipboard,
					LastOperation: PASTE,
					Steps:         states[i].Steps + 1,
				})
			}
		}
	}
	return 0
}
