package tenta200310.u2;

import java.util.ArrayDeque;
import java.util.Queue;

public class plattorState {
    /*public static class State{
        public int length, operations;

        public State(int length, int operations) {
            this.length = length;
            this.operations = operations;
        }

        public State fore(){
            return State(current.length - 4, current.operations + 1);


        }
    }

    public static void main(String[] args) {
        System.out.println("Number of operations: " + nrOfOperations(7));
    }

    public static int nrOfOperations(int targetL){
        Queue<State> queue = new ArrayDeque<>();
        queue.offer(new State(targetL, 0));

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.length == 1 || current.length == 0 || current.length == 2) {
                return current.operations;
            }

            queue.offer(new State(current.length - 4, current.operations + 1));
            queue.offer(new State(current.length - 3, current.operations + 1));
            queue.offer(new State(current.length - 2, current.operations + 1));
        }

        return -1;
    }

     */
}
