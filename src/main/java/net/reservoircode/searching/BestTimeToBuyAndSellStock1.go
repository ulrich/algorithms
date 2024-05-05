package main

func main() {
	profit := maxProfit([]int{7, 1, 5, 3, 6, 4})

	println(profit)
}

func maxProfit(prices []int) int {
	maxProfit := 0
	minPrice := prices[0]

	for i := 1; i < len(prices); i++ {
		maxProfit = MaxInteger(maxProfit, prices[i]-minPrice)
		minPrice = MinInteger(prices[i], minPrice)
	}
	return maxProfit
}

func MinInteger(a, b int) int {
	if a <= b {
		return a
	} else {
		return b
	}
}

func MaxInteger(a, b int) int {
	if a >= b {
		return a
	} else {
		return b
	}
}
