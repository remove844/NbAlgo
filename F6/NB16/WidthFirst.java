package F6.NB16;

import java.util.LinkedList;
import java.util.Queue;

public class WidthFirst {

    private static class Tillstand{
        private int blue, white, red, result;

        public Tillstand(int blue, int white, int red, int result) {
            this.blue = blue;
            this.white = white;
            this.red = red;
            this.result = result;
        }
    }

    public static int BallChanger(int blue, int white, int red){
        Queue<Tillstand> queue = new LinkedList<>();
        Tillstand tillstand = new Tillstand(blue, white, red, 0);
        while (!(tillstand.blue == tillstand.white && tillstand.blue == tillstand.red) && tillstand.result < 16){
            queue.offer(new Tillstand(tillstand.blue - 1, tillstand.white + 1, tillstand.red + 3, tillstand.result + 1));
            queue.offer(new Tillstand(tillstand.blue + 2, tillstand.white - 1, tillstand.red + 4, tillstand.result + 1));
            queue.offer(new Tillstand(tillstand.blue + 1, tillstand.white + 5, tillstand.red - 1, tillstand.result + 1));
            tillstand = queue.poll();
        }
        return tillstand.result;
    }

    public static void main(String[] args) {
        System.out.println(WidthFirst.BallChanger(2,5,0)); // 1
        System.out.println(WidthFirst.BallChanger(1,0,1)); // 2
        System.out.println(WidthFirst.BallChanger(2,1,0)); // 9
        System.out.println(WidthFirst.BallChanger(3,2,1)); // 9
        System.out.println(WidthFirst.BallChanger(5,2,1)); // 3
        System.out.println(WidthFirst.BallChanger(5,1,3)); // 15
    }

}

