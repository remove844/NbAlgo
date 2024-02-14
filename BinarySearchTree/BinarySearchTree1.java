package BinarySearchTree;

import lombok.Data;
import lombok.NonNull;

public class BinarySearchTree1<E extends Comparable<E>> {
    @Data
    private static class Node<E>{
        @NonNull private E data;
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
    public BinarySearchTree1(){
        root = null;
    }

    public BinarySearchTree1<E> insert(E data){
        root = insert(data, root);
        return this;
    }

    private Node<E> insert(E data, Node<E> node){
        if(node == null) return new Node<>(data);
        if(data.compareTo(node.getData()) < 0){
            node.setLeft(insert(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(insert(data, node.getRight()));
        }
        return node;
    }


    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node<E> node){
        if(node != null){
            traverseInOrder(node.getLeft());
            System.out.println(node);
            traverseInOrder(node.getRight());
        }
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node<E> node){
        if(node != null){
            System.out.println(node);
            traverseInOrder(node.getLeft());
            traverseInOrder(node.getRight());
        }
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node<E> node){
        if(node != null){
            traverseInOrder(node.getLeft());
            traverseInOrder(node.getRight());
            System.out.println(node);
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public E findMin(){
        if(isEmpty()) return null;
        return findMin(root);
    }

    private E findMin(Node<E> node){
        if(node.getLeft() != null){
            return findMin(node.getLeft());
        }
        return node.getData();
    }

    public E findMax(){
        if(isEmpty()) return null;
        return findMax(root);
    }

    private E findMax(Node<E> node){
        if(node.getRight() != null){
            return findMax(node.getRight());
        }
        return node.getData();
    }

    public void delete(E data){
        root = delete(data, root);
    }
    private Node<E> delete(E data, Node<E> node){
        if(node == null) return null;
        if(data.compareTo(node.getData()) < 0){
            node.setLeft(delete(data, node.getLeft()));
        }else if (data.compareTo(node.getData()) > 0){
            node.setRight(delete(data, node.getRight()));
        }else {
            if(node.getLeft() == null){
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            node.setData(findMax(node.getLeft()));
            node.setLeft(delete(node.getData(), node.getLeft()));
        }
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree1<Integer> b1 = new BinarySearchTree1<>();
        b1.insert(10);
        b1.insert(6);
        b1.insert(15);
        b1.delete(15);
        System.out.println("In order");
        b1.traverseInOrder();
        System.out.println("Post order");
        b1.traversePostOrder();
        System.out.println("Pre order");
        b1.traversePreOrder();
        System.out.println("Find Max");
        System.out.println(b1.findMax());
        System.out.println("Find Min");
        System.out.println(b1.findMin());
    }

}
