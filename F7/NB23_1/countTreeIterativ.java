package F7.NB23_1;

import java.util.LinkedList;
import java.util.Queue;

public class countTreeIterativ<E extends Comparable<E>>{
    private static class Node<E>{
        private E data;
        private Node<E> left, right;
        private Node(E d){
            this.data = d;
            this.left=this.right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<E> root;

    public countTreeIterativ(){
        root = null;
    }

    private void inOrder(Node<E> node, StringBuilder sb){
        if(node != null){
            inOrder(node.left, sb);
            sb.append("\n: " + node);
            inOrder(node.right, sb);
        }
    }

    private void inTreeOrder(StringBuilder sb){
        if(root == null){
            return;
        }
        Queue<Node> b1 = new LinkedList<>();
        b1.offer(root);
        while (!b1.isEmpty()){
            int size = b1.size();
            for(int i = 0; i < size; i++){
                Node temp = b1.poll();
                if (temp == null) {
                    sb.append("null ");
                } else {
                    b1.add(temp.left);
                    b1.add(temp.right);
                    sb.append(temp.data + " ");
                }
            }
            sb.append("\n");
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        inTreeOrder(sb);
        return sb.toString();
    }

    private boolean add(E data, Node<E> node){
        if(data.compareTo(node.data) == 0){
            return false;
        }else if (data.compareTo(node.data) < 0) {
            if(node.left == null){
                node.left = new Node<E>(data);
                return true;
            }else {
                return add(data, node.left);
            }
        }else {
            if(node.right == null){
                node.right = new Node<E>(data);
                return true;
            }else {
                return add(data, node.right);
            }
        }
    }

    public boolean add(E data){
        if(root == null){
            root = new Node<E>(data);
            return true;
        }else {
            return add(data, root);
        }
    }

    public int numberOfLeaves() {
        return numberOfLeaves(root);
    }

    private int numberOfLeaves(Node<E> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return numberOfLeaves(node.left) + numberOfLeaves(node.right);
    }

    public int numberOfNodes() {
        return numberOfNodes(root);
    }

    private int numberOfNodes(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
    }

    private E find(E target, Node<E> node){
        if(node == null){
            return null;
        }
        if(target.compareTo(node.data) == 0){
            return node.data;
        }
        if(target.compareTo(node.data) < 0){
            return find(target, node.left);
        }
        return find(target, node.right);
    }

    public E find(E target){
        return find(target, root);
    }

    private E findIterativ(E target){
        for(Node<E> curr = root; curr != null; ){
            if(target.compareTo(curr.data) == 0){
                return curr.data;
            }else if(target.compareTo(curr.data) < 0){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        return null;
    }

    private E maxRec(Node<E> node) {
        if (node.right == null) {
            return node.data;
        } else {
            return maxRec(node.right);
        }
    }

    public E maxRec() {
        if (root == null) {
            return null;
        }
        return maxRec(root);
    }

    public E maxIt() {
        if (root == null) {
            return null;
        }
        Node<E> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }


    public static void main(String[] args) {
        countTreeIterativ<String> b1 = new countTreeIterativ<>();
        b1.add("H");
        b1.add("B");
        b1.add("N");
        b1.add("A");
        b1.add("E");
        b1.add("C");
        b1.add("F");
        b1.add("D");
        System.out.println(b1);
        System.out.println(b1.numberOfLeaves());
        System.out.println(b1.numberOfNodes());
        System.out.println(b1.findIterativ("G"));

        System.out.println(b1.maxRec());
        System.out.println(b1.maxIt());
    }


}
