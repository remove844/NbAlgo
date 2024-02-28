package tenta200310.u4;

import java.util.HashMap;

public class ordArray {
    public static void main(String[] args){
        String[] text = {"hej", "hej", "hej", "hej", "hej", "hej", "på", "på", "på", "dig", "dig", "har", "har", "har", "har", "du", "du", "du", "på", "på", "på", "dig",
                "mobilen", "har", "har", "har", "du", "du", "på", "på", "på", "dig", "dig", "dig", "allt"};
        System.out.println(mostRepeated(text));
    }

    public static String mostRepeated(String[] text){
        HashMap<String, Integer> hashMap = new HashMap<>();
        int nrMost = 0, nrRep = 0;
        String mostWord = "", lastWord = "";
        for (String word : text) {
            if(word.equals(lastWord)){
                nrRep++;
                if(nrRep == 3){
                    if(hashMap.containsKey(word)){
                        hashMap.put(word, hashMap.get(word) + 1);
                    } else {
                        hashMap.put(word, 1);
                    }
                    if(hashMap.get(word) > nrMost){
                        nrMost = hashMap.get(word);
                        mostWord = word;
                    }
                }
            } else {
                lastWord = word;
                nrRep = 1;
            }
        }
        return mostWord;
    }


}
