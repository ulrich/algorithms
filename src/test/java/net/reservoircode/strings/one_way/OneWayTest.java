package net.reservoircode.strings.one_way;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OneWayTest {

    @Test
    public void should_not_find_more_than_one_edit() {
        OneWay oneWay = new OneWay();

        assertThat(oneWay.check("pale", "ple")).isTrue();
        assertThat(oneWay.check("pales", "pale")).isTrue();
        assertThat(oneWay.check("pale", "bale")).isTrue();
        assertThat(oneWay.check("ple", "pale")).isTrue();
    }

    @Disabled
    @Test
    public void should_find_more_than_one_edit() {
        OneWay oneWay = new OneWay();

        assertThat(oneWay.check("pale", "bake")).isFalse();
    }
}