package F8.NB26_2;

import java.util.HashSet;

public class countUnik {
    public static int countUnik(String[] strings) {
        HashSet<String> u1 = new HashSet<>();
        for (String str : strings) {
            u1.add(str);
        }
        return u1.size();
    }

    public static void main(String[] args) {
            String[] s1 = new String[] {"man", "gråter", "när", "man", "'tänker'", "när"};
        int unik = countUnik.countUnik(s1);
        System.out.println("Antal unika är=" + unik);
    }
}
