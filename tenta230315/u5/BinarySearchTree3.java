package tenta230315.u5;

public class BinarySearchTree3<E extends Comparable<E>> {
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
            sb.append(": ").append(node);
            inOrder(node.right, sb);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }


    private boolean add(E data,Node<E> node){
        if(data.compareTo(node.data)==0)
            return false;
        else if(data.compareTo(node.data)<0)
            if(node.left==null){
                node.left = new Node<>(data);
                return true;
            }else
                return add(data,node.left);
        else
        if(node.right==null){
            node.right = new Node<>(data);
            return true;
        }else
            return add(data,node.right);
    }
    public boolean add(E data){
        if(root==null){
            root = new Node<>(data);
            return true;
        }else{
            return add(data,root);
        }
    }

    public E find(E target){
        return find(root, target);
    }

    private E find(Node<E> node, E target){
        if(node == null) return null;
        if(target.compareTo(node.data) == 0) return node.data;
        if(target.compareTo(node.data) < 0) return find(node.left, target);
        return find(node.right, target);
    }


    public int nrOneGrandChild() {
        return nrOneGrandChild(root);
    }

    private int nrOneGrandChild(Node<E> node){
        if(node == null) return 0;
        if(countChildren(node.left) == 1) return 1 + nrOneGrandChild(node.left);
        if(countChildren(node.right) == 1) return 1 + nrOneGrandChild(node.right);
        return nrOneGrandChild(node.left) + nrOneGrandChild(node.right);
    }

    private int countChildren(Node<E> node){
        if(node == null) return 0;
        int children = 0;
        if(node.left != null) children++;
        if(node.right != null) children++;
        return children;
    }


    public E secondSmallest() {
        if(root == null) return null;
        if(root.left == null && root.right == null) return null;
        return secondSmallest(root, null);
    }

    private E secondSmallest(Node<E> node, Node<E> previous){
        if(node.left == null) return min(node.right);
        if(node.left == null && node.right == null) return previous.data;
        return secondSmallest(node.left, node);
    }

    private E min(Node<E> node){
        if(node.left == null) return node.data;
        return min(node.left);
    }



    public static void buildTree(BinarySearchTree3<String> b){
        b.add("P");
        b.add("E");
        b.add("U");
        //b.add("C");
        b.add("H");
        b.add("R");
        b.add("X");
        //b.add("A");
        //b.add("D");
        b.add("K");
        b.add("S");
        b.add("V");
        //b.add("B");
        b.add("J");
        b.add("L");
        b.add("W");

    }
    public static void main(String[] args) {

        BinarySearchTree3<String> bst= new BinarySearchTree3<>();

        buildTree(bst);
        System.out.println(bst);
        System.out.println(bst.find("L"));
        System.out.println(bst.nrOneGrandChild());
        System.out.println(bst.secondSmallest());


    }

}