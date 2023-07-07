package uz.friday;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class DoublyLinkedList<E> implements Iterable<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size;

    public boolean add(E element) {
        var last = tail;
        var newNode = new Node<E>(element);
        tail = newNode;
        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
        size++;
        return true;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        if (index == 0)
            return head.element;

        Node<E> current = null;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.element;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current.element;
        }
    }

    private static class Node<E> {

        E element;

        Node<E> prev;

        Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }

    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        this.forEach(h -> sj.add(String.valueOf(h)));
        return sj.toString();
    }

}
