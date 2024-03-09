package BinarySearchTree;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree2 <E extends Comparable<E>>{
    private static class Node<E>{
        E data;
        Node<E> left, right;

        public Node(E data) {
            this.data = data;
            left = right = null;
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }

    private Node<E> root;
    private int size;

    public BinarySearchTree2() {
        this.root = null;
        this.size = 0;
    }

    public boolean add(E data){
        if(root == null){
            root = new Node<E>(data);
            return true;
        }else {
            return add(root, data);
        }
    }

    private boolean add(Node<E> node, E data){
        if(data.compareTo(node.data) == 0){ // om data är lika med den data som finns gör inget
            return false;
        }else if (data.compareTo(node.data) < 0){ // om data - data som finns är mindre 0 så lägg vänster
            if(node.left == null){
                node.left = new Node<>(data);
                return true;
            }else {
                return add(node.left, data);
            }
        }else {// Om data är större än 0 så lägg höger.
            if(node.right == null){
                node.right = new Node<>(data);
                return true;
            }else {
                return add(node.right, data);
            }
        }
    }

    public String inOrder1(){
        if(root == null) return "Empty";
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private void inOrder(Node<E> node, StringBuilder sb){
        if(node != null){
            inOrder(node.left, sb);
            sb.append(node.data).append(", ");
            inOrder(node.right, sb);
        }
    }

    public String bredToString(){
        Queue<Node<E>> queue = new ArrayDeque<>();
        if(!isEmpty()) queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            Node<E> current = queue.poll();
            sb.append(current.data + " ");
            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
        }
        return sb.toString();
    }

    public E find(E data){
        if(isEmpty()) return null;
        return find(root, data);
    }

    private E find(Node<E> node, E data){
        if(node == null) return null;
        if(data.compareTo(node.data) == 0) return node.data;
        if(data.compareTo(node.data) < 0) return find(node.left, data);
        return find(node.right, data);
    }

    public E findMax(){
        if(isEmpty()) return null;
        return findMax(root);
    }
    public E findMax(Node<E> node){
        if(node.right != null) return findMax(node.right);
        return node.data;
    }

    public E findMin(){
        return findMin(root);
    }

    private E findMin(Node<E> node){
        if(root == null) return null;
        if(node.left != null) return findMin(node.left);
        return node.data;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public E secoundLargest(){
        if(root == null || (root.left == null && root.right == null)) return null;
        return secoundLargest(root);
    }

    private E secoundLargest(Node<E> node){
        if(node.right == null) return findMax(node.left);
        if(node.right.right == null && node.right.left == null) return node.data;
        return secoundLargest(node.right);
    }

    public E scoundSmallest(){
        if(root == null || root.left == null && root.right == null) return null;
        return scoundSmallest(root);
    }

    private E scoundSmallest(Node<E> node){
        if(node.left == null) return findMin(root.right);
        if(node.left.right == null && node.left.left == null) return node.data;
        return scoundSmallest(node.left);
    }

    public int nrOfNodes(){
        return nrOfNodes(root);
    }

    private int nrOfNodes(Node<E> node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 0;
        return 1 + nrOfNodes(node.left) + nrOfNodes(node.right);
    }

    public int nrOfLeavs(){
        return nrOfLeavs(root);
    }

    private  int nrOfLeavs(Node<E> node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        return nrOfLeavs(node.left) + nrOfLeavs(node.right);
    }

    public boolean fullTree(){
        return fullTree(root);
    }

    private boolean fullTree(Node<E> node){
        if(node == null || (node.right == null && node.left == null)) return true;
        if(node.right != null && node.left != null) return fullTree(node.left) && fullTree(node.right);
        return false;
    }

    public boolean completeTree(){
        if(root == null) return true;
        return completeTree(root);
    }

    private boolean completeTree(Node<E> node){
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(node);
        boolean mustHaveNoChild = false;
        while (!queue.isEmpty()){
            Node<E> currentNode = queue.remove();
            if(mustHaveNoChild && (currentNode.left != null || currentNode.right != null)) return false;
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }else {
                mustHaveNoChild = true;
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }else {
                mustHaveNoChild = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinarySearchTree2<Integer> binarySearchTree2 = new BinarySearchTree2<>();
        binarySearchTree2.add(10);
        binarySearchTree2.add(7);
        binarySearchTree2.add(14);
        binarySearchTree2.add(12);
        binarySearchTree2.add(15);
        binarySearchTree2.add(8);
        binarySearchTree2.add(6);
        System.out.println(binarySearchTree2.inOrder1());
        System.out.println(binarySearchTree2.bredToString());
        System.out.println(binarySearchTree2.find(13));
        System.out.println(binarySearchTree2.size);
        System.out.println(binarySearchTree2.findMax());
        System.out.println(binarySearchTree2.findMin());
        System.out.println(binarySearchTree2.isEmpty());
        System.out.println("secound largest: " + binarySearchTree2.secoundLargest());
        System.out.println("secound smallest: " + binarySearchTree2.scoundSmallest());
        System.out.println("nrofNodes: " + binarySearchTree2.nrOfNodes());
        System.out.println("nrofLeavs: " + binarySearchTree2.nrOfLeavs());
        System.out.println("Full: " + binarySearchTree2.fullTree());
        System.out.println("Complett: " + binarySearchTree2.completeTree());


    }
}
