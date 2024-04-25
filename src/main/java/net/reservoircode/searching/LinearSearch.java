package net.reservoircode.searching;

/**
 * Implementation of linear search simple algorithm.
 */
public class LinearSearch {

    public int search(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
