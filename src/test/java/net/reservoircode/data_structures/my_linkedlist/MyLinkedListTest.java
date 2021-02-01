package net.reservoircode.data_structures.my_linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyLinkedListTest {

    @Test
    public void should_add_element() {
        // Given
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // When
        list.add(1);
        list.add(2);
        list.add(3);

        // Then
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void should_remove_last_element() {
        // Given
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // When
        Integer lastElement = list.removeLast();

        // Then
        assertThat(list.size()).isEqualTo(2);
        assertThat(lastElement).isEqualTo(3);
    }

    @Test
    public void should_remove_each_last_element() {
        // Given
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // When, Then
        Integer lastElement = list.removeLast();
        assertThat(list.size()).isEqualTo(2);
        assertThat(lastElement).isEqualTo(3);

        // When, Then
        lastElement = list.removeLast();
        assertThat(list.size()).isEqualTo(1);
        assertThat(lastElement).isEqualTo(2);

        // When, Then
        lastElement = list.removeLast();
        assertThat(list.size()).isEqualTo(0);
        assertThat(lastElement).isEqualTo(1);
    }

    @Test
    public void should_throw_exception_when_removing_null_element() {
        // Given
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // When
        IllegalStateException exception = assertThrows(IllegalStateException.class, list::removeLast);

        // Then
        assertThat(exception.getMessage()).isEqualTo("No element available");
    }
}