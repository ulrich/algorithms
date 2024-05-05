package net.reservoircode.numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciDPTest {

    @Test
    void should_return_fibonacci_value() {
        // Given, When
        long expected = new FibonacciDP().fibonacci(999);

        // Then
        assertThat(expected).isEqualTo(8261794739546030242L);
    }
}