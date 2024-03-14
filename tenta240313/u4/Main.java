package uppgift4;

import java.util.*;

public class Main {

    private static class State{
        int position, nrOfSteps;

        public State(int position, int nrOfSteps) {
            this.position = position;
            this.nrOfSteps = nrOfSteps;
        }
    }
    static long calls, callsDyn;

    public static void main(String[] args) {
        System.out.println(minNrOfStepsA(70));
        System.out.println(minNrOfStepsB(70));
        System.out.println(minStepsWidthC(70));
    }

    private static int minNrOfStepsA(int position) {
        int result = minNrOfStepsARec(position);
        return result >= Integer.MAX_VALUE/2 ? -1 : result;
    }

    private static int minNrOfStepsARec(int position) {
        calls++;
        if(position == 1) return 0;
        if(position<1) return Integer.MAX_VALUE/2;

        int nrOfSteps;
        nrOfSteps = minNrOfStepsARec(position-7);
        if(position%7 == 0) nrOfSteps = Math.min(nrOfSteps, minNrOfStepsARec(position-20));
        if(position%5 == 0) nrOfSteps = Math.min(nrOfSteps, minNrOfStepsARec(position-16));
        if(position%2 == 0) nrOfSteps = Math.min(nrOfSteps, minNrOfStepsARec(position/2));

        return nrOfSteps + 1;
    }

    private static int minNrOfStepsB(int position) {
        int[] memo = new int[position+1];
        Arrays.fill(memo,-1);
        memo[1] = 0;
        int result = minNrOfStepsB(position, memo);
        return result >= Integer.MAX_VALUE/2 ? -1 : result;
    }

    private static int minNrOfStepsB(int position, int[] memo) {
        callsDyn++;
        if(position<1) return Integer.MAX_VALUE/2;
        if(memo[position]!=-1) return memo[position];

        int nrOfSteps;
        nrOfSteps = minNrOfStepsB(position-7, memo);
        if(position%7 == 0) nrOfSteps = Math.min(nrOfSteps, minNrOfStepsB(position-20, memo));
        if(position%5 == 0) nrOfSteps = Math.min(nrOfSteps, minNrOfStepsB(position-16, memo));
        if(position%2 == 0) nrOfSteps = Math.min(nrOfSteps, minNrOfStepsB(position/2, memo));

        return memo[position] = nrOfSteps + 1;
    }

    private static int minStepsWidthC(int position){
        Queue<State> que = new ArrayDeque<>();
        State currentState;
        que.offer(new State(position,0));
        while(!que.isEmpty()){
            calls++;
            currentState = que.poll();
            if(currentState.position==1) return currentState.nrOfSteps;
            if(currentState.position<1) continue;
            if(currentState.position%7 == 0) que.offer(new State(currentState.position-20, currentState.nrOfSteps+1));
            if(currentState.position%5 == 0) que.offer(new State(currentState.position-16, currentState.nrOfSteps+1));
            if(currentState.position%2 == 0) que.offer(new State(currentState.position/2, currentState.nrOfSteps+1));
            que.offer(new State(currentState.position-7, currentState.nrOfSteps+1));
        }
        return -1;
    }

    private static int minStepsWidth2(int position){
        Queue<State> que = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        State currentState;
        que.offer(new State(position,0));
        set.add(position);
        while(!que.isEmpty()){
            callsDyn++;
            currentState = que.poll();
            if(currentState.position==1) return currentState.nrOfSteps;
            if(currentState.position<1) continue;
            if(currentState.position%7 == 0 && set.add(currentState.position-20)){
                que.offer(new State(currentState.position-20, currentState.nrOfSteps+1));
            }
            if(currentState.position%5 == 0 && set.add(currentState.position-16)){
                que.offer(new State(currentState.position-16, currentState.nrOfSteps+1));
            }
            if(currentState.position%2 == 0 && set.add(currentState.position/2)){
                que.offer(new State(currentState.position/2, currentState.nrOfSteps+1));
            }
            if(set.add(currentState.position-7)){
                que.offer(new State(currentState.position-7, currentState.nrOfSteps+1));
            }
        }
        return -1;
    }
    private static String minPath(int position) {
        String path = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        if(position == 1) return "";
        if(position<1) return path;

        if(position%7 == 0) path = "a"+minPath(position-20);
        if(position%5 == 0) path = min(path,"b"+minPath(position-16));
        if(position%2 == 0) path = min(path,"c"+minPath(position/2));
        path = min(path,"d"+minPath(position-7));
        return path;
    }

    private static String min(String s1, String s2){
        return s1.length()<s2.length() ? s1 : s2;
    }
}
