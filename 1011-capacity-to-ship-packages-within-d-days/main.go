var actualWeights []int
var sumWeights []int
var minWeight int

func shipWithinDays(weights []int, days int) int {
    minWeight = math.MaxInt32
    actualWeights = weights
    sumWeights = make([]int, len(actualWeights))
    for i, weight := range actualWeights {
        sumWeights[i] = weight
        if i != 0 {
            sumWeights[i] += sumWeights[i - 1]
        }
    }
    
    run(0, 0, 0, days)
    return minWeight
}


func run(startIndex int, endIndex int, maxUntilNow int, days int) int {
    if days == 0 {
        return 0
    }
    if days == 1 {
        endIndex = len(actualWeights) - 1
    }
    if maxUntilNow > minWeight {
        return -1
    }
    
    for endIndex != len(actualWeights) {
        sum := sumOfRange(startIndex, endIndex)
        if maxUntilNow < sum {
            maxUntilNow = sum
        }
        if endIndex == len(actualWeights) - 1 {
            if maxUntilNow < minWeight {
                minWeight = maxUntilNow
            }
        }
        shouldStop := run(endIndex + 1, endIndex + 1, maxUntilNow, days - 1)
        if shouldStop == -1 {
            return 0
        }
        endIndex++
    }
    return 0
}

func sumOfRange(start, end int) int {
    sumTillEnd := sumWeights[end]
    if start != 0 {
        sumTillEnd = sumTillEnd - sumWeights[start - 1]
    }
    return sumTillEnd
}
