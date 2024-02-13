package tenta220317.u4;

import java.util.Arrays;
import java.util.Map;

public class matrixMaxSum {
    public static void main(String[] args) {
        int[][] m = {   {2,	-1,	1,	2,	1,	3},
                        {4,	4,	-3,	5,	2,	2},
                        {1,	2,	-2,	3,	3,	1},
                        {5,	-4,	-3,	1,	4,	4},
                        {0,	2,	3,	2,	-5,	1}};

        System.out.println(highestSum(m));
    }

    public static int highestSum(int[][] matrix){
        int[][] bestSum = new int[matrix.length][matrix[0].length];
        for (int[] row : bestSum) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return highestSum(matrix, bestSum, 0, 0);
    }

    private static int highestSum(int[][] matrix, int[][] bestSum, int row, int col){
        if(bestSum[row][col] != Integer.MIN_VALUE) return bestSum[row][col];
        if(row == matrix.length - 1 && col == matrix[0].length - 1) return bestSum[row][col] = matrix[row][col];
        int sum = Integer.MIN_VALUE;

        if(row + 1 < matrix.length) sum = highestSum(matrix, bestSum, row + 1, col);
        if(col + 1 < matrix[0].length) sum = Math.max(sum, highestSum(matrix, bestSum, row, col + 1));
        if(col + 2 < matrix[0].length) sum = Math.max(sum, highestSum(matrix, bestSum, row, col + 2));

        return bestSum[row][col] = sum + matrix[row][col];
    }

}
