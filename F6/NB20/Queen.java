package F6.NB20;

public class Queen {
    int board [][] = new int[8][8];
    public Queen() {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = 0;
            }
        }
    }

    public boolean addQueen(){
        return addQueen(0 ,0);
    }

    private boolean addQueen(int row, int col){
        if(legalCheck(row, col)){

        }
        return false;
    }

    private boolean legalCheck(int row, int col){
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == 0) return true;
        }
        for(int i = row; i < board.length; i++){
            for(int j = col; j < board.length; j++){
                if(board[i][j] == 0) return true;
            }
        }
        return false;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                sb.append(board[i][j] + ", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Queen queen = new Queen();
        System.out.println(queen.toString());
        System.out.println(queen.legalCheck(1,1));


    }

}
