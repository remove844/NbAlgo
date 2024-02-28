package tenta210318.u5;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E> {
        private E data;
        private Node<E> left, right;

        private Node(E d) {
            data = d;
            left = right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node).append(" ");
            inOrder(node.right, sb);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<>(data);
            return true;
        } else {
            return add(data, root);
        }
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0) {
            return false;
        } else if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
                return true;
            } else {
                add(data, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(data);
                return true;
            } else
                return add(data, node.right);
        }
        return false;
    }

    public E find(E data){
        return find(data, root);
    }

    private E find(E data, Node<E> node){
        if(node == null) return null;
        if(data.compareTo(node.data) == 0) return node.data;
        if(data.compareTo(node.data) < 0) return find(data, node.left);
        return find(data, node.right);
    }


    public static void main(String[] args) {
        BinarySearchTree<String> b = new BinarySearchTree<>();
        b.add("H");
        b.add("B");
        b.add("N");
        b.add("A");
        b.add("E");
        b.add("C");
        b.add("F");
        b.add("D");
        System.out.println(b);
        System.out.println(b.find("G"));
    }
}
