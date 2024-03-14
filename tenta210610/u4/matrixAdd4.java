package tenta210610.u4;

import java.util.Arrays;

public class matrixAdd4 {
    public static int count = 0;
    public static void main(String[] args){
        int[][] m = {{2,	1,	1,	2,	1,	3},
                {4,	4,	3,	5,	2,	2},
                {1,	2,	2,	3,	3,	1},
                {5,	4,	3,	1,	4,	4},
                {3,	2,	3,	2,	5,	1},
                {1,	6,	3,	5,	6,	0}};
        System.out.println("Resultat: "+shortestRoute(m) + ", " + count);
        count = 0;
        System.out.println("Resultat: "+shortestRouteD(m) + ", " + count);
        count = 0;
    }

    public static int shortestRoute(int[][] matrix){
        int m = shortestRoute(matrix, 0, 0);
        if(m == 99) return -1;
        return m;
    }

    private static int shortestRoute(int[][] matrix, int row, int col){
        count++;
        if(row > matrix.length - 1 || col > matrix[0].length - 1) return 99;
        if(row == matrix.length - 1 && col == matrix[0].length - 1) return matrix[row][col];

        return 1 + Math.min(shortestRoute(matrix, row + matrix[row][col], col), shortestRoute(matrix, row, col + matrix[row][col]));
    }

    public static int shortestRouteD(int[][] matrix){
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i = 0;i < matrix.length; i++){
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        int m = shortestRouteD(matrix, memo, 0, 0);
        if(m == 99) return -1;
        return m;
    }

    private static int shortestRouteD(int[][] matrix, int[][] memo, int row, int col){
        count++;
        if(row > matrix.length - 1 || col > matrix[0].length - 1) return 99;
        if(row == matrix.length - 1 && col == matrix[0].length - 1) return memo[row][col] = matrix[row][col];
        if(memo[row][col] != Integer.MAX_VALUE) return memo[row][col];

        return memo[row][col] = 1 + Math.min(shortestRouteD(matrix, memo, row + matrix[row][col], col), shortestRouteD(matrix, memo, row, col + matrix[row][col]));

    }
}
