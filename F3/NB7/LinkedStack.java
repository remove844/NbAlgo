package F3.NB7;

import F3.NB5.StackInt;

import java.util.EmptyStackException;

public class LinkedStack<E> implements StackInt<E> {

    private static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E dataItem, Node<E> nodeRef) {
            this.data = dataItem;
            this.next = nodeRef;
        }
    }

    private Node<E> top;

    public LinkedStack() {
        this.top = null;
    }

    @Override
    public E push(E obj) {
        top = new Node<E>(obj, top);
        return obj;
    }

    @Override
    public E peek() {
        if(empty()){
            throw new EmptyStackException();
        }else {
            return top.data;
        }
    }

    @Override
    public E pop() {
        if(empty()){
            throw new EmptyStackException();
        }else {
            E result = top.data;
            top = top.next;
            return result;
        }
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    public int size(){
        int counter = 0;
        Node<E> temp = this.top;
        while (temp != null){
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    public E peek(int index){
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException(index);
        Node<E> temp = this.top;
        for(int i = 0; i < index;i++){
            temp = temp.next;
        }
        return temp.data;
    }

    public E flush(){
        E temp = null;
        while (!empty()){
            temp = top.data;
            top = top.next;
        }
        return temp;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> temp = this.top;
        while (temp != null){
            sb.append(temp.data).append(", ");
            temp = temp.next;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        linkedStack.push("Alex1");
        linkedStack.push("Alex2");
        linkedStack.push("Alex3");
        System.out.println(linkedStack.toString());
        System.out.println(linkedStack.peek(2));
        System.out.println(linkedStack.size());
        System.out.println(linkedStack.flush() + " last flushed");
        System.out.println(linkedStack.toString() + " flushd list");
    }
}
