import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Exception;

public class TTTGame {
    protected APlayer player1;//to be used by sub classes
    protected APlayer player2;//^^^
    private board tttGame;
    protected Scanner in = new Scanner(System.in); //built in scanner


    public TTTGame() {
       System.out.println("Player 1");
       player1 = new APlayer(in);
       System.out.println("Player 2");
       player2 = new APlayer(in);
       tttGame = new board();
    }



    public boolean win(int row, int col, String mark, board tttGame){
        //logic for winner
         if (
                        (tttGame.getFill(row, 0).equals(mark) //checks horizontally
                        && tttGame.getFill(row, 1).equals(mark)
                        && tttGame.getFill(row, 2).equals(mark))
                ||
                        (tttGame.getFill(0, col).equals(mark) //checks vertically
                        && tttGame.getFill(1, col).equals(mark)
                        && tttGame.getFill(2, col).equals(mark))
                ||
                        (tttGame.getFill(0,0).equals(mark) //diagonals
                        && tttGame.getFill(1,1).equals(mark)
                        &&tttGame.getFill(2,2).equals(mark))
                ||
                        (tttGame.getFill(0,2).equals(mark)
                        && tttGame.getFill(1,1).equals(mark)
                        &&tttGame.getFill(2,0).equals(mark))
        ){
             tttGame.setWinner(mark);
             return true;
         }
         else
             return false;
    }

//    public boolean tie(){
//        return (tttGame.getEmptyBoxes() == 0);
//    }

    public void playGame() {
        //run on a for loop, odd time its player 1
        // even player is player two, and a modulo if statement can check can check whose turn it is
        for (int turns = 1; turns <= 9; turns++) { //for loop does away with needing a tie function
            tttGame.displayBoard();
            if (turns % 2 == 0) {
                //player two goes
                this.playerTurn(player2, this.tttGame);
                if (this.win(player2.getRow(), player2.getCol(), player2.getMark(), this.tttGame)) {
                    System.out.println(player2.getName() + " wins!");
                    player2.increWin();
                    break;
                }

            }
            else { //player 1 turn
                this.playerTurn(player1, this.tttGame);
                if (this.win(player1.getRow(), player1.getCol(), player1.getMark(), this.tttGame)) {
                    System.out.println(player1.getName() + " wins!");
                    player1.increWin();
                    break;
                }
            }

        }

    }

    protected void playerTurn(APlayer player, board tttGame) {
        //makes sure the right box is picked

        int num = 0;
        //num = in.nextInt();
        do {
            System.out.println("Select the box you want to mark!");
            while (!in.hasNextInt()) {
                System.out.println("That's not a number!");
                in.next();
            }
            num = in.nextInt();

        }while (!(num > 0 && num < 10));


            player.selectBox(num);
            while (!(player.getCol() >= 0 && player.getCol() <= 2 && player.getRow() >= 0 && player.getRow() <= 2
                    && !tttGame.isBoxEmpty(player.getRow(), player.getCol()))) {

                //check if its empty
                if (tttGame.isBoxEmpty(player.getRow(), player.getCol())) {
                    System.out.println("Invalid box");
                    num = in.nextInt();
                    player.selectBox(num);
                }
            }

            tttGame.selectBox(player.getRow(), player.getCol(), player.getMark());
        }
    }


