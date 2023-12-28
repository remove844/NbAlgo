package F5.NB12;

public class CountN {
    public static int counter(int x, int n){
        return counter(x, n, 1);
    }

    public static int counter(int x, int n, int result){
        if(n == 0) return result;
        if(n > 0) result *= x;
        return counter(x, n-1, result);
    }

    public static int counterIterativ(int x, int n){
        int result = 1;
        for(int i = 0; i < n; i++){
            result *= x;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(counter(3, 3));
        System.out.println(counterIterativ(3, 3));
    }
}
