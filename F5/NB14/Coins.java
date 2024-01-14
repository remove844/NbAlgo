package F5.NB14;

public class Coins {

    public static int coin(int goalPoint){
        return coin(0, 1, goalPoint);
    }

    private static int coin(int cash, int currentPoints, int goalPoint){
        if(goalPoint == currentPoints) return cash;
        if(goalPoint < currentPoints) return Integer.MAX_VALUE;

        int ten = coin(cash + 10, currentPoints * 3,  goalPoint);
        int five = coin(cash + 5, currentPoints + 4,  goalPoint);

        return Math.min(ten, five);
    }

    public static void main(String[] args) {
        System.out.println(coin(109));
    }
}
