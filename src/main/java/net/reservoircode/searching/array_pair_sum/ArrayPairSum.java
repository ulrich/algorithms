package net.reservoircode.searching.array_pair_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPairSum {
    private int[] array;
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

    class Tuple {
        private final Integer left;
        private final Integer right;

        public Tuple(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }

        public Integer getLeft() {
            return left;
        }

        public Integer getRight() {
            return right;
        }
    }
}
