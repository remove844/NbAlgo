package F7.NB22_1;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTree <E extends Comparable<E>>{
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

    public PrintTree(){
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

    public static void main(String[] args) {
        PrintTree<String> b1 = new PrintTree<>();
        b1.add("H");
        b1.add("B");
        b1.add("N");
        b1.add("A");
        b1.add("E");
        b1.add("C");
        b1.add("F");
        b1.add("D");
        System.out.println(b1);
    }
}
