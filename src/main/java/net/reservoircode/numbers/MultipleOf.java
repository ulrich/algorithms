package net.reservoircode.numbers;

import java.util.List;

public class MultipleOf {

    public int sumOfMultipleFor(List<Integer> list, int limit) {
        int sum = 0;

        for (int i = 1; i < limit; i++) {
            for (Integer j : list) {
                if (i % j == 0) {
                    sum += i;
                    break;
                }
            }
        }
        return sum;
    }
}
