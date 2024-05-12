package main

import "testing"

func Test_should_not_find_element_in_sorted_array(t *testing.T) {
	// Given
	tab := []int{1, 5, 16, 21, 32, 32, 75, 152}
	want := -1

	// When
	got := search(tab, 50)

	// Then
	if want != got {
		t.Errorf("Got %d want %d", got, want)
	}
}

func Test_should_find_expected_position_in_sorted_array(t *testing.T) {
	// Given
	tab := []int{1, 5, 16, 21, 32, 32, 75, 152}
	want := 6

	// When
	got := search(tab, 75)

	// Then
	if want != got {
		t.Errorf("Got %d want %d", got, want)
	}
}

func Test_should_find_expected_position_with_one_element_in_sorted_array(t *testing.T) {
	// Given
	tab := []int{1}
	want := 0

	// When
	got := search(tab, 1)

	// Then
	if want != got {
		t.Errorf("Got %d want %d", got, want)
	}
}

func Test_should_find_expected_position_with_even_length_sorted_array(t *testing.T) {
	// Given
	tab := []int{1, 5}
	want := 1

	// When
	got := search(tab, 5)

	// Then
	if want != got {
		t.Errorf("Got %d want %d", got, want)
	}
}

func Test_should_find_expected_position_with_odd_length_sorted_array(t *testing.T) {
	// Given
	tab := []int{1, 5, 16, 21, 32, 32, 75, 152, 522}
	want := 2

	// When
	got := search(tab, 16)

	// Then
	if want != got {
		t.Errorf("Got %d want %d", got, want)
	}
}

func Test_should_find_expected_position_with_expected_value_at_the_end_of_odd_length_sorted_array(t *testing.T) {
	// Given
	tab := []int{1, 5, 16, 21, 32, 32, 75, 152, 522}
	want := 8

	// When
	got := search(tab, 522)

	// Then
	if want != got {
		t.Errorf("Got %d want %d", got, want)
	}
}
