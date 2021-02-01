package net.reservoircode.data_structures.my_linkedlist;

public class MyLinkedList<T> {
    private Node<T> head;
    private Integer size = 0;

    public MyLinkedList() {
        head = new Node<>(null, null);
    }

    public void add(T value) {
        size++;
        head = new Node<>(value, head);
    }

    public T removeLast() {
        size--;
        T removedElement = this.head.value;
        head = head.next;
        return removedElement;
    }

    public T getLast() {
        return head.value;
    }

    public Integer size() {
        return size;
    }

    private static class Node<T> {
        private final T value;
        private final Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
