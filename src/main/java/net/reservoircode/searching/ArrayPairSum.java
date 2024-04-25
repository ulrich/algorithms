package net.reservoircode.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array, output all pairs that sum up to a specific value k.
 */
public class ArrayPairSum {
    private final int[] array;

    private int left, right;

    public ArrayPairSum(int[] array) {
        this.array = array;
        left = 0;
        right = array.length - 1;
    }

    public List<Tuple> find(Integer value) {
        Arrays.sort(array);

        List<Tuple> tuples = new ArrayList<Tuple>();

        while (left < right) {
            int sum = array[left] + array[right];

            if (sum == value) {
                tuples.add(new Tuple(array[left], array[right]));
                left += 1;
            } else if (sum < value) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return tuples;
    }

    public record Tuple(Integer left, Integer right) {
    }
}
