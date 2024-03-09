package tenta220317.u5;

public class BinarySearchTree2<E extends Comparable<E>> {

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

    @Override
    public String toString(){
        if(root == null) return "Empty";
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private String inOrder(Node<E> node, StringBuilder sb){
        if(node != null){
            inOrder(node.left, sb);
            sb.append(node.data + ", ");
            inOrder(node.right, sb);
        }
        return sb.toString();
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node<E> node){
        if(node == null) return true;
        if(Math.abs(height(node.left) - height(node.right)) > 1) return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private int height(Node<E> node){
        if(node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
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
    public static void buildTree(BinarySearchTree2<Integer> b, int[] v){
        for(int data:v)
            b.add(data);
    }
    public static void main(String[] args) {

        BinarySearchTree2<Integer> bst= new BinarySearchTree2<>();
        System.out.println("Tree:" + bst +" balanced: " + bst.isBalanced());
        buildTree(bst,new int[] {30,20,40,15,35,45,37});
        System.out.println("Tree:" + bst + " balanced: " + bst.isBalanced());
    }
}
