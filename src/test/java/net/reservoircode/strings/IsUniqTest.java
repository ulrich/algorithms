package net.reservoircode.strings;

import net.reservoircode.strings.IsUniq;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsUniqTest {

    @Test
    public void should_check_empty_string() {
        assertThat(new IsUniq().one("")).isTrue();
    }

    @Test
    public void should_check_one_element() {
        assertThat(new IsUniq().one("a")).isTrue();
    }

    @Test
    public void should_find_doublon() {
        assertThat(new IsUniq().one("aa")).isFalse();
    }

    @Test
    public void should_not_find_doublon() {
        assertThat(new IsUniq().one("abcde")).isTrue();
    }
}