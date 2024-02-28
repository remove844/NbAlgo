package tenta190607.u1;

public class matrisMinstaSum {
    public static void main(String[] args){

        int[][] m = new int[][] {   {4,3,8,7,2,7},
                {2,8,8,9,3,5},
                {1,4,1,9,4,2},
                {2,8,3,9,5,9},
                {9,9,8,3,1,7},
                {5,6,1,3,7,2},
                {9,2,2,5,6,3},
                {1,3,3,8,3,1},
                {8,4,6,8,2,5}};

        System.out.println("Minsta summa: "+ leastSum(m));
    }

    private static int leastSum(int[][] m){
        return leastSum(m, 0, 0);
    }

    private static int leastSum(int[][] m, int row, int col){
        if(row == m.length-1 && col == m[0].length-1) return m[row][col];
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if(row < m.length - 1){
            left = leastSum(m, row + 1, col);
        }
        if(col < m[0].length - 1){
            right = leastSum(m, row, col + 1);
        }
        return m[row][col] + Math.min(left, right);
    }
}
