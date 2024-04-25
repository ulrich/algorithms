package net.reservoircode.numbers;

/**
 * Implement the factorial algorithm with recursion.
 */
public class Factorial {

    public int calculate(int element) {
        return (element == 0) ? 1 : element * calculate(element - 1);
    }
}
