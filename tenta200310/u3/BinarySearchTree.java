package tenta200310.u3;

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
    private E deletedData;

    public BinarySearchTree(){
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
        return find(target, root);
    }

    private E find(E target, Node<E> node){
        if(node == null) return null;
        if(target.compareTo(node.data) == 0) return node.data;
        if(target.compareTo(node.data) < 0) return find(target, node.left);
        return find(target, node.right);
    }


    public int nrNodesNotLeaves(){
        return nrNodesNotLeaves(root);
    }

    private int nrNodesNotLeaves(Node<E> node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 0;
        return 1 + nrNodesNotLeaves(node.left) + nrNodesNotLeaves(node.right);
    }

    public int nrLeavesNotNodes(){
        return nrLeavesNotNodes(root);
    }

    private int nrLeavesNotNodes(Node<E> node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        return nrLeavesNotNodes(node.left) + nrLeavesNotNodes(node.right);
    }

    public E findClosestEqualOrLarger(E target) {
        return findClosestEqualOrLarger(target, root);
    }

    private E findClosestEqualOrLarger(E target, Node<E> node){
        if(node == null) return null;
        if(target.compareTo(node.data) > 0) return findClosestEqualOrLarger(target, node.right);
        if(target.compareTo(node.data) == 0) return node.data;
        E leftData = findClosestEqualOrLarger(target, node.left);
        if(leftData == null) return node.data;
        if(target.compareTo(leftData) <= 0) return leftData;
        return node.data;
    }

    public void inOrder2(){
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        System.out.println(sb.toString());

    }

    private void inOrder2(Node<E> node, StringBuilder sb){
        if(node != null){
            inOrder(node.left, sb);
            sb.append(node.data).append(" ");
            inOrder(node.right, sb);
        }
    }


    public static void buildTree(BinarySearchTree<Integer> b){
        b.add(10);
        b.add(5);
        b.add(15);
        b.add(2);
        b.add(8);
        b.add(12);
        b.add(17);
        b.add(3);
        b.add(7);
        b.add(11);
        b.add(14);
    }
    public static void main(String[] args) {


        BinarySearchTree<Integer> bst= new BinarySearchTree<>();
        buildTree(bst);
        System.out.println(bst);
        bst.inOrder2();

        System.out.println("Nr leaves not nodes: "+bst.nrLeavesNotNodes());
        System.out.println("Nr nodes not leaves: "+bst.nrNodesNotLeaves());

        /*
        for(int i=0;i<19;i++){
            System.out.println("find "+i+" :"+bst.find(i));
            System.out.println("find closest equal or larger to "+i+" :"+bst.findClosestEqualOrLarger(i));
        }
        */

    }

}
