package tenta230315.u5;

public class BinarySearchTree2 <E extends Comparable<E>> {
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

    public BinarySearchTree2(){
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
        if(target.compareTo(node.data) < 0){
            return find(node.left, target);
        }else {
            return find(node.right, target);
        }
    }

    public int nrOneGrandChild() {
        return nrOneGrandChild(root);
    }

    private int nrOneGrandChild(Node<E> node) {
        if(node == null) return 0;
        int count = 0;
        int leftGrandChildren = getGrandChildrenCount(node.left);
        int rightGrandChildren = getGrandChildrenCount(node.right);
        if (leftGrandChildren == 1 || rightGrandChildren == 1) count = 1;
        return count + nrOneGrandChild(node.left) + nrOneGrandChild(node.right);
    }
    private int getGrandChildrenCount(Node<E> node) {
        if (node == null) return 0;
        return nrChildren(node.left) + nrChildren(node.right);
    }

    private int nrChildren(Node<E> node){
        if(node == null) return 0;
        int child = 0;
        if(node.left != null) child++;
        if(node.right != null) child++;
        return child;
    }

    public int nrOneGrandChild2(){
        return nrOneGrandChild2(root);
    }

    private int nrOneGrandChild2(Node<E> node){
        if(node == null) return 0;
        if(countChildren(node.left) + countChildren(node.right) == 1){
            return 1 + nrOneGrandChild2(node.left) + nrOneGrandChild2(node.right);
        }
        return nrOneGrandChild2(node.left) + nrOneGrandChild2(node.right);
    }

    private int countChildren(Node<E> node){
        if(node == null) return 0;
        int children = 0;
        if(node.right != null)children++;
        if(node.left != null)children++;
        return children;
    }


    public E secondSmallest() {
        if(root == null ||(root.left == null && root.right == null)) return null;
        return secondSmallest(root);
    }

    private E secondSmallest(Node<E> node){
        if(node.left == null) return min(node.right);
        if(node.left.left == null && node.left.right == null) return node.data;
        return secondSmallest(node.left);
    }

    public E secondLargest() {
        if(root == null ||(root.left == null && root.right == null)) return null;
        return secondLargest(root);
    }

    private E secondLargest(Node<E> node){
        if(node.right == null) return max(node.left);
        if(node.right.left == null && node.right.right == null) return node.data;
        return secondLargest(node.right);
    }

    public E max(){
        return max(root);
    }

    private E max(Node<E> node){
        if(node == null) return null;
        if(node.right != null) return max(node.right);
        return node.data;
    }
    public E min(){
        return min(root);
    }

    private E min(Node<E> node){
        if(node == null) return null;
        if(node.left != null) return min(node.left);
        return node.data;
    }



    public static void buildTree(BinarySearchTree2<String> b){
        b.add("P");
        b.add("E");
        b.add("U");
        b.add("C");
        b.add("H");
        b.add("R");
        b.add("X");
        b.add("A");
        b.add("D");
        b.add("K");
        b.add("S");
        b.add("V");
        b.add("B");
        b.add("J");
        b.add("L");
        b.add("W");

    }
    public static void main(String[] args) {

        BinarySearchTree2<String> bst= new BinarySearchTree2<>();
        buildTree(bst);
        System.out.println(bst);
        System.out.println(bst.find("L"));
        System.out.println("One gchild 1: " + bst.nrOneGrandChild());
        System.out.println("One gchild 2: " + bst.nrOneGrandChild2());
        System.out.println(bst.secondSmallest());
        System.out.println(bst.secondLargest());

        BinarySearchTree2<Integer> b1 = new BinarySearchTree2<>();
        b1.add(10);
        b1.add(7);
        b1.add(14);
        b1.add(12);
        b1.add(13);
        System.out.println("Min=" + b1.min());
        System.out.println(b1.nrOneGrandChild());


    }
}
