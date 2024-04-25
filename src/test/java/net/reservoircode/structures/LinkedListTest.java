package net.reservoircode.structures;

import net.reservoircode.structures.LinkedList;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
public class LinkedListTest {

    @Test
    public void should_add_element() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // When, Then
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void should_remove_first() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);

        // When
        Integer value = list.removeFirst();

        // Then
        assertThat(value).isEqualTo(1);
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void should_remove_first_consistency() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);

        // When
        Integer value = list.removeFirst();

        // Then
        assertThat(value).isEqualTo(1);
        assertThat(list.size()).isEqualTo(0);

        // Given
        list.add(1);

        // When
        value = list.removeFirst();

        // Then
        assertThat(value).isEqualTo(1);
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void should_remove_each_first_element() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // When
        Integer value = list.removeFirst();

        // Then
        assertThat(value).isEqualTo(1);
        assertThat(list.size()).isEqualTo(2);

        // When
        value = list.removeFirst();

        // Then
        assertThat(value).isEqualTo(2);
        assertThat(list.size()).isEqualTo(1);

        // When
        value = list.removeFirst();

        // Then
        assertThat(value).isEqualTo(3);
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void should_throw_exception_when_removing_null_element() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();

        // When
        IllegalStateException exception = assertThrows(IllegalStateException.class, list::removeLast);

        // Then
        assertThat(exception.getMessage()).isEqualTo("No element available");
    }
}