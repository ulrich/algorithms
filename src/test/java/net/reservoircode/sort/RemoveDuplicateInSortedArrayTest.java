package net.reservoircode.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicateInSortedArrayTest {

    private final RemoveDuplicateInSortedArray instance = new RemoveDuplicateInSortedArray();

    @Test
    void should_remove_duplicates() {
        // Given
        int[] nums = {1, 1, 2, 3, 4, 4, 4};
        int[] expectedNums = {1, 2, 3, 4, 4, 4};

        // When
        int elements = instance.remove(nums);

        // Then
        assertThat(elements).isEqualTo(4);

        for (int i = 0; i < elements; i++) {
            assertThat(nums[i]).isEqualTo(expectedNums[i]);
        }
    }
}