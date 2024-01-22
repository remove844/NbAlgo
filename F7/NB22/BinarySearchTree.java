package F7.NB22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>>{

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
    private E deletedData;

    public BinarySearchTree(){
        root = null;
    }

    private void inOrder(Node<E> node, StringBuilder sb){
        if(node != null){
            inOrder(node.left, sb);
            sb.append("\n: " + node.toString());
            inOrder(node.right, sb);
        }
    }

    private void inTreeOrder(Node<E> node, StringBuilder sb){
        if(node == null){
            return;
        }
        Queue<Node> b1 = new LinkedList<>();
        b1.offer(node);
        while (!b1.isEmpty()){
            int size = b1.size();
            for(int i = 0; i < size; i++){
               Node<E> temp = b1.poll();
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
        inTreeOrder(root, sb);
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

    public E delete(E target){
        root = delete(target, root);
        return deletedData;
    }

    private Node<E> delete(E target, Node<E> node){
        if(node == null){
            deletedData = null;
            return null;
        }else {
            if(target.compareTo(node.data) < 0){
                node.left = delete(target, node.left);
                return node;
            } else if (target.compareTo(node.data) > 0) {
                node.right = delete(target, node.right);
                return node;
            }else {
                deletedData = node.data;
            }
        }
        if(node.left == null){
            return node.right;
        } else if (node.right == null) {
            return node.left;
        }else {
            if(node.left.right == null){
                node.data = node.left.data;
                node.left = node.left.left;
                return node;
            }else {
                node.data = findLargestChild(node.left);
                return node;
            }
        }
    }

    private E findLargestChild(Node<E> parent){
        if(parent.right.right == null){
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        }else {
            return findLargestChild(parent.right);
        }
    }

    public void builtTree(ArrayList<E> elements){
       Collections.sort(elements);
        root = builtTreeRec(elements, 0, elements.size() -1);
    }

    private Node<E> builtTreeRec(ArrayList<E> elements, int start, int end){
        if(start > end) return null;

        int mid = (start + end) / 2;
        Node<E> node = new Node<>(elements.get(mid));

        node.left = builtTreeRec(elements, start, mid - 1);
        node.right = builtTreeRec(elements, mid + 1, end);

        return node;
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node<E> node){
        if(node == null) return;

        System.out.println(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(){
        portOrder(root);
    }
    private void portOrder(Node<E> node){
        if(node == null) return;

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.data + " ");
    }


    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Alex1");
        arrayList.add("Alex2");
        arrayList.add("Alex3");
        arrayList.add("Alex4");
        arrayList.add("Alex5");
        arrayList.add("Alex6");
        arrayList.add("Alex7");
        bst.builtTree(arrayList);
        System.out.println(bst.toString());
        System.out.println("PreOrder");
        bst.preOrder();

        System.out.println("PostOrder");
        bst.postOrder();



    }
}
