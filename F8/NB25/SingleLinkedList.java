package F8.NB25;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E>implements Iterable<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }

    public Iterator<E> iterator() {
        return new Itr(head);
    }

    public boolean add(E item) {
        add(size, item);
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    private class Itr implements Iterator<E> {
        Node<E> current, prev, prevPrev;

        public Itr(Node<E> start) {
            current = start;
            prev = prevPrev = null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E returnValue = current.data;
            prevPrev = prev;
            prev = current;
            current = current.next;

            return returnValue;
        }

        @Override
        public void remove() {
            if (prev == null) {
                throw new UnsupportedOperationException("Prev is null");
            }
            if (prevPrev == null) {
                head = current;
            } else {
                prevPrev.next = current;
            }
            prev = prevPrev;
        }

        public Iterator<E> iterator() {
            return new Itr(head);
        }
    }
    public void remove(E element) {

        Iterator<E> itr= this.iterator();
        while (itr.hasNext()) {
            E nextE = itr.next();
            if (nextE.equals(element)) itr.remove();
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

}
