package F9.NB28;

import java.util.Arrays;

public class sort {
    public static void SelectionSort(int[] arr) {
        int n = arr.length;
        for (int index = 0; index < n - 1; index++) {
            int minIndex = index;

            for (int i = index + 1; i < n; i++) {
                if (arr[i] < arr[minIndex]) minIndex = i;
            }

            int temp = arr[index];
            arr[index] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void InsertionSort(int[] arr){
        int n = arr.length;
        for (int index = 1; index < n; index++) {
            int data = arr[index];
            int dataIndex = index;
            while (dataIndex > 0 && data < arr[dataIndex - 1]){
                arr[dataIndex] = arr[dataIndex - 1];
                dataIndex--;
            }
            arr[dataIndex] = data;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        int[] arr2 = {5, 3, 2, 4, 1};
        SelectionSort(arr);
        System.out.println("SelectionSort: " + Arrays.toString(arr));
        InsertionSort(arr2);
        System.out.println("InsertionSort: " + Arrays.toString(arr2));
    }
}
