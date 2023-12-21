package F1.NB1;

public class SelfCheck {
    public static void main(String[] args) {
        int[] anArray = {0, 1, 2, 3, 4, 5, 6, 7};
        /*for (int i = 3; i < anArray.length - 1; i++) {
            anArray[i + 1] = anArray[i];
        }*/
        //Will be {0 ,1 ,2 , 3, 3, 3, 3, 3}

        for (int i = 0; i < anArray.length; i++) {
            System.out.print(anArray[i] + " ");
        }


        for (int i = anArray.length - 1; i > 3; i--) {
            anArray[i] = anArray[i - 1];
        }
        System.out.println();
        //Will be {0 , 1, 2, 3, 3, 4, 5, 6}
        for (int i = 0; i < anArray.length; i++) {
            System.out.print(anArray[i] + " ");
        }
    }


}


