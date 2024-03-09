package tenta190607.u1;

import java.util.Arrays;

public class LowSumMatrix {
    public static int count = 0;
    public static void main(String[] args) {
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

    public static int leastSumD(int[][] matrix){
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length;i++){
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return leastSumD(matrix, memo, 0, 0);
    }

    private static int leastSumD(int[][] matrix, int[][] memo, int row, int col){
        count++;
        if(row > matrix.length - 1 || col > matrix[0].length - 1) return Integer.MAX_VALUE;
        if(memo[row][col] != Integer.MAX_VALUE) return memo[row][col];
        if(row == matrix.length - 1 && col == matrix[0].length - 1) return memo[row][col] = matrix[row][col];

        int best = Math.min(leastSumD(matrix, memo, row + 1, col), leastSumD(matrix, memo, row, col + 1));

        return memo[row][col] = matrix[row][col] + best;
    }

    public static int leastSum(int[][] matrix){
        return leastSum(matrix, 0, 0);
    }

    private static int leastSum(int[][] matrix, int row, int col){
        count++;
        if(row == matrix.length - 1 && col == matrix[0].length - 1) return matrix[row][col];
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if(row + 1 < matrix.length) down = leastSum(matrix, row + 1, col);
        if(col + 1 < matrix[0].length) right = leastSum(matrix, row , col + 1);

        return matrix[row][col] + Math.min(right, down);
    }


}
