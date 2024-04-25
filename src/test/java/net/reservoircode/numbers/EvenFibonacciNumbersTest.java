package net.reservoircode.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvenFibonacciNumbersTest {

    @Test
    void should_sum_even_numbers() {
        // Given
        EvenFibonacciNumbers efn = new EvenFibonacciNumbers();

        // When
        int result = efn.sumOf(4_000_000);

        // Then
        assertEquals(4613732, result);
    }
}