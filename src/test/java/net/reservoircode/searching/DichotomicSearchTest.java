package net.reservoircode.searching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DichotomicSearchTest {

    @Test
    void should_not_find_element_in_sorted_array() {
        // Given
        int[] array = {1, 5, 16, 21, 32, 32, 75, 152};

        // When
        int position = new DichotomicSearch().search(array, 50);

        // Then
        assertThat(position).isEqualTo(-1);
    }

    @Test
    void should_find_expected_position_in_sorted_array() {
        // Given
        int[] array = {1, 5, 16, 21, 32, 32, 75, 152};
        int expectedPosition = 6;

        // When
        int position = new DichotomicSearch().search(array, 75);

        // Then
        assertThat(position).isEqualTo(expectedPosition);
    }

    @Test
    void should_find_expected_position_with_one_element_in_sorted_array() {
        // Given
        int[] array = {1};
        int expectedPosition = 0;

        // When
        int position = new DichotomicSearch().search(array, 1);

        // Then
        assertThat(position).isEqualTo(expectedPosition);
    }

    @Test
    void should_find_expected_position_with_even_length_sorted_array() {
        // Given
        int[] array = {1, 5};
        int expectedPosition = 1;

        // When
        int position = new DichotomicSearch().search(array, 5);

        // Then
        assertThat(position).isEqualTo(expectedPosition);
    }

    @Test
    void should_find_expected_position_with_odd_length_sorted_array() {
        // Given
        int[] array = {1, 5, 16, 21, 32, 32, 75, 152, 522};
        int expectedPosition = 2;

        // When
        int position = new DichotomicSearch().search(array, 16);

        // Then
        assertThat(position).isEqualTo(expectedPosition);
    }

    @Test
    void should_find_expected_position_with_expected_value_at_the_end_of_odd_length_sorted_array() {
        // Given
        int[] array = {1, 5, 16, 21, 32, 32, 75, 152, 522};
        int expectedPosition = 8;

        // When
        int position = new DichotomicSearch().search(array, 522);

        // Then
        assertThat(position).isEqualTo(expectedPosition);
    }
}