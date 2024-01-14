package F6.NB19;

public class Bricks {
    int array [];
    String steps;

    public Bricks() {
        this.array = new int[] {1,1,1,0,1,1,1};
    }

    private boolean isSolved(){
        for(int i = 0; i < array.length; i++){
            if(array[0] == 1 && array[1] == 1 && array[2] == 1 && array[3] == 0){
                return true;
            }
        }
        return false;
    }

    private int openPos(){
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                return array[i];
            }
        }
        return -1;
    }

    public boolean solve(){
        int open = openPos();
        return solve(array, steps, open);
    }

    private boolean solve(int array[], String steps, int open){
        if(isSolved()){
            System.out.println(steps);
            return true;
        }




        return true;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            sb.append(array[i] + ", ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Bricks bricks = new Bricks();
        System.out.println(bricks.toString());
        System.out.println(bricks.solve());

    }
}
