package net.reservoircode.numbers;

import org.junit.jupiter.api.Test;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleOfTest {

    @Test
    void should_find_multiples_for_10() {
        final MultipleOf multipleOf = new MultipleOf();

        int result = multipleOf.sumOfMultipleFor(of(3, 5), 10);

        assertEquals(23, result);
    }

    @Test
    void should_find_multiples_for_1000() {
        final MultipleOf multipleOf = new MultipleOf();

        int result = multipleOf.sumOfMultipleFor(of(3, 5), 1_000);

        assertEquals(233168, result);
    }
}