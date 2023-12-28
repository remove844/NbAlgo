package F3.NB5;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayStack<E> implements StackInt<E>{
    private ArrayList<E> data;
    private int top;
    private int maxSize;

    public ArrayStack() {
        this.data = new ArrayList<>();
    }

    @Override
    public E push(E obj) {
        data.add(obj);
        return obj;
    }

    @Override
    public E peek() {
        if(data.isEmpty()) throw new EmptyStackException();
        return data.get(data.size()-1);
    }

    @Override
    public E pop() {
        if(data.isEmpty()) throw new EmptyStackException();
        E temp = data.remove(data.size()-1);
        return temp;
    }

    @Override
    public boolean empty() {
        return data.isEmpty();
    }

    @Override
    public String toString(){
        return data.toString();
    }

    public static void main(String[] args) {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        System.out.println("Empty: " + arrayStack.empty());
        arrayStack.push("Alex1");
        arrayStack.push("Alex2");
        System.out.println("Peek: " + arrayStack.peek());
        arrayStack.push("Alex3");
        System.out.println("Poped: " + arrayStack.pop());
        System.out.println("Empty: " + arrayStack.empty());
        System.out.println(arrayStack.toString());
    }
}
