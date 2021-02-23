package net.reservoircode.numbers;

// https://projecteuler.net/problem=2
public class EvenFibonacciNumbers {

    public int sumOf(int n) {
        int n1 = 0, n2 = 1, n3;
        int result = 0;

        do {
            n3 = n1 + n2;
            if (n3 % 2 == 0) {
                result += n3;
            }
            n1 = n2;
            n2 = n3;
        } while (n3 <= n);
        return result;
    }

}
