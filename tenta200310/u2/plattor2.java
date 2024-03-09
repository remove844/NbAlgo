package tenta200310.u2;

import java.util.Arrays;

public class plattor2 {
    public static int count = 0;
    public static void main(String[] args){
        System.out.println("20:"+nrOfCombinations(7) + ", " + count);
        count = 0;
        System.out.println("20:"+nrOfCombinations2(7) + ", " + count);

    }

    public static int nrOfCombinations(int length) {
        count++;
        if(length < 0) return 0;
        if(length == 0) return 1;

        int nrOfComb = 0;
        nrOfComb += nrOfCombinations(length-4);
        nrOfComb += nrOfCombinations(length-3);
        nrOfComb += nrOfCombinations(length-2);

        return nrOfComb;
    }



    public static int nrOfCombinations2(int length) {
        int[] memo = new int[length+1];
        if(length < 0) return 0;
        if(length == 0) return 1;
        Arrays.fill(memo, -1);
        memo[1] = 0;
        memo[0] = memo[2] = memo[3] = 1;
        return nrOfCombinations2(length, memo);
    }

    private static int nrOfCombinations2(int length, int[] memo){
        count++;
        if(memo[length] != -1) return memo[length];

        int nrOfComb = 0;
        nrOfComb += nrOfCombinations2(length-4, memo);
        nrOfComb += nrOfCombinations2(length-3, memo);
        nrOfComb += nrOfCombinations2(length-2, memo);

        return memo[length] = nrOfComb;
    }
}
