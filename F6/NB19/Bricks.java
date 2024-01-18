package F6.NB19;

public class Bricks {
    int array [];
    String steps;

    public Bricks() {
        this.array = new int[] {2,2,2,0,1,1,1};
    }

    private boolean isSolved(int array2[]){
        for(int i = 0; i < array2.length; i++){
            if(array2[0] == 1 && array2[1] == 1 && array2[2] == 1 && array2[3] == 0){
                System.out.println("Its solve");
                System.out.println(toString(array2));
                return true;
            }
        }
        //System.out.println("Its NOT solve");
        return false;
    }

    private int openPos(){
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                //System.out.println("Return from openPos= " + i);
                return i;
            }
        }
        return -1;
    }

    public boolean solve(){
        int open = openPos();
        return solve(array, "Steps start: ", open);
        //return solve(array, "Steps start: ");
    }

   /* private boolean solve(int array[], String steps){
        if(isSolved(array)){
            System.out.println(toString(array));
            System.out.println(steps);
            return true;
        }
        for(int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                //ett steg till höger
                if (i > 0 && array[i - 1] == 2) {
                    int array2[] = Arrays.stream(array).toArray();
                    array2[i] = 2;
                    array2[i - 1] = 0;
                    solve(array2, steps + (i - 1 + "->" + i + ", "));
                }
                //två steg till höger
                if (i > 1 && array[i - 2] == 2) {
                    int array2[] = Arrays.stream(array).toArray();
                    array2[i] = 2;
                    array2[i - 2] = 0;
                    solve(array2, steps + (i - 2 + "->" + i + ", "));

                }
                //ett steg till vänster
                if (i < array.length - 1 && array[i + 1] == 1) {
                    int array2[] = Arrays.stream(array).toArray();
                    array2[i] = 1;
                    array2[i + 1] = 0;
                    solve(array2, steps + (i + 1 + "->" + i + ", "));
                }
                //två steg till vänster
                if (i < array.length - 2 && array[i + 2] == 1) {
                    int array2[] = Arrays.stream(array).toArray();
                    array2[i] = 1;
                    array2[i + 2] = 0;
                    solve(array2, steps + (i + 2 + "->" + i + ", "));
                }
            }
        }

        return false;
    }*/

    private boolean solve(int array[], String steps, int open){
        if(isSolved(array)){
            System.out.println(steps);
            return true;
        }
        if(open > 0){
            if (array[open - 1] == 2) {
                array[open] = 2;
                array[open - 1] = 0;
                solve(array, steps + ((open - 1) + "->" + open + ", "), open - 1);
                array[open] = 0;
                array[open - 1] = 2;
            }
        }

        if(open > 1){
            if(array[open - 2] == 2){
                array[open] = 2;
                array[open - 2] = 0;
                solve(array, steps + ((open - 2) + "->" + open + ", "), open - 2);
                array[open] = 0;
                array[open - 2] = 2;
            }
        }
        if(open + 1 < array.length){
            if(array[open + 1] == 1){
                array[open] = 1;
                array[open + 1] = 0;
                solve(array, steps + ((open + 1) + "->" + open + ", "), open + 1);
                array[open] = 0;
                array[open + 1] = 1;
            }
        }
        if(open + 2 < array.length){
            if(array[open + 2] == 1){
                array[open] = 1;
                array[open + 2] = 0;
                solve(array, steps + ((open + 2) + "->" + open + ", "), open + 2);
                array[open] = 0;
                array[open + 2] = 1;
            }
        }
        return false;
    }

    public String toString(int arr[]){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i] + ", ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Bricks bricks = new Bricks();
        bricks.solve();
    }
}
