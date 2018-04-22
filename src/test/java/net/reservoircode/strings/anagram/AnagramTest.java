package net.reservoircode.strings.anagram;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramTest {

    @Test
    public void should_not_find_permutation_for_different_strings() {
        assertThat(new Anagram().check("abc", "def")).isFalse();
    }

    @Test
    public void should_find_permutation() {
        assertThat(new Anagram().check("abc", "cab")).isTrue();
    }
}