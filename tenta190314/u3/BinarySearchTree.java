package tenta190314.u3;

public class BinarySearchTree <E extends Comparable<E>> {

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

    @Override
    public String toString(){
        if(root == null) return "Empty";
        StringBuilder sb = new StringBuilder();
        return inOrder(root, sb);
    }

    private String inOrder(Node<E> node, StringBuilder sb){
        if(node != null){
            inOrder(node.left, sb);
            sb.append(node.data + ", ");
            inOrder(node.right, sb);
        }
        return sb.toString();
    }

    public String toString(E target) {
        StringBuilder sb = new StringBuilder();
        inOrder(find(target, root), sb);
        return sb.toString();
    }

    private Node<E> find(E target, Node<E> node){
        if(node == null) return null;
        if(target.compareTo(node.data) == 0) return node;
        if(target.compareTo(node.data) < 0) return find(target, node.left);
        return find(target, node.right);
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

    public static void main(String[] args) {
        BinarySearchTree<String> bst= new BinarySearchTree<>();
        bst.add("H");
        bst.add("B");
        bst.add("N");
        bst.add("A");
        bst.add("E");
        bst.add("C");
        bst.add("F");
        bst.add("D");
        System.out.println(bst.toString());//ger A B C D E F H N
        System.out.println(bst.toString("B"));//ger A B C D E F, OBS rita trädet på papper!
        System.out.println(bst.toString("E"));//ger C D E F
    }
}