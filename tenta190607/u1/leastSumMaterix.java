package tenta190607.u1;

import java.util.Arrays;

public class leastSumMaterix {
    public static int count;
    public static void main(String[] args){

        int[][] m = new int[][] {   {4,3,8,7,2,7},
                {2,8,8,9,3,5},
                {1,4,1,9,4,2},
                {2,8,3,9,5,9},
                {9,9,8,3,1,7},
                {5,6,1,3,7,2},
                {9,2,2,5,6,3},
                {1,3,3,8,3,1},
                {8,4,6,8,2,5}};
        count = 0;
        System.out.println("Minsta summa: "+leastSum(m) + ", " + count);
    }

    public static int leastSum(int[][] m){
        int[][] memo = new int[m.length][m[0].length];
        for(int i = 0; i < m.length;i++){
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return leastSum(m, memo, 0, 0);
    }
    private static int leastSum(int[][] m, int[][] memo, int row, int col){
        count++;
        if(row > m.length-1 || col > m[0].length-1) return Integer.MAX_VALUE;
        if(memo[row][col] != Integer.MAX_VALUE) return memo[row][col];
        if(row == m.length-1 && col == m[0].length-1) return memo[row][col] = m[row][col];

        int best = Math.min(leastSum(m, memo, row + 1, col), leastSum(m, memo, row, col + 1));

        return memo[row][col] = best + m[row][col];
    }
}
