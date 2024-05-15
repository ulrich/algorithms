package net.reservoircode.searching;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

class DichotomicRecursiveSearchTest {

    @Test
    void should_not_find_element_in_sorted_array() {
        // Given
        int[] array = {1, 5, 16, 21, 32, 32, 75, 152};

        // When
        int position = new DichotomicRecursiveSearch().search(array, 50);

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
    void should_find_expected_position_in_massive_sorted_array() {
        // Given
        int[] array = new int[1_000_000];

        ThreadLocalRandom rand = ThreadLocalRandom.current();

        int nextInt = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = nextInt = rand.nextInt(nextInt, nextInt + 100);
        }
        int expectedPosition = 65_536;

        // When
        int position = new DichotomicRecursiveSearch().search(array, array[expectedPosition]);

        // Then
        assertThat(position).isEqualTo(expectedPosition);
    }
}