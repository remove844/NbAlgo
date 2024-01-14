package F5.NB14_1;

public class BallChanger {
    public static int BChange(int blue, int white, int red){
        return BChange(blue, white, red, 0);
    }

    private static int BChange(int blue, int white, int red, int changes){
        if(blue == white && blue == red){
            return changes;
        }
        if(changes == 15) return Integer.MAX_VALUE;
        int ChangeBlue = BChange(blue-1, white+1, red+3, changes+1);
        int ChangeWhite = BChange(blue+2, white-1, red+4, changes+1);
        int ChangeRed = BChange(blue+1, white+5, red-1, changes+1);

        return Math.min(ChangeRed, Math.min(ChangeWhite, ChangeBlue));
    }

    public static void main(String[] args) {
        System.out.println(BChange(2,5,0)); // 1
        System.out.println(BChange(1,0,1)); // 2
        System.out.println(BChange(2,1,0)); // 9
        System.out.println(BChange(3,2,1)); // 9
        System.out.println(BChange(5,2,1)); // 3
        System.out.println(BChange(5,1,3)); // 15

    }
}
