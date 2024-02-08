package tenta220610.u5;

public class InsertionSort {

    public static void insertion(int[] list){
        for(int i = 1; i < list.length; i++){
            int prev = i - 1;
            int current = list[i];
            while (prev >= 0 && current < list[prev]){
                list[prev + 1] = list[prev];
                prev--;
            }
            list[prev + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] list = {5, 3, 7, 1, 9, 2, 8, 4, 6, 0};

        insertion(list);
        for(int i : list) System.out.print(i + " ");
    }
}
