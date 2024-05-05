package net.reservoircode.numbers;

/**
 * <pre>
 * fib(n) = fib(n - 1) + fib(n - 2)
 *
 * If n < 2 return n;
 * </pre>
 * <p>
 * Implementation with dynamic programming by using a memoize.
 * </p>
 */
public class FibonacciDP {

    public long fibonacci(int value) {
        long[] cache = new long[value + 1];

        return fibonacciWithMemoize(value, cache);
    }

    private long fibonacciWithMemoize(int value, long[] cache) {
        if (value < 2) {
            cache[value] = value;
            return value;
        } else if (cache[value] > 0) {
            return cache[value];
        }
        cache[value] = fibonacciWithMemoize(value - 1, cache) + fibonacciWithMemoize(value - 2, cache);
        return cache[value];
    }
}
