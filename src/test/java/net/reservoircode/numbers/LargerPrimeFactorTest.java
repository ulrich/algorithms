package net.reservoircode.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargerPrimeFactorTest {

    @Test
    void should_get_larger_number_for_13195() {
        // Given
        final LargerPrimeFactor largerPrimeFactor = new LargerPrimeFactor();

        // When
        final long largerNumber = largerPrimeFactor.getLargerNumber(13195);

        // Then
        assertEquals(29, largerNumber); // 5, 7, 13 and 29
    }

    @Test
    void should_get_larger_number_for_600851475143() {
        // Given
        final LargerPrimeFactor largerPrimeFactor = new LargerPrimeFactor();

        // When
        final long largerNumber = largerPrimeFactor.getLargerNumber(600851475143L);

        // Then
        assertEquals(6857, largerNumber);
    }
}