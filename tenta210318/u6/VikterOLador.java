package tenta210318.u6;

import java.util.Arrays;

public class VikterOLador {
    public static void main(String[] args) {
        int[] w = new int[] {1, 4, 1, 7};
        int x = heaviest(w,2);
        if(x == 7) {
            System.out.println("Returerar 7 och är rätt");
        }else {
            System.out.println("Returerar = " + x + ", och är fel");
        }

        int[] w2 = new int[] {1, 2, 2, 3, 3, 4, 5, 5, 7, 8};
        int y = heaviest(w2,4);
        if(y == 10) {
            System.out.println("Returerar 10 och är rätt");
        }else {
            System.out.println("Returerar = " + y + ", och är fel");
        }
    }

    private static int heaviest(int[] w, int nrOfBoxes){
        if(nrOfBoxes < 1) return -1;
        int[] boxes = new int[nrOfBoxes];
        Arrays.sort(w);
        for(int i = w.length-1; i >= 0; i--){
            int lighttestBox = boxes[0], indexOfBox = 0;
            for(int j = 1; j < boxes.length; j++){
                if(boxes[j] < lighttestBox){
                    lighttestBox=boxes[j];
                    indexOfBox = j;
                }
            }
            boxes[indexOfBox] += w[i];
        }
        int haviestBox = 0;
        for(int boxWeight: boxes){
            if(boxWeight > haviestBox){
                haviestBox = boxWeight;
            }
        }
        return haviestBox;

    }
}
