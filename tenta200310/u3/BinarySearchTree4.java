package tenta200310.u3;

import javax.swing.*;

public class BinarySearchTree4 <E extends Comparable<E>> {

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

    public BinarySearchTree4(){
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


    public int nrNodesNotLeaves(){
        return nrNodesNotLeaves(root);
    }

    private int nrNodesNotLeaves(Node<E> node){
        if(node == null || node.left == null && node.right == null) return 0;
        return 1 + nrNodesNotLeaves(node.left) + nrNodesNotLeaves(node.right);
    }

    public E findClosestEqualOrLarger(E target) {
        return findClosestEqualOrLarger(root, target);
    }
    private E findClosestEqualOrLarger(Node<E> node, E target){
        if(node == null) return null;
        if(target.compareTo(node.data) < 0) return findClosestEqualOrLarger(node.left, target);
        if(target.compareTo(node.data) == 0) return node.data;
        E leftData = findClosestEqualOrLarger(node.right, target);
        if(leftData == null) return node.data;
        if(target.compareTo(leftData) >= 0) return leftData;
        return node.data;
    }
    public static void buildTree(BinarySearchTree4<Integer> b){
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
        BinarySearchTree4<Integer> bst= new BinarySearchTree4<>();
        buildTree(bst);
        System.out.println(bst);
        for(int i=0;i<19;i++){
            System.out.println("find "+i+" :"+bst.find(i));
            System.out.println("find closest equal or larger to "+i+" :"+bst.findClosestEqualOrLarger(i));
        }
        System.out.println("Nr nodes not leaves: "+bst.nrNodesNotLeaves());
    }
}