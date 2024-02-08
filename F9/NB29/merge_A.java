package F9.NB29;

import java.util.Arrays;

public class merge_A {
    public static void Merge(int[] a, int[] b, int[] c){
        int indexa = 0, indexb = 0, indexc = 0, n = a.length, m = b.length;
        while (indexa < n && indexb < m && indexc < c.length){
            if(a[indexa] <= b[indexb]){
                c[indexc++] = a[indexa];
                indexa++;
            }else {
                c[indexc++] = b[indexb];
                indexb++;
            }
        }
        while (indexa < n && indexc < c.length){
            c[indexc++] = a[indexa];
            indexa++;
        }
        while (indexb < m && indexc < c.length){
            c[indexc++] = b[indexb];
            indexb++;
        }
    }

    public static void MergeSort(int[] a){
        if(a.length == 1) return;
        int[] b = new int[a.length/2];
        int[] c = new int[a.length-a.length/2];
        int i;
        for (i = 0;i  < a.length/2; i++) {
            b[i] = a[i];

        }
        for (;i  < a.length; i++) {
            c[i-a.length/2] = a[i];
        }
        MergeSort(b);
        MergeSort(c);
        Merge(b, c, a);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 1};
        MergeSort(arr);
        System.out.println("MergeSort: " + Arrays.toString(arr));
    }
}
