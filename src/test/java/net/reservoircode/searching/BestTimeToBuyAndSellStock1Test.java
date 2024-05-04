package net.reservoircode.searching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * {7, 1, 5, 3, 6, 4}
 *     ^        ^
 *    Sell     Buy
 * </pre>
 *
 * <p>
 * max-profit = buy - sell
 * </p>
 */
class BestTimeToBuyAndSellStock1Test {

    @Test
    void should_find_the_max_profit() {
        // Given
        int[] nums = {7, 1, 5, 3, 6, 4};

        // When
        int maxProfit = new BestTimeToBuyAndSellStock1_c()
                .maxProfit(nums);

        // Then
        assertThat(maxProfit).isEqualTo(5);
    }
}