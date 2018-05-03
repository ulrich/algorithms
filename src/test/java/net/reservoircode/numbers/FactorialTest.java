package net.reservoircode.numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FactorialTest {

    @Test
    public void should_calculate_factorial() {
        Factorial factorial = new Factorial();

        assertThat(factorial.calculate(8)).isEqualTo(40320);
    }
}