package net.reservoircode.data_structures.my_linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLinkedListTest {

    @Test
    public void should_add_element() {
        // Given
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // When
        list.add(1);
        list.add(2);

        // Then
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void should_remove_element() {
        // Given
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // When
        final Integer removedElement = list.removeLast();

        // Then
        assertThat(list.size()).isEqualTo(3);
        assertThat(removedElement).isEqualTo(4);
    }
}