package net.reservoircode.searching;

public class DichotomicSearch {

    public int search(int[] tab, int expected) {
        int left = 0;
        int right = tab.length;

        while (left <= right) {
            int position = (left + right) / 2;

            if (tab[position] == expected) {
                return position;
            } else if (tab[position] > expected) {
                right = position - 1;
            } else {
                left = position + 1;
            }
        }
        return -1;
    }
}
