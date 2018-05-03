package net.reservoircode.data_structures.my_linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLinkedListTest {

    @Test
    public void should_add_node() {
        MyLinkedList mll = new MyLinkedList();
        mll.insert(4);
        mll.insert(5);

        assertThat(mll.size()).isEqualTo(2);
    }

    @Test
    public void should_delete_node() {
        MyLinkedList mll = new MyLinkedList();
        mll.insert(6);
        mll.insert(7);
        mll.insert(8);
        mll.insert(9);

        assertThat(mll.size()).isEqualTo(4);

        mll.remove();
        assertThat(mll.size()).isEqualTo(3);
            }
}