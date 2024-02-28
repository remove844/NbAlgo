package tenta200310.u2;
import java.util.Arrays;

public class plattor {
    public static int count = 0;
    public static void main(String[] args){
        System.out.println(nrOfCombinations(20)+ " calls:" + count );
        count=0;
        System.out.println(nrOfCombinations2(20)+ " calls:" + count );
        count=0;
    }

    private static int nrOfCombinations(int length) {
        count++;
        if(length == 1) return 0;
        if(length == 0 || length == 2 || length == 3) return 1;

        int nrOfCombs = 0;
        nrOfCombs += nrOfCombinations(length-4);
        nrOfCombs += nrOfCombinations(length-3);
        nrOfCombs += nrOfCombinations(length-2);

        return nrOfCombs;
    }

    private static int nrOfCombinations2(int length) {
        int[] memo = new int[length+1];
        if(length == 0 || length == 2 || length == 3) return 1;
        if(length == 1) return 0;
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
