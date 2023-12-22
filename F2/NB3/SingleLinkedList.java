package F2.NB3;

public class SingleLinkedList<E> {
    public static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = null;
        }
        public Node() {
        }
    }
    private Node<E> head;
    private int size;

    public SingleLinkedList(){
        head = null;
        size = 0;
    }

    public void add(int index, E item){
        if(index < 0 || index > size) throw new IndexOutOfBoundsException(Integer.toString(index));
        if(index == 0){
            addFirst(item);
        }else{
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public boolean add(E item){
        add(size, item);
        return true;
    }

    public void addFirst(E item){
        head = new Node<E>(item, head);
        size++;
    }

    public void addAfter(Node<E> node, E item){
        node.next = new Node<E>(item, node.next);
        size++;
    }

    private Node<E> getNode(int index){
        Node<E> node = head;
        for(int i = 0; i < index && node != null; i++){
            node = node.next;
        }
        return node;
    }

    public E get(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException(Integer.toString(index));
        Node<E> node = getNode(index);
        return node.data;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> node = head;
        sb.append(" [ ");
        if(node != null){
            while(node != null){
                sb.append(node.data.toString());
                if(node.next != null) sb.append(" ==> ");
                node = node.next;
            }
        }
        sb.append(" ] ");
        return sb.toString();
    }

    public static void main(String[] args) {

        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addFirst("1");
        singleLinkedList.add( "löper");
        singleLinkedList.add("på");
        singleLinkedList.add("stöppen");

        System.out.println("Med på " + singleLinkedList.toString());

        singleLinkedList.getNode(1).next = singleLinkedList.getNode(3);

        System.out.println("Utan på " + singleLinkedList.toString());

        SingleLinkedList<String> halva = new SingleLinkedList<>();
        halva.head = singleLinkedList.getNode(2);
        System.out.println("Halva listan" + halva.toString());


        SingleLinkedList<String> singleLinkedList2 = new SingleLinkedList<>();
        SingleLinkedList<String> singleLinkedList3 = new SingleLinkedList<>();
        singleLinkedList2.add("Första");
        singleLinkedList2.add("Andra");
        singleLinkedList3.add("Första2");
        singleLinkedList3.add("Andra2");

        singleLinkedList2.head.next.next = singleLinkedList3.head;
        System.out.println("Två listor ihop " + singleLinkedList2.toString());

        //Endast noder
        System.out.println("\nEndast noder");

        Node<String> head = new Node<>();
        Node<String> node1 = new Node<>();
        Node<String> node2 = new Node<>();
        Node<String> node3 = new Node<>();
        Node<String> node4 = new Node<>();
        Node<String> next = head;


        Node<String> head2 = new Node<>();
        Node<String> node11 = new Node<>();
        Node<String> node22 = new Node<>();
        Node<String> next2 = head2;


        head.next = node1;
        node1.data = "Gilganesh";
        node1.next = node2;

        node2.data = "löper";
        //node2.next = node3;
        node2.next = node4;

        node3.data = "på";
        node3.next = node4;

        node4.data = "stöppen";
        //node4.next = null;
        node4.next = node11;


        head2.next = node11;
        node11.data = "Andralistan1";
        //node11.next = node22;
        node11.next = null;

        node22.data = "Andralistan2";
        node22.next = null;




        System.out.printf(" [ ");
        while (true){
            next = next.next;
            if(next == null){
                System.out.printf(" ] ");
                return;
            }
            System.out.printf(next.data);
            if(next.next != null) System.out.printf(" ==> ");
        }




    }
}
