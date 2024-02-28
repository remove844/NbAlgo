package tenta230607.u4;

public class treStepMatris {
    public static int count = 0;
    public static void main(String[] args) {
        int[][] matrix = {  {1,5,4,7,8,3,1},
                {2,6,3,4,7,1,5},
                {3,5,1,9,1,7,1},
                {1,3,1,4,5,8,2},
                {3,1,8,3,1,2,1}};
        System.out.println(maxSum(matrix,1) + ", " + count);
        count = 0;
        System.out.println(maxSumDyn(matrix,1) + ", " + count);
        count = 0;
    }
    private static int maxSum(int[][] matrix, int startCol) {
        if(matrix.length < 1 || matrix[0].length - 1 < startCol || startCol < 0) return -1;
        return maxSum(matrix, 0, startCol);
    }

    private static int maxSum(int[][] matrix, int row, int col){
        count++;
        if(row == matrix.length - 1) return matrix[row][col];
        int best = maxSum(matrix, row+1, col);
        if(col - 1 >= 0) best = Math.max(best, maxSum(matrix, row + 1, col - 1));
        if(col + 1 < matrix[row].length) best = Math.max(best, maxSum(matrix, row + 1, col+1));
        return matrix[row][col] + best;
    }

    private static int maxSumDyn(int[][] matrix, int startCol){
        if(matrix.length < 1 || startCol<0 || startCol>matrix[0].length-1) return -1;
        int[][] memo = new int[matrix.length][matrix[0].length];
        return maxSumDyn(matrix, 0, startCol, memo);
    }

    private static int maxSumDyn(int[][] matrix, int row, int col, int[][] memo){
        count++;
        if(memo[row][col] != 0) return memo[row][col];
        if(row == matrix.length - 1) return memo[row][col] = matrix[row][col]; // När den kommit till slutet
        int best = maxSumDyn(matrix, row + 1, col, memo);
        if(col - 1 >= 0) best = Math.max(best, maxSumDyn(matrix, row+1, col - 1, memo));
        if(col + 1 < matrix[row].length) best = Math.max(best, maxSumDyn(matrix, row + 1, col + 1, memo));
        return  memo[row][col] = matrix[row][col] + best;
    }
}
