package tenta220610.u4;

import java.util.ArrayDeque;
import java.util.Queue;

public class Jump5 {
    public static class State{
        public int i, pos;

        public State(int i, int pos) {
            this.i = i;
            this.pos = pos;
        }

        public State plusJump(){
            return new State(i + 1, pos + (2*i-1));
        }
        public State minusJump(){
            return new State(i + 1, pos - (2*i-1));
        }
        public boolean canJump(){
            if(pos- (2*i-1) >= 0) return true;
            return false;
        }

    }
    public static void main(String[] args) {
        System.out.println(numberJumps(7, 3));
        System.out.println(numberJumps(1, 4));
    }

    private static int numberJumps(int start, int goal) {
        Queue<State> queue = new ArrayDeque<>();
        State currant = new State(1, start);

        while (currant.pos != goal){
            queue.offer(currant.plusJump());
            if(currant.canJump()) queue.offer(currant.minusJump());

            currant = queue.poll();
        }
        return currant.i - 1;
    }
}
