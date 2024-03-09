package tenta210318.u4;

import java.util.Arrays;

public class BiggestSum3 {
    public static int count;
    public static void main(String[] args) {
        int[] v={1,2,0,-2,4,-3,-7,6,-2,-5,8,1,2,5};
        int[] w={-2,-3,5,-3,7,3,-8,5,-6,9,-2,7,0,-5,0,-3,-4,-5,1,5,-6,7,-8,9,-3,2,-5,7,3,7,8,-3,5,8,-1};
        System.out.println(largestSum(v) + ", " + count);
        count = 0;
        System.out.println(largestSum(w) + ", " + count);
        count = 0;
    }

    public static int largestSum(int[] matrix){
        int[] memo = new int[matrix.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return largestSum(matrix, memo, 0);
    }

    private static int largestSum(int[] matrix, int[] memo, int i){
        count++;
        if(i > matrix.length-1) return 0;
        if(memo[i] != Integer.MIN_VALUE) return memo[i];
        return memo[i] = Math.max(largestSum(matrix, memo, i + 3), largestSum(matrix, memo, i + 5)) + matrix[i];
    }
}
