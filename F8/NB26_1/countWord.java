package F8.NB26_1;

import java.util.HashMap;

public class countWord {
    public static int HashmapFreqenz(String[] arr){
        HashMap<String, Integer> m1 = new HashMap<>();
        int count = 0;
        for(String s: arr){
            if(m1.get(s) != null){
                m1.put(s, m1.get(s) + 1);
                count = Math.max(count, m1.get(s));
                continue;
            }
            m1.put(s, 1);
        }
        return count;
    }

    public static void main(String[] args) {
        String[] s1 = new String[] {"Hej", "Hej", "Hej", "'nej'", "Hej", "Hej"};
        System.out.println(countWord.HashmapFreqenz(s1));
    }
}
