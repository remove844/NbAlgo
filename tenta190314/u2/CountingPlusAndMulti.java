package tenta190314.u2;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountingPlusAndMulti {
    public static int count;
    private static class State{
        public int pos, i;
        public State(int pos, int i) {
            this.pos = pos;
            this.i = i;
        }
        public State plus(){
            return new State(pos + 4, i +1);
        }
        public State multi(){
            return new State(pos * 3, i +1);
        }
    }
    public static void main(String[] args) {
        System.out.println(counting(57) + ", " + count);
        count = 0;
        System.out.println(counting2(57) + ", " + count);
        count = 0;
    }
    public static int counting(int goal){
        return counting(goal, 1);
    }
    private static int counting(int goal, int sum){
        count++;
        if(sum > goal) return -1;
        if(sum == goal) return 0;
        int multi = counting(goal, sum * 3);
        int plus = counting(goal, sum + 4);
        if (multi == -1 && plus == -1) return -1;
        if(multi == -1) return 1 + plus;
        if(plus == -1) return 1 + multi;
        return 1 + Math.min(multi, plus);
    }
    public static int counting2(int goal){
        Queue<State> queue = new ArrayDeque<>();
        State current = new State(1, 1);
        while (current.pos != goal){
            count++;
            queue.offer(current.plus());
            queue.offer(current.multi());
            current = queue.poll();
        }
        return current.i - 1;
    }
}
