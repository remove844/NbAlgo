package tenta220610.u4;

import java.util.ArrayDeque;
import java.util.Queue;

public class Jump {

    private static class State{
        public int pos, i;

        public State(int pos, int i) {
            this.pos = pos;
            this.i = i;
        }
        public State high(){
            return new State(pos + (2*i-1), i+1);
        }
        public State low(){
            return new State(pos - (2*i-1), i+1);
        }
        public boolean canJump(){
            return pos-(2*i-1) >= 0;
        }
    }
    public static int jump(int start, int goal){
        Queue<State> queue = new ArrayDeque<>();
        State current = new State(start, 1);
        while (current.pos != goal){
            queue.offer(current.high());

            if(current.canJump()) queue.offer(current.low());

            current = queue.poll();
        }
        return current.i-1;
    }

    public static void main(String[] args) {
        System.out.println(jump(7, 3));
        System.out.println(jump(1, 4));
    }
}
