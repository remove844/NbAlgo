package tenta210318.u4;

import java.util.Arrays;

public class BiggestSum2 {
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
    }

    public static int largestSumD(int[] m){
        int[] memo = new int[m.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return largestSumD(m, memo, 0);
    }

    private static int largestSumD(int[] m, int[] memo, int index){
        count++;
        if(index > m.length-1) return 0;
        if(memo[index] != Integer.MIN_VALUE) return memo[index];
        return memo[index] = Math.max(largestSumD(m, memo, index + 3), largestSumD(m, memo, index + 5)) + m[index];
    }

    public static int largestSum(int[] m){
        return largestSum(m, 0);
    }

    private static int largestSum(int[] m, int index){
        count++;
        if(index > m.length-1) return 0;
        return Math.max(largestSum(m, index + 3), largestSum(m, index + 5)) + m[index];
    }
}
