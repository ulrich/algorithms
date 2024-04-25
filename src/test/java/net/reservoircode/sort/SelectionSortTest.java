package net.reservoircode.sort;

import org.junit.jupiter.api.Test;

import java.util.random.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class SelectionSortTest {

    @Test
    public void should_return_sorted_array() {
        assertThat(new SelectionSort().sort(new int[]{12, 9, 3, 7, 14, 11}))
                .isEqualTo(new int[]{3, 7, 9, 11, 12, 14});
    }

    @Test
    public void should_return_sorted_array_with_duplicate() {
        assertThat(new SelectionSort().sort(new int[]{12, 12, 3, 7}))
                .isEqualTo(new int[]{3, 7, 12, 12});
    }

    @Test
    public void should_return_sorted_array_with_many_entries() {
        // Given
        RandomGenerator randomGenerator = RandomGenerator.getDefault();

        int[] array = new int[100_000];

        for (int i = 0; i < array.length; i++) {
            array[i] = randomGenerator.nextInt(999);
        }

        // When
        int[] sortedArray = new SelectionSort().sort(array);

        // Then
        assertThat(sortedArray).isSorted();
    }

    @Test
    public void should_return_unsorted_array_when_empty() {
        assertThat(new SelectionSort().sort(new int[]{}))
                .isEqualTo(new int[]{});
    }
}