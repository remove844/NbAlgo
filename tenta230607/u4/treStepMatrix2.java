package tenta230607.u4;

import java.util.Arrays;

public class treStepMatrix2 {
    public static int count = 0;
    public static void main(String[] args) {
        int[][] matrix = {  {1,5,4,7,8,3,1},
                {2,6,3,4,7,1,5},
                {3,5,1,9,1,7,1},
                {1,3,1,4,5,8,2},
                {3,1,8,3,1,2,1}};
        System.out.println(maxSum(matrix,1) + ", " + count);//29, 95
        count = 0;
        System.out.println(maxSumDyn(matrix,1) + ", " + count);//29, 37
        count = 0;
    }

    public static int maxSumDyn(int[][] matrix, int start) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length;i++){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return maxSumDyn(matrix, memo, 0, start);
    }

    private static int maxSumDyn(int[][] matrix, int[][] memo, int row, int col){
        count++;
        if(col < 0 || col > matrix[0].length - 1) return 0;
        if(memo[row][col] != Integer.MIN_VALUE) return memo[row][col];

        if(row == matrix.length - 1) return memo[row][col] = matrix[row][col];

        int down = maxSumDyn(matrix, memo, row + 1, col);
        down = Math.max(down, maxSumDyn(matrix, memo, row + 1, col - 1));
        down = Math.max(down, maxSumDyn(matrix, memo, row + 1, col + 1));

        return memo[row][col] = matrix[row][col] + down;
    }

    public static int maxSum(int[][] matrix, int start){
        return maxSum(matrix, 0, start);
    }

    private static int maxSum(int[][] matrix, int row, int col){
        count++;
        if(row == matrix.length - 1) return matrix[row][col];

        int down = maxSum(matrix, row + 1, col);
        if(col - 1 >= 0) down = Math.max(down, maxSum(matrix, row + 1, col - 1));
        if(col + 1 < matrix[0].length) down = Math.max(down, maxSum(matrix, row + 1, col + 1));

        return down + matrix[row][col];
    }

}
