package Test;

import java.util.Arrays;

public class MinTestTenta {
    public static void main(String[] args) {
        int[][] m = {   {1,	1,	1,	1,	1},
                {2,	2,	2,	2,	2},
                {1,	1,	5,	1,	1},
                {1,	1,	1,	3,	1},
                {0,	0,	0,	0,	8}};

        System.out.println(highestSumAlaAlex(m));
    }

    public static int highestSumAlaAlex(int[][] m){ // Jag vill att man börjar från mitten av arrayen.
        int memo[][] = new int[m.length][m[0].length];
        for(int i = 0; i < m.length;i++){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }

        return highestSumAlaAlex(m, memo, (m.length-1)/2, (m[0].length-1)/2);
    }

    private static int highestSumAlaAlex(int[][] m, int[][] memo, int row, int col){
        if(row > m.length-1 || col > m[0].length-1 ) return 0;
        if(memo[row][col] != Integer.MIN_VALUE) return memo[row][col];

        if(row == m.length-1 && col == m[0].length-1) return memo[row][col] = m[row][col];



        int best = Math.max(highestSumAlaAlex(m,memo, row + 1, col), highestSumAlaAlex(m,memo, row, col + 1));



        return memo[row][col] = best + m[row][col];
    }
}
