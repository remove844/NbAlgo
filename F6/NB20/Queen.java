package F6.NB20;

public class Queen {
    int board [][];
    public Queen(int row, int col){
        this.board = new int[row][col];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = 0;
            }
        }
    }

    public boolean addQueen() {
        return addQueen(0, "");
    }

    private boolean addQueen(int col, String positions) {
        if (col == board.length) {
            System.out.println(positions);
            return true;
        }

        for (int row = 0; row < board.length; row++) {
            if (legalCheck(row, col)) {
                board[row][col] = 1;
                if (addQueen(col + 1, positions + "(" + row + ", " + col + "), ")) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    /*private boolean legalCheck(int row, int col){
        for(int i = 0; i < col; i++){
            if(board[row][i] == 1) return false;
        }
        for (int i = row; i >= 0; i--) {
            for (int j = col; j >= 0; j--) {
                if (row - i == col - j) {
                    if (board[i][j] == 1) return false;
                }
            }
        }
        for (int i = row; i >= 0; i++) {
            for (int j = col; j >= 0; j--) {
                if (row - i == col - j) {
                    if (board[i][j] == 1) return false;
                }
            }
        }
        return true;
    }*/

    private boolean legalCheck(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                sb.append(board[i][j] == 1 ? "Q " : "- ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Queen queen = new Queen(8,8);
        if (queen.addQueen()) {
            System.out.println("En lösning:");
            System.out.println(queen);
        } else {
            System.out.println("Ingen lösning hittades.");
        }
    }

}
