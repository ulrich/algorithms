package net.reservoircode.data_structures.my_linkedlist;

public class MyLinkedList<T> {

    private Node<T> first, last;
    private Integer size = 0;

    public void add(T value) {
        if (size == 0) {
            first = new Node<>(value, null, null);
        } else {
            Node<T> current = new Node<>(value, first, null);

            last = current;
        }
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("No element available");
        }
        if (first.next == null) {
            T value = first.value;
            first = null;
            size--;
            return value;
        }
        Node<T> current = first;

        while (current.next != null) {
            current = current.next;
        }
        final T value = current.value;
        current = null;
        size--;
        return value;
    }

    public T removeLast() {
        if (size == 0) {
            throw new IllegalStateException("No element available");
        }
        T value = first.value;
        first = first.next;
        size--;
        return value;
    }

    public T getLast() {
        return first.value;
    }

    public Integer size() {
        return size;
    }

    private static class Node<T> {
        private final T value;
        private Node<T> prev;
        private Node<T> next;

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
