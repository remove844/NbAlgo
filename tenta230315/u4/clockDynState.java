package tenta230315.u4;

import java.util.ArrayDeque;
import java.util.Queue;

public class clockDynState {
    public static int count = 0;
    public static void main(String[] args) {
        System.out.println("Antal: " + clock(1,4) + ", " + count);
        count = 0;
        System.out.println("Antal: " + clock(12,11) + ", " + count);
        count = 0;
        System.out.println("Antal: " + clock(8,12) + ", " + count);
        count = 0;
    }
    private static class State{
        public int pos, i;
        public State(int pos, int i) {
            this.pos = pos;
            this.i = i;
        }
        public State seven(){
            return new State(((pos + 7)%12), i+1);
        }
        public State ten(){
            return new State(((pos + 10)%12), i+1);
        }
    }

    public static int clock(int start, int goal){
        //goal%=12;
        Queue<State> queue = new ArrayDeque<>();
        State current = new State(start, 1);
        while (current.pos != goal%12){
            count++;
            queue.offer(current.seven());
            queue.offer(current.ten());
            current = queue.poll();
        }
        return current.i-1;
    }

}
