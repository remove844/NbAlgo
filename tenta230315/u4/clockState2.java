package tenta230315.u4;

import java.util.ArrayDeque;
import java.util.Queue;

public class clockState2 {
    public static int count;
    public static class State{
        public int pos, i;

        public State(int pos, int i) {
            this.pos = pos;
            this.i = i;
        }

        public State jumpSeven(){
            return new State((pos + 7)%12 , i + 1);
        }
        public State jumpTen(){
            return new State((pos + 10)%12 , i + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Antal: " + nrOfPushes(1,4) + ", " + count);
        System.out.println("Antal: " + nrOfPushes(12,11) + ", " + count);
        System.out.println("Antal: " + nrOfPushes(8,12) + ", " + count);
    }

    private static int nrOfPushes(int startTime, int endTime) {
        Queue<State> queue = new ArrayDeque<>();
        State current = new State(startTime, 0);

        while (current.pos != endTime%12){
            count++;
            queue.offer(current.jumpSeven());
            queue.offer(current.jumpTen());
            current = queue.poll();
        }
        return current.i;
    }

}
