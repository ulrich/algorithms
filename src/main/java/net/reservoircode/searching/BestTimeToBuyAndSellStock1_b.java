package net.reservoircode.searching;

/**
 * !!! REFUSED !!!
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
class BestTimeToBuyAndSellStock1_b {

    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, 0);
    }

    private int maxProfit(int[] prices, int start, int max) {
        if (start >= prices.length) {
            return max;
        }
        int value = max;

        for (int i = start; i < prices.length - 1; i++) {
            int tmp = prices[i + 1] - prices[start];

            if (tmp > value) {
                value = tmp;
            }
        }
        return maxProfit(prices, start + 1, value);
    }
}
