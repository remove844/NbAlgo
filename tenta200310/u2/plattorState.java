package tenta200310.u2;

import java.util.ArrayDeque;
import java.util.Queue;

public class plattorState {
    public static int count1;
    public static class State{
        public int length, i;

        public State(int length, int i) {
            this.length = length;
            this.i = i;
        }

        public State four(){
            return new State(length + 4, i + 1);
        }
        public State tre(){
            return new State(length + 3, i + 1);
        }
        public State two(){
            return new State(length + 2, i + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Number of operations: " + nrOfOperations(7) + ", " + count1);
    }

    public static int nrOfOperations(int targetL){
        Queue<State> queue = new ArrayDeque<>();
        State initial = new State(0, 0);
        queue.offer(initial);

        int count = 0;

        while (!queue.isEmpty()) {
            count1++;
            State current = queue.poll();

            if (current.length == targetL) {
                count++;
            } else if (current.length < targetL) {
                queue.offer(current.two());
                queue.offer(current.tre());
                queue.offer(current.four());
            }
        }

        return count;
    }


}
