package tenta210610.u4;

import java.util.Arrays;

public class MatrixAdd2 {
    public static int couter=0;
    public static void main(String[] args){
        int[][] m = {{2,	1,	1,	2,	1,	3},
                {4,	4,	3,	5,	2,	2},
                {1,	2,	2,	3,	3,	1},
                {5,	4,	3,	1,	4,	4},
                {3,	2,	3,	2,	5,	1},
                {1,	6,	3,	5,	6,	0}};
        System.out.println("Resultat: "+shortestRoute(m) + ", " + couter);
    }

    public static int shortestRoute(int [][] matrix){
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i = 0;i < matrix.length;i++){
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        int m = shortestRoute(matrix, memo, 0, 0);
        if(m == 99) return -1;
        return m;
    }

    private static int shortestRoute(int[][] matrix, int[][] memo, int row, int col){
        couter++;
        if(matrix.length-1 < row || matrix[0].length-1 < col) return 99;
        if(memo[row][col] != Integer.MAX_VALUE) return memo[row][col];
        if(row == matrix.length-1 && col == matrix[0].length-1) return memo[row][col] = matrix[row][col];

        int steps = Math.min(shortestRoute(matrix,memo, row + matrix[row][col],col), shortestRoute(matrix,memo, row, col + matrix[row][col]));

        return memo[row][col] = 1 + steps;
    }
}
