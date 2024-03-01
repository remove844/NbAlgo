package F9.NB29;

import java.util.Arrays;

public class shell_B {
    public static void ShellSort(int[] arr){
        int n = arr.length;
        double gap = n/2;
        while (gap > 0){
            for (int i = (int) gap; i < n; i++){
                int data = arr[i];
                int dataIndex = i;
                while (dataIndex > gap - 1 && data < arr[(int) (dataIndex-gap)] ){
                    arr[dataIndex] = arr[(int) (dataIndex-gap)];
                    dataIndex -= gap;
                }
                arr[dataIndex] = data;
            }
            if(gap == 2) gap = 1;
            else gap = gap/2.2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 1};
        ShellSort(arr);
        System.out.println("ShellSort: " + Arrays.toString(arr));
    }
}
