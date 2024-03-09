package tenta220610.u3;

public class BinarySearchTree<E extends Comparable<E>> {

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

    public BinarySearchTree(){
        root=null;
    }

    private String toString(Node<E> node){
        if(node!=null){
            return toString(node.left) + node + " " + toString(node.right);
        }
        return "";
    }

    @Override
    public String toString(){
        return toString(root);
    }

    public boolean add(E data){
        if(root == null) {
            root = new Node<E>(data);
            return true;
        }
        return add(root, data);
    }

    private boolean add(Node<E> node, E data){
        if(data.compareTo(node.data) == 0) return false;
        if(data.compareTo(node.data) < 0){
            if(node.left == null){
                node.left = new Node<E>(data);

                return true;
            }else {
                add(node.left, data);
            }
        }else {
            if(node.right == null){
                node.right = new Node<E>(data);
                return true;
            }else {
                add(node.right, data);
            }
        }
        return false;
    }

    public int size(){
        return size(root);
    }

    private int size(Node<E> node){
        if(node == null) return 0;
        return 1 + size(node.right) + size(node.left);
    }

    public static void buildTree(BinarySearchTree<Integer> b, int[] v){
        for(int data:v)
            b.add(data);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst= new BinarySearchTree<>();
        buildTree(bst,new int[] {30,20,40,15,35,45,37});
        System.out.println("Tree:" + bst + " Size: " + bst.size());

    }

}
