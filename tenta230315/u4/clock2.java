package tenta230315.u4;

import java.util.Arrays;

public class clock2 {
    public static int count = 0;
    public static void main(String[] args) {
        System.out.println(clockD(1, 4) + ", " + count);
    }
    public static int clockD(int start, int end){
        int[] memo = new int[12];
        Arrays.fill(memo, -1);
        memo[end%12] = 0;
        return clockD(start%12, end%12, 0 , memo);
    }

    private static int clockD(int start, int end, int moves, int[] memo){
        count++;
        if(memo[start] != -1) return memo[start];
        if(moves == 15) return Integer.MAX_VALUE;

        int seven = clockD((start + 7)%12 ,end, moves + 1, memo);
        int ten = clockD((start + 10)%12 ,end, moves + 1, memo);
        if(Math.min(seven, ten) == Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return memo[start] = 1 + Math.min(seven, ten);
    }
}
