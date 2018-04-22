package net.reservoircode.strings.urlify;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class URLifyTest {

    @Test
    public void should_not_urlify_with_invalid_parameter() {
        try {
            new URLify().urlify(null, 5);
            assertThat(false).isTrue();
        } catch (Exception e) {
            // OK
        }
    }

    @Test
    public void should_urlify_empy_string() {
        String expect = new URLify().urlify("  ", 5);

        assertThat(expect).isEqualTo("%20%20");
    }

    @Test
    public void should_urlify() {
        String expect = new URLify().urlify("Mr John Smith    ", 13);

        assertThat(expect).isEqualTo("Mr%20John%20Smith");
    }
}