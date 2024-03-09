package tenta220317.u4;

import java.util.Arrays;

public class matrixMaxSum {
    public static void main(String[] args) {
        int[][] m = {   {2,	-1,	1,	2,	1,	3},
                        {4,	4,	-3,	5,	2,	2},
                        {1,	2,	-2,	3,	3,	1},
                        {5,	-4,	-3,	1,	4,	4},
                        {0,	2,	3,	2,	-5,	1}};

<<<<<<< HEAD
        System.out.println(highestSumD(m));
    }

=======
        System.out.println(highestSum(m));
        System.out.println(highestSumD(m));
    }

    public static int highestSum(int[][] matrix){
        return highestSum(matrix, 0, 0);
    }

    private static int highestSum(int[][] matrix, int row, int col){
        if(row > matrix.length - 1 || col > matrix[0].length - 1) return 0;
        if(row == matrix.length - 1 && col == matrix[0].length - 1) return matrix[row][col];

        int sum = highestSum(matrix, row + 1, col);
        sum = Math.max(sum, highestSum(matrix, row, col + 1));
        sum = Math.max(sum, highestSum(matrix, row, col + 2));

        return sum + matrix[row][col];
    }


>>>>>>> 9e2dbbbce3ca61026592e852456f17bda8523e5d
    public static int highestSumD(int[][] matrix){
        int[][] bestSum = new int[matrix.length][matrix[0].length];
        for (int[] row : bestSum) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return highestSumD(matrix, bestSum, 0, 0);
    }

    private static int highestSumD(int[][] matrix, int[][] memo, int row, int col){
        if(row > matrix.length-1 || col > matrix[0].length-1) return 0;
        if(memo[row][col] != Integer.MIN_VALUE) return memo[row][col];

        if(row == matrix.length - 1 && col == matrix[0].length - 1) return memo[row][col] = matrix[row][col];
        int sum = highestSumD(matrix, memo, row + 1, col);
        sum = Math.max(sum, highestSumD(matrix, memo, row, col + 1));
        sum = Math.max(sum, highestSumD(matrix, memo, row, col + 2));

        return memo[row][col] = sum + matrix[row][col];
    }
}
