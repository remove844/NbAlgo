package tenta230607.u3;

import java.util.ArrayDeque;
import java.util.Queue;

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

    public String widthFirstString(){
        Queue<Node<E>> queue = new ArrayDeque<>();
        if(root != null) queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            Node<E> current = queue.poll();
            sb.append(current.data + ", ");
            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
        }
        return sb.toString();
    }
    public static void buildTree(BinarySearchTree3<Integer> b, int[] v){
        for(int data:v)
            b.add(data);
    }

    public static void main(String[] args) {
        BinarySearchTree3<Integer> bst = new BinarySearchTree3<>();
        System.out.println(bst.widthFirstString());
        buildTree(bst,new int[] {4,2,6,1,3,5,7});
        System.out.println(bst.widthFirstString());
        bst = new BinarySearchTree3<>();
        buildTree(bst,new int[] {20,10,30,5,15,25,35,2,7,13,17,27,33,37,1,4,11,14,31,34,36,45,3,6,8,9});
        System.out.println(bst.widthFirstString());
    }
}
