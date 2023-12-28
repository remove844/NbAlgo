package F5.NB13;

public class CountRot {

    public static double Root(int n, double a, double e){
        if( Math.abs((a * a) - n) < e ) return a;
        return Root(n, (a * a + n) / (2 * a), e);
    }

    public static void main(String[] args) {
        System.out.println(CountRot.Root(12, 1, 0.1));
    }
}
