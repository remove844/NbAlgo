package tenta230315.u4;

public class clockCounter {
    public static int counter = 0;

    public static int clockMover(int start, int goal){
        int[] board = new int[12];
        return clockMover(start, goal, 0, board);
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
    }
}
