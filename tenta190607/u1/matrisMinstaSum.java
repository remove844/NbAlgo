package tenta190607.u1;

import java.util.Arrays;

public class matrisMinstaSum {
    public static int count = 0;
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

        System.out.println("Minsta summa: "+ leastSum(m) + ", count=" + count);
        count = 0;
        System.out.println("Minsta summa: "+ leastSumD(m) + ", count=" + count);
        count = 0;

    }

    private static int leastSum(int[][] m){
        return leastSum(m, 0, 0);
    }

    private static int leastSum(int[][] m, int row, int col){
        count++;
        if(row == m.length-1 && col == m[0].length-1) return m[row][col];
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if(row < m.length - 1){
            left = leastSum(m, row + 1, col);
        }
        if(col < m[0].length - 1){
            right = leastSum(m, row, col + 1);
        }
        return m[row][col] + Math.min(left, right);
    }

    public static int leastSumD(int[][] m){
        //if (m == null || m.length == 0 || m[0].length == 0) return 0;
        int[][] memo = new int[m.length][m[0].length];
        for (int i = 0; i < m.length;i++){
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return leastSumD(m, 0, 0, memo);
    }

    private static int leastSumD(int[][] m, int row, int col, int memo[][]){
        count++;
        if(m.length - 1 < row || m[0].length-1 < col) return Integer.MAX_VALUE;
        if(memo[row][col] != Integer.MAX_VALUE) return memo[row][col];

        if(m.length -1 == row && m[0].length-1 == col) return memo[row][col] = m[row][col];
        int best = Math.min(leastSumD(m, row + 1, col, memo),leastSumD(m, row, col + 1, memo) );
        return memo[row][col] = m[row][col] + best ;

    }
}
