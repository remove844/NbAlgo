package tenta210610.u6;

import java.util.HashMap;
import java.util.HashSet;

public class ElementArrayWordA {
    public static void main(String[] args) {
        String[] words ={"tag", "min", "hand", "tag", "min", "vita", "arm", "tag", "mina", "smala", "axlars", "längtan"};
        System.out.println(nrUniqueWith_a(words));

    }

    public static int nrUniqueWith_a(String[] words){
        return nrUniqueWith_a(words, 0);
    }

    private static int nrUniqueWith_a(String[] words, int unikWords){
        HashSet <String> set = new HashSet<>();
        for(int i = 0;i < words.length;i++){
            if(words[i].contains("a")){
                set.add(words[i]);
            }
        }
        return set.size();
    }
}
