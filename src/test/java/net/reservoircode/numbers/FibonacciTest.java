package net.reservoircode.numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciTest {

    @Test
    void should_return_fibonacci_value() {
        // Given, When
        int expected = new Fibonacci().fibonacci(6);

        // Then
        assertThat(expected).isEqualTo(8);
    }
}