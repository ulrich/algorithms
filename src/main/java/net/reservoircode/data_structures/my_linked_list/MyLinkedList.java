package net.reservoircode.data_structures.my_linked_list;

public class MyLinkedList {
    private Node first;
    private Integer size = 0;

    public MyLinkedList() {
        first = new Node(null, null);
    }

    public void insert(Integer value) {
        size++;
        first = new Node(value, first);
    }

    public void remove() {
        size--;
        first = first.next;
    }

    public void debug() {
        Node actual = first;

        while (actual.next != null) {
            System.out.println(actual.value);
            actual = actual.next;
        }
    }

    public Integer size() {
        return size;
    }

    class Node {
        private final Integer value;
        private final Node next;

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
