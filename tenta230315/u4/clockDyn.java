package tenta230315.u4;

import java.util.Arrays;

public class clockDyn {
    public static void main(String[] args) {
        System.out.println("Antal: " + nrOfPushes(1,4));
        System.out.println("Antal: " + nrOfPushes(12,11));
        System.out.println("Antal: " + nrOfPushes(8,12));
    }

    public static int nrOfPushes(int startTime, int endTime) {
        int[] memo = new int[15];
        Arrays.fill(memo, Integer.MAX_VALUE); //För att hålla kolla på om den varit på en plats.
        memo[endTime%12] = 0;
        return nrOfPushes(startTime,endTime, 0,  memo);
    }

    private static int nrOfPushes(int startTime, int endTime, int moves, int[] memo){
        if(memo[startTime] != Integer.MAX_VALUE) return memo[startTime]; // om den redan varit här så returera talet direkt.
        if(moves > memo.length-1) return memo[startTime];

        int seven = nrOfPushes((startTime + 7)%12, endTime%12, moves + 1, memo);
        int ten = nrOfPushes((startTime + 10)%12, endTime%12, moves + 1, memo);

        if(Math.min(seven, ten) == Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return memo[startTime] = 1 + Math.min(seven, ten);
    }
}
