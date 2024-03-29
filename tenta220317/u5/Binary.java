package tenta220317.u5;

import tenta210318.u5.BinarySearchTree;

public class Binary<E extends Comparable<E>> {
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
    public Binary(){
        root = null;
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

    @Override
    public String toString(){
        return toString(root);
    }

    private String toString(Node<E> node){
        if(node != null){
            return toString(node.left) + node + " " + toString(node.right);
        }
        return "";
    }

    public boolean isBalanced(){
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

    public E secondLargest(){
        if(root == null) return null;
        if(root.left == null && root.right == null) return null;
        return secondLargest(root);
    }

    private E secondLargest(Node<E> node){
        if(node.right == null) return max(node.left);
        if(node.right.right == null && node.right.left == null) return node.data;
        return secondLargest(node.right);
    }

    private E max(Node<E> node){
        if(node == null) return null;
        if(node.right == null) return node.data;
        return max(node.right);
    }

    public static void main(String[] args) {
        Binary<Integer> binary = new Binary<>();
        binary.add(4);
        binary.add(2);
        binary.add(5);
        binary.add(1);
        binary.add(3);
        binary.add(7);
        System.out.println(binary.toString());
        System.out.println(binary.secondLargest());

    }

}
