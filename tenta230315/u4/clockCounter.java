package tenta230315.u4;
import java.util.Arrays;
public class clockCounter {
    public static int counter = 0;

    public static int clockMover(int start, int goal){
        int[] board = new int[12];
        return clockMover(start, goal, 0, board);
    }

    public static int clockMoverD(int start, int goal){
        int[] board = new int[12];
        Arrays.fill(board, -1);
        board[goal%12] = 0;
        return clockMoverD(start % 12, goal % 12, 0, board);
    }

    private static int clockMoverD(int start, int goal, int moves, int[] board){
        counter++;
        if(board[start] != -1) return board[start];
        if(moves == 15) return Integer.MAX_VALUE;

        int seven = clockMoverD((start + 7)%12, goal, moves + 1, board);
        int ten = clockMoverD((start + 10)%12, goal, moves + 1, board);

        if(Math.min(seven, ten) == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return board[start] = 1 + Math.min(seven, ten);
    }

    private static int clockMover(int start, int goal, int moves, int[] board){
        counter++;
        if(moves == 15) return Integer.MAX_VALUE;
        if(start == goal) return moves;

        int seven = clockMover((start + 7)%12, goal, moves + 1, board);
        int ten = clockMover((start + 10)%12, goal, moves + 1, board);
        return Math.min(seven, ten);
    }
    public static void main(String[] args) {
        System.out.println(clockMover(1, 4) + ", counter=" + counter);
        counter = 0;
        System.out.println(clockMover(12, 11) + ", counter=" + counter);
        counter = 0;
        System.out.println(clockMoverD(1, 4) + ", counter=" + counter);
        counter = 0;
        System.out.println(clockMoverD(12, 11) + ", counter=" + counter);
        counter = 0;
    }
}
