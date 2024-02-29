package tenta190314.u2;

public class CountingPlusAndMulti {
    public static void main(String[] args) {
        System.out.println(counting(57));
        //ystem.out.println(counting2(57));
    }

    public static int counting(int goal){
        return counting(goal, 1);
    }

    private static int counting(int goal, int sum){
        if(sum > goal) return -1;
        if(sum == goal) return 0;
        int multi = counting(goal, sum * 3);
        int plus = counting(goal, sum + 4);
        if (multi == -1 && plus == -1) return -1;
        if(multi == -1) return 1 + plus;
        if(plus == -1) return 1 + multi;

        return 1 + Math.min(multi, plus);
    }


}
