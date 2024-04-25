package net.reservoircode.strings;

import net.reservoircode.strings.Palindrome;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PalindromeTest {

    @Test
    public void should_not_urlify_with_invalid_parameter() {
        assertThrows(Exception.class, () -> new Palindrome().find(null, 5));
    }

    @Test
    public void should_urlify_empy_string() {
        String expect = new Palindrome().find("  ", 5);

        assertThat(expect).isEqualTo("%20%20");
    }

    @Test
    public void should_urlify() {
        String expect = new Palindrome().find("Mr John Smith    ", 13);

        assertThat(expect).isEqualTo("Mr%20John%20Smith");
    }
}