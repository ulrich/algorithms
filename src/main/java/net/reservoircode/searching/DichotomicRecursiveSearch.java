package net.reservoircode.searching;

public class DichotomicRecursiveSearch {

    private int count = 0;

    public int search(int[] tab, int expected) {
        int left = 0;
        int right = tab.length;

        return search(tab, left, right, expected);
    }

    private int search(int[] tab, int left, int right, int expected) {
        count++;

        if (left > right) {
            return -1;
        }
        int position = (left + right) / 2;

        if (tab[position] == expected) {
            System.out.println(count);
            return position;
        } else if (tab[position] > expected) {
            return search(tab, left, position - 1, expected);
        } else {
            return search(tab, position + 1, right, expected);
        }
    }
}
