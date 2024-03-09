package tenta230607.u4;

import java.util.Arrays;

public class treStep2 {
    public static void main(String[] args) {
        int[][] matrix = {  {1,5,4,7,8,3,1},
                {2,6,3,4,7,1,5},
                {3,5,1,9,1,7,1},
                {1,3,1,4,5,8,2},
                {3,1,8,3,1,2,1}};

        System.out.println(maxSum(matrix, 1));
    }

    public static int maxSum(int[][] matrix, int start){
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return maxSum(matrix, 0, start, memo);
    }

    private static int maxSum(int[][] matrix, int row, int col, int[][] memo){
        if(col < 0 || col >= matrix[row].length) return 0;
        if(memo[row][col] != -1) return memo[row][col];

        if(row == matrix.length - 1) return memo[row][col] = matrix[row][col];

        int sum = maxSum(matrix, row + 1, col, memo);
        sum = Math.max(sum, maxSum(matrix, row + 1, col - 1, memo));
        sum = Math.max(sum, maxSum(matrix, row + 1, col + 1, memo));

        return memo[row][col] = sum + matrix[row][col];
    }
}
