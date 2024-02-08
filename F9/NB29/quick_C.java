package F9.NB29;

import java.util.Arrays;

public class quick_C {
    public static void quickSort(int[] arr, int start, int end){
        if(start < end){
            int pivotIndex = partition(arr, start, end);

            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("quickSort: " + Arrays.toString(arr));
    }
}
