package tenta210318.u4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BiggestSum {
    public static int count = 0;
    public static void main(String[] args) {
        int[] v={1,2,0,-2,4,-3,-7,6,-2,-5,8,1,2,5};
        int[] w={-2,-3,5,-3,7,3,-8,5,-6,9,-2,7,0,-5,0,-3,-4,-5,1,5,-6,7,-8,9,-3,2,-5,7,3,7,8,-3,5,8,-1};
        System.out.println(largestSum(v) + ", count = "  + count);
        count = 0;
        System.out.println(largestSum(w) + ", count = "  + count);
        count = 0;
        System.out.println(largestSumD(v) + ", count = "  + count);
        count = 0;
        System.out.println(largestSumD(w) + ", count = "  + count);
        count = 0;
        System.out.println(largestSumT(v) + ", count = "  + count);
        count = 0;
        System.out.println(largestSumT(w) + ", count = "  + count);
        count = 0;
    }

    public static int largestSum(int[] nrArr){
        return largestSum(nrArr, 0, 0);
    }

    private static int largestSum(int[] nrArr, int i, int points){
        count++;
        if(nrArr.length <= i) return points;
        int tre = largestSum(nrArr, i + 3, nrArr[i] + points);
        int five = largestSum(nrArr, i + 5, nrArr[i] + points);

        return Math.max(tre, five);
    }

    public static int largestSumD(int[] nrArr){
        int[] memo = new int[nrArr.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return largestSumD(nrArr, 0, memo);
    }

    private static int largestSumD(int[] nrArr, int i, int[] memo){
        count++;
        if(nrArr.length - 1 < i) return 0;
        if(memo[i] < Integer.MAX_VALUE) return memo[i];

        int tre = largestSumD(nrArr, i + 3, memo);
        int five = largestSumD(nrArr, i + 5, memo);

        return memo[i] = nrArr[i] + Math.max(tre, five);
    }

    public static int largestSumT(int[] nrArr) {
        Queue<State> queue = new ArrayDeque<>();
        State initial = new State(0, 0);
        queue.offer(initial);
        int maxSum = 0;

        while (!queue.isEmpty()) {
            count++;
            State current = queue.poll();

            // If the current position is within the array bounds, update the sum.
            if (current.pos < nrArr.length) {
                current.sum += nrArr[current.pos];
            }

            // Check if the current state is a terminal state.
            if (current.pos >= nrArr.length - 3) {
                maxSum = Math.max(maxSum, current.sum);
            } else {
                // Otherwise, enqueue the next possible states.
                if (current.pos + 3 < nrArr.length) {
                    queue.offer(new State(current.pos + 3, current.sum));
                }
                if (current.pos + 5 < nrArr.length) {
                    queue.offer(new State(current.pos + 5, current.sum));
                }
            }
        }

        return maxSum;
    }


    private static class State{
        public int pos, sum;

        public State(int pos, int sum) {
            this.pos = pos;
            this.sum = sum;
        }

        public State goTre(int[] nrArr){
            if(pos + 3 < nrArr.length){
                return new State(pos + 3, sum + nrArr[pos + 3]);
            }
            return null;
        }

        public State goFive(int[] nrArr){
            if(pos + 5 < nrArr.length){
                return new State(pos + 5, sum + nrArr[pos + 5]);
            }
            return null;
        }

    }
}
