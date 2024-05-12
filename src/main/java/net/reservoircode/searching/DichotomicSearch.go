package main

func search(tab []int, expected int) int {
	left := 0
	right := len(tab)

	for left <= right {
		position := (left + right) / 2

		if tab[position] == expected {
			return position
		} else if tab[position] > expected {
			right = position - 1
		} else {
			left = position + 1
		}
	}
	return -1
}
