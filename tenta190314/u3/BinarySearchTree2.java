package tenta190314.u3;

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
        if(root == null) return "empty";
        StringBuilder sb = new StringBuilder();
        inOder(root, sb);
        return sb.toString();
    }

    private String inOder(Node<E> node, StringBuilder sb){
        if(node != null){
            inOder(node.left, sb);
            sb.append(node.data + ", ");
            inOder(node.right, sb);
        }
        return sb.toString();
    }

    public String toString(E target) {
        if(root == null) return "empty";
        StringBuilder sb = new StringBuilder();
        inOder(find(root, target), sb);
        return sb.toString();
    }

    private Node<E> find(Node<E> node, E target){
        if(node == null) return null;
        if(target.compareTo(node.data) == 0) return node;
        if(target.compareTo(node.data) < 0) return find(node.left, target);
        return find(node.right, target);
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
        BinarySearchTree2<String> bst= new BinarySearchTree2<>();
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