package F4.NB10;

public class DubleLinkQueue<E> {
    public class Node <E>{
        public E data;
        public Node <E> next;
        public Node<E> prev;

        public Node(E element) {
            data = element;
        }
    }
    private Node <E> front;
    private Node <E> rear;
    private int size;

    public DubleLinkQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public E pollFirst(){
        if(front == null) return null;
        E temp = front.data;
        front = front.next;
        size--;
        return temp;
    }

    public E pollLast(){
        if(rear == null) return null;
        E temp = rear.data;
        Node<E> tempNode = rear.prev;
        tempNode.next = null;
        rear.prev = null;
        rear = tempNode;
        size--;
        return temp;
    }

    public boolean offerFirst(E item){
        if(rear == null){
            front = new Node<>(item);
            rear = front;
        }else {
            Node<E> temp = front;
            front.prev = new Node<>(item);
            front = front.prev;
            front.next = temp;
        }
        size++;
        return true;
    }

    public boolean offerLast(E item){
        if(front == null){
            rear = new Node<>(item);
            front = rear;
        }else {
            Node<E> temp = rear;
            rear.next = new Node<>(item);
            rear = rear.next;
            rear.prev = temp;
        }
        size++;
        return true;
    }

    public boolean empty(){
        if(rear == null || front == null) return true;
        return false;
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
        DubleLinkQueue<String> dubleLinkQueue = new DubleLinkQueue<>();
        dubleLinkQueue.offerLast("Alex1");
        dubleLinkQueue.offerLast("Alex2");
        dubleLinkQueue.offerLast("Alex3");
        dubleLinkQueue.pollFirst();
        dubleLinkQueue.pollLast();
        System.out.println(dubleLinkQueue.toString());
        dubleLinkQueue.pollFirst();
        System.out.println(dubleLinkQueue.empty());



    }
}
