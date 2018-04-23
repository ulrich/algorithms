package net.reservoircode.searching.optimized_linear_search;

public class OptimizedLinearSearch {

    public int search(int[] array, int element) {
        int i = 0;
        int last = array[array.length - 1];

        array[array.length - 1] = element;

        while (array[i] != element) {
            i++;
        }
        array[array.length - 1] = last;

        if (i < array.length - 1 || array[i] == element) {
            return i;
        }
        return -1;
    }
}
