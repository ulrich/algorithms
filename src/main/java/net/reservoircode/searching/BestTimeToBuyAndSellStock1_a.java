package net.reservoircode.searching;

/**
 * !!! REFUSED !!!
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
class BestTimeToBuyAndSellStock1_a {

    public int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int value = prices[j] - prices[i];

                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }
}