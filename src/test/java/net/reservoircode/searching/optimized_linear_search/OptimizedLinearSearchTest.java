package net.reservoircode.searching.optimized_linear_search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OptimizedLinearSearchTest {

    @Test
    public void should_return_first_index_of_element() {
        assertThat(new OptimizedLinearSearch().search(new int[]{0, 200, 34, 99, 2, 901, 2}, 2)).isEqualTo(4);
    }

    @Test
    public void should_return_error_code_if_not_found() {
        assertThat(new OptimizedLinearSearch().search(new int[]{0, 1, 2}, 3)).isEqualTo(-1);
    }
}