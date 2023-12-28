package F5.NB11;

public class ArrayIntRec {


    public static int findBig(int[] intArr){
        return findBig(intArr, 0, 0);
    }

    private static int findBig(int[] intArr, int i, int biggest){
        if(i == intArr.length) return biggest;
        if(biggest < intArr[i]){
            //System.out.println(biggest);
            biggest = intArr[i];
        }
        return findBig(intArr, i+1, biggest);
    }

    public static void main(String[] args) {

        int[] intArray = {2, 3, 5, 7, 1, 6};

        System.out.println(findBig(intArray));
    }
}
