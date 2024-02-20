package tenta230315.u4;

import java.util.Arrays;

public class clockCounterDyn {
    static int counter = 0;
    public static int clockMover(int start, int goal){
        int[] board = new int[12];
        Arrays.fill(board, -1);
        board[goal%12] = 0;
        return clockMover(start % 12, goal % 12, 0, board);
    }

    private static int clockMover(int start, int goal, int moves, int[] board){
        counter++;
        if(board[start] != -1) return board[start];
        if(moves == 15) return Integer.MAX_VALUE;

        int seven = clockMover((start + 7)%12, goal, moves + 1, board);
        int ten = clockMover((start + 10)%12, goal, moves + 1, board);

        if(Math.min(seven, ten) == Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return board[start] = 1 + Math.min(seven, ten);

    }
    public static void main(String[] args) {
        System.out.println(clockMover(1, 4) + ", counter=" + counter);
        counter = 0;
        System.out.println(clockMover(12, 11) + ", counter=" + counter);
        counter = 0;
        System.out.println(clockMover(8, 12) + ", counter=" + counter);
        counter = 0;
    }
}
