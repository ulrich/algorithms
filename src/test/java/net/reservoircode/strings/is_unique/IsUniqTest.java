package net.reservoircode.strings.is_unique;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsUniqTest {

    @Test
    public void should_check_empty_string() {
        IsUniq iu = new IsUniq();

        assertThat(iu.one("")).isTrue();
    }

    @Test
    public void should_check_one_element() {
        IsUniq iu = new IsUniq();

        assertThat(iu.one("a")).isTrue();
    }

    @Test
    public void should_find_doublon() {
        IsUniq iu = new IsUniq();

        assertThat(iu.one("aa")).isFalse();
    }

    @Test
    public void should_not_find_doublon() {
        IsUniq iu = new IsUniq();

        assertThat(iu.one("abcde")).isTrue();
    }
}