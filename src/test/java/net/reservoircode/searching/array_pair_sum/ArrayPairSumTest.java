package net.reservoircode.searching.array_pair_sum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayPairSumTest {

    @Test
    public void should_find_one_pair() {
        List<ArrayPairSum.Tuple> tuples = new ArrayPairSum(new int[]{4, 1, 0, 9, 6}).find(15);

        assertThat(tuples.get(0).getLeft()).isEqualTo(6);
        assertThat(tuples.get(0).getRight()).isEqualTo(9);
    }

    @Test
    public void should_find_several_pairs() {
        List<ArrayPairSum.Tuple> tuples = new ArrayPairSum(new int[]{4, 1, 0, 9, 6, 14, 2, 3, 34, 7, 5, 19}).find(5);

        assertThat(tuples).hasSize(3);
    }
}