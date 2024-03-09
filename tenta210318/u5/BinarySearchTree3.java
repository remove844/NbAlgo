package tenta210318.u5;

public class BinarySearchTree3 <E extends Comparable<E>> {

    private static class Node<E>{
        private E data;
        private Node<E> left,right;
        private Node(E d){
            data=d;
            left=right=null;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }

    private Node<E> root;

    public BinarySearchTree3(){
        root=null;
    }

    private void inOrder(Node<E> node, StringBuilder sb){
        if(node!=null){
            inOrder(node.left, sb);
            sb.append(node).append(" ");
            inOrder(node.right, sb);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }

    public boolean add(E data){
        if(root == null){
            root = new Node<>(data);
            return true;
        }
        return add(root, data);
    }

    private boolean add(Node<E> node, E data) {
        if (data.compareTo(node.data) == 0) {
            return false;
        } else if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
                return true;
            } else {
                return add(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(data);
                return true;
            } else {
                return add(node.right, data);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree3<String> b = new BinarySearchTree3<>();
        b.add("H");
        b.add("B");
        b.add("N");
        b.add("A");
        b.add("E");
        b.add("C");
        b.add("F");
        b.add("D");
        System.out.println(b);

    }
}