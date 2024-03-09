package tenta210610.u5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E> {

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }

    private class Itr implements Iterator<E> {

        Node<E> start;
        public Itr(Node<E> start) {
            this.start = start;
        }


        @Override
        public boolean hasNext() {
            return start != null;
        }

        @Override
        public E next() {
            if(start == null) throw new NoSuchElementException();
            E returnValue = start.data;
            start = start.next;
            return returnValue;
        }

        //Skriv kod här
        @Override
        public void remove() {
            //Behöver inte implementeras
            throw new UnsupportedOperationException();
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new Itr(head);
    }

    public Iterator<E> iterator(int index) {
        if(index >= size) throw new IndexOutOfBoundsException();
        Node<E> temp = head;
        for(int i = 0; i < index; i++){
             temp = temp.next;
        }
        return new Itr(temp);
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
        head = new Node<>(item, head);
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
        node.next = new Node<>(item, node.next);
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public boolean add(E item) {
        add(size, item);
        return true;
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

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        for (int i = 0; i < 7; i++)
        {
            list.add("e" + i);
        }
        //uppgift 5a
        for(String d:list)
        {
            System.out.println(d);
        }

        //uppgift 5b
        Iterator<String> iter = list.iterator(3);
        while(iter.hasNext())
            System.out.println(iter.next());
    }
}

