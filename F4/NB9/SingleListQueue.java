package F4.NB9;

public class SingleListQueue<E> {
    private class Node<E>{
        public E data;
        public Node<E> next;

        public Node(E element) {
            this.data = element;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public SingleListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean offer(E item){
        if(front == null){
            rear = new Node<>(item);
            front = rear;
        }else {
            rear.next = new Node<>(item);
            rear = rear.next;
        }
        size++;
        return true;
    }

    public E poll(){
        E item = peek();
        if(item == null) return null;
        front = front.next;
        size--;
        return item;
    }

    public E peek(){
        if(size == 0) return null;
        return front.data;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        if(front == null) return "Queue is empty";
        StringBuilder sb = new StringBuilder();
        Node<E> f = front;
        while (f != null) {
            sb.append(f.data);
            if (f.data != null) sb.append(", ");
            f = f.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SingleListQueue<String> singleListQueue = new SingleListQueue<>();
        singleListQueue.offer("Alex1");
        singleListQueue.offer("Alex2");
        singleListQueue.offer("Alex3");
        singleListQueue.offer("Alex4");
        System.out.println(singleListQueue.toString());
        System.out.println(singleListQueue.size());
        singleListQueue.poll();
        singleListQueue.poll();
        singleListQueue.poll();
        System.out.println(singleListQueue.toString());
        System.out.println(singleListQueue.size());
        singleListQueue.poll();
        System.out.println(singleListQueue.size());
    }
}
