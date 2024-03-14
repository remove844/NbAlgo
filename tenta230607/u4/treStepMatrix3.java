package tenta230607.u4;

import java.util.Arrays;

public class treStepMatrix3 {
    public static int count;
    public static void main(String[] args) {
        int[][] matrix = {  {1,5,4,7,8,3,1},
                {2,6,3,4,7,1,5},
                {3,5,1,9,1,7,1},
                {1,3,1,4,5,8,2},
                {3,1,8,3,1,2,1}};
        System.out.println(maxSum(matrix,1) + ", " + count);
        count = 0;
        System.out.println(maxSumD(matrix,1) + ", " + count);
        count = 0;
    }
    private static int maxSum(int[][] matrix, int startCol) {
        return maxSum(matrix, 0, startCol);
    }

    private static int maxSum(int[][] matrix, int row, int col){
        count++;
        if(row == matrix.length - 1) return matrix[row][col];
        int best = maxSum(matrix, row + 1, col);
        if(col > 0 && col < matrix[0].length - 1){
            best = Math.max(best, maxSum(matrix, row + 1, col + 1));
            best = Math.max(best, maxSum(matrix, row + 1, col - 1));
        }
        return matrix[row][col] + best;
    }

    private static int maxSumD(int[][] matrix, int startCol) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i = 0;i < matrix.length;i++){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return maxSumD(matrix, memo, 0, startCol);
    }

    private static int maxSumD(int[][] matrix, int[][] memo, int row, int col){
        count++;
        if(row > matrix.length - 1 || col > matrix[0].length - 1 || col < 0) return 0;
        if(row == matrix.length - 1) return memo[row][col] = matrix[row][col];
        if(memo[row][col] != Integer.MIN_VALUE) return memo[row][col];

        int best = maxSumD(matrix, memo, row + 1, col);
        best = Math.max(best, maxSumD(matrix, memo, row + 1, col + 1));
        best = Math.max(best, maxSumD(matrix, memo, row + 1, col - 1));
        return memo[row][col] = matrix[row][col] + best;
    }

}
