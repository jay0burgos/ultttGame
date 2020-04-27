import java.lang.*;

public class board {

    private box board[][];
    //private boolean ifFull = false;
    private int boardNumber;
    private int emptyBoxes = 9;
    private String winner;
    private boolean tie;
    private boolean hasAWinner;



    public board() {
        int num = 1;
       board = new box[3][3]; //initilizes the board
       for(int row = 0; row < 3; row++)
       {
           for(int col = 0; col < 3; col++){
               board[row][col] = new box(String.valueOf(num));
               num++;
           }
       }

    }



    //overloaded constructor used when playing ult-TTT game, assigns board number
    public board(int boardNumber) {
        hasAWinner = false;
        tie = false;
        int num = 1;
        board = new box[3][3]; //initilizes the board
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++){
                board[row][col] = new box(String.valueOf(num));
                num++;
            }
        }
        this.boardNumber = boardNumber; //inputs board number
        //System.out.println("intilizing "+ boardNumber);
    }
    //method that displays the board number and the row, used when playing Ultimate TicTacToe
    public  void displayRow(int row){ //prints a specified row
        System.out.print("BOARD#" + this.boardNumber + " | " + this.board[row][0].getMark() + " | " + this.board[row][1].getMark() + " | " + this.board[row][2].getMark() + " |\t");

    }

    public void displayBoard(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                System.out.print(" " + board[row][col].getMark() + " ");
                if(col < 2){
                    System.out.print("|");
                }
            }
            System.out.println();
            if( row < 2){
                System.out.println("-----------"); //displays horizontal line
            }
        }
        System.out.println();
    }

    public boolean isBoxEmpty(int row, int col){
        return board[row][col].isFilled();
    }

    public String getFill(int row, int col){
        return board[row][col].getMark();
    }

    public void selectBox(int row, int col, String mark){
        board[row][col].setMark(mark);
        emptyBoxes--;
        if(emptyBoxes == 0)// if no empty boxes are left, sets the board to tie
        {
            this.setTie();
        }
    }
    public void setTie() {
        this.tie = true;
    }


    public void setHasAWinner(boolean hasAWinner) {
        this.hasAWinner = hasAWinner;
    }

    public void setWinner(String winner) {
        setHasAWinner(true);
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }

    public boolean getTie() {
        return tie;
    }

    public boolean getHasAWinner() {
        return hasAWinner;
    }


}
