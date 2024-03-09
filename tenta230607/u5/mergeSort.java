package tenta230607.u5;
import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] a = {1,14,8,21,4,13,7,5,3,33};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a) {
        if(a.length <= 1) return;
        int[] b = new int[a.length/2];
        int[] c = new int[a.length - a.length/2];
        System.arraycopy(a, 0, b, 0, b.length);
        System.arraycopy(a, b.length, c, 0, c.length);
        mergeSort(b);
        mergeSort(c);
        merge(b, c, a);
    }

    private static void merge(int[] a, int [] b, int[] c){
        int indexa = 0, indexb = 0, indexc = 0;
        while (indexa < a.length && indexb < b.length){
            if(a[indexa] <= b[indexb]){
                c[indexc++] = a[indexa];
                indexa++;
            }else {
                c[indexc++] = b[indexb];
                indexb++;
            }
        }
        while (indexa < a.length){
            c[indexc++] = a[indexa];
            indexa++;
        }
        while (indexb < b.length){
            c[indexc++] = b[indexb];
            indexb++;
        }
    }
}
