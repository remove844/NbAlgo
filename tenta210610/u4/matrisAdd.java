package tenta210610.u4;

public class matrisAdd {
    public static int count = 0;
    public static void main(String[] args){
        int[][] m = {{2,	1,	1,	2,	1,	3},
                {4,	4,	3,	5,	2,	2},
                {1,	2,	2,	3,	3,	1},
                {5,	4,	3,	1,	4,	4},
                {3,	2,	3,	2,	5,	1},
                {1,	6,	3,	5,	6,	0}};
        System.out.println("Resultat: "+shortestRoute(m) + ", " + count); count = 0;
        System.out.println("Resultat: "+shortestRouteD(m) + ", " + count); count = 0;
    }
    public static int shortestRouteD(int[][] matrix){
        int[][] memo = new int[matrix.length][matrix[0].length];
        int m = shortestRouteD(matrix, 0, 0, memo);
        if(m  == matrix.length + matrix[0].length) return -1;
        return m;
    }
    public static int shortestRoute(int[][] matrix){
        int m = shortestRoute(matrix, 0, 0, 0);
        if(m == Integer.MAX_VALUE) return -1;
        return m;
    }

    private static int shortestRoute(int[][] matrix, int row, int col, int sum){ //43
        count++;
        if(row == matrix.length-1 && col == matrix[0].length-1) return sum;

        if(row > matrix.length-1 || col > matrix[0].length-1) return Integer.MAX_VALUE;
        int jumpRight = shortestRoute(matrix, row, col +  matrix[row][col], sum + 1);
        int jumpDown = shortestRoute(matrix, row + matrix[row][col], col, sum + 1);

        return Math.min(jumpRight, jumpDown);
    }

    private static int shortestRouteD(int[][] matrix, int row, int col, int[][]memo){ //33
        count++;
        if(row == matrix.length-1 && col == matrix[0].length-1) return 0;
        if(row >= matrix.length || col >= matrix[0].length) return matrix.length + matrix[0].length;
        if(memo[row][col] != 0) return memo[row][col];

        int jumpRight = shortestRouteD(matrix, row, col +  matrix[row][col], memo);
        int jumpDown = shortestRouteD(matrix, row + matrix[row][col], col, memo);

        return memo[row][col] = 1 + Math.min(jumpRight, jumpDown);
    }
}
