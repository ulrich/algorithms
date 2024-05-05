package net.reservoircode.numbers;

/**
 * <pre>
 * fib(n) = fib(n - 1) + fib(n - 2)
 *
 * If n < 2 return n;
 * </pre>
 */
public class Fibonacci {

    public int fibonacci(int value) {
        if (value < 2) {
            return value;
        }
        return fibonacci(value - 1) + fibonacci(value - 2);
    }
}
