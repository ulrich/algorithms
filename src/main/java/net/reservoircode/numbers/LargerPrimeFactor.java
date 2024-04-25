package net.reservoircode.numbers;

/**
 * <a href="https://projecteuler.net/problem=3">https://projecteuler.net/problem=3</a>
 */
public class LargerPrimeFactor {

    public long getLargerNumber(long number) {
        long i = 2;

        while (number > 1) {
            while (number % i == 0) {
                System.out.print(i + " ");
                number /= i;
            }
            i++;
        }
        return --i;
    }
}
