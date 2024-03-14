package tenta220317.u4;

import java.util.Arrays;

public class MatrixMaxSum2 {
    public static int count;
    public static void main(String[] args) {
        int[][] m = {   {2,	-1,	1,	2,	1,	3},
                {4,	4,	-3,	5,	2,	2},
                {1,	2,	-2,	3,	3,	1},
                {5,	-4,	-3,	1,	4,	4},
                {0,	2,	3,	2,	-5,	1}};
        System.out.println(highestSum(m) + ", " + count);
    }

    private static int highestSum(int[][] m) {
        int[][] memo = new int[m.length][m[0].length];
        for(int i = 0; i < m.length; i++){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return highestSum(m, memo, 0, 0);
    }
    private static int highestSum(int[][] m, int[][] memo, int row, int col){
        count++;
        if(row > m.length - 1 || col > m[0].length - 1) return 0;
        if(row == m.length - 1 && col == m[0].length - 1) return memo[row][col] = m[row][col];
        if(memo[row][col] != Integer.MIN_VALUE) return memo[row][col];

        int best = highestSum(m, memo, row + 1, col);
        best = Math.max(best, highestSum(m, memo, row, col + 1));
        best = Math.max(best, highestSum(m, memo, row, col + 2));

        return memo[row][col] = best + m[row][col];
    }

}
