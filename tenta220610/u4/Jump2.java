package tenta220610.u4;

import java.util.ArrayDeque;
import java.util.Queue;

public class Jump2 {
    public static class State{
        public int pos, i;

        public State(int pos, int i) {
            this.pos = pos;
            this.i = i;
        }

        public State jumpUp(){
            return new State(pos + (2*i-1), i + 1);
        }

        public State jumpDown(){
            return new State(pos - (2*i-1), i + 1);
        }

        public boolean canJump(){
            return pos - (2*i-1) >= 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(numberJumps(7, 3));
        System.out.println(numberJumps(1, 4));
    }



    public static int numberJumps(int start, int goal) {
        Queue<State> queue = new ArrayDeque<>();
        State current = new State(start, 1);
        while (current.pos != goal){

            queue.offer(current.jumpUp());

            if(current.canJump()) queue.offer(current.jumpDown());

            current = queue.poll();
        }
        return current.i - 1;
    }



    private static void numberJumps(int start, int goal, int i, int[] memo){

       numberJumps(start + (2*i-1), goal, i + 1, memo );
       numberJumps(start - (2*i-1), goal, i + 1, memo );


    }
}
