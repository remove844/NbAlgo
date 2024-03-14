package tenta220317.u4;

import java.util.Arrays;

public class MatrixMaxSum3 {
    public static int count;
    public static void main(String[] args) {
        int[][] m = {   {2,	-1,	1,	2,	1,	3},
                {4,	4,	-3,	5,	2,	2},
                {1,	2,	-2,	3,	3,	1},
                {5,	-4,	-3,	1,	4,	4},
                {0,	2,	3,	2,	-5,	1}};
        System.out.println(highestSum(m) + ", " + count);
        count = 0;
        System.out.println(highestSumD(m) + ", " + count);
        count = 0;
    }

    private static int highestSum(int[][] m) {
        return highestSum(m, 0, 0);
    }

    private static int highestSum(int[][] matrix, int row, int col){
        count++;
        if(row > matrix.length - 1 || col > matrix[0].length - 1) return 0;
        if(row == matrix.length - 1 && col == matrix[0].length - 1) return matrix[row][col];

        int oneStepRight = highestSum(matrix, row, col + 1);
        int twoStepRight = highestSum(matrix, row, col + 2);
        int oneStepDown = highestSum(matrix, row + 1, col);

        return matrix[row][col] + Math.max(oneStepRight, Math.max(twoStepRight, oneStepDown));
    }

    public static int highestSumD(int[][] matrix){
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return highestSumD(matrix, memo, 0, 0);
    }

    private static int highestSumD(int[][] matrix, int[][] memo, int row, int col){
        count++;
        if(row > matrix.length - 1 || col > matrix[0].length - 1) return 0;
        if(row == matrix.length - 1 && col == matrix[0].length - 1) return memo[row][col] = matrix[row][col];
        if(memo[row][col] != Integer.MIN_VALUE) return memo[row][col];

        int best = highestSumD(matrix, memo, row, col + 1);
        best = Math.max(best, highestSumD(matrix, memo, row, col + 2));
        best = Math.max(best, highestSumD(matrix, memo, row + 1, col));

        return memo[row][col] = best + matrix[row][col];
    }
}
