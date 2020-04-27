public class UltimateTTTGame extends TTTGame {

    //create an array of 9 Boards
    public board UltTTTBoards[] = new board[9]; //for ai player, assign a return method for the board
    private String winner;
    private int remainingboards = 9;

    public UltimateTTTGame(){
        super(); //calls parents constructor to set up player one and two
        while(player1.getMark().equals(player2.getMark())){ //if marks are the same, It will prompt player
            player2.setMark();                              //2 to enter a new mark
        }
        for (int i = 0; i < 9 ; i++){
            this.UltTTTBoards[i] = new board(i); //initiliazes every board with the overloaded constructor
        }
        winner = "";
    }

    public void displayBoard(){ //method to display the board

       int board1 = 0;
       int board2 = 1;
       int board3 = 2;

       for (int i = 0; i <3 ; i++){
           for(int row =0; row < 3; row++){//for the rows
               //System.out.println("row "+ row);
               UltTTTBoards[board1].displayRow(row);
               UltTTTBoards[board2].displayRow(row);
               UltTTTBoards[board3].displayRow(row);
               System.out.println();
           }
           if(i != 2)    //seperates the boards horizontally for ease of view
            System.out.println("---------------------------------------------------------------------");
           board1 +=3;
           board2 +=3;
           board3 +=3;
       }
        for(int i = 0; i < 9; i++){
            if(this.UltTTTBoards[i].getHasAWinner()){
                System.out.println("Board " + i + " won by: " + this.UltTTTBoards[i].getWinner());
            }
        }
    }

    public void playUltTTTGame(){
    //create a method to check if the board has been won or tied
    //decrease variable
        int nextboard;
        this.displayBoard();
        //execute first player run and then assign the next board variable
        System.out.println("Current player is: " + player1.getName());
        do{
            System.out.println("Select the board you want to mark!");
            while (!in.hasNextInt()) {
                System.out.println("That's not a number!");
                in.next();
            }
            nextboard = in.nextInt();
        }while(!(nextboard > -1 && nextboard < 9));

        int playerturn = 1;
        do
        {
            this.displayBoard();
            System.out.println("Current Board picked is: "+ nextboard);
            if(playerturn%2 == 0)
                { //player 2 goes
                    System.out.println("Player 2-");
                            while(this.UltTTTBoards[nextboard].getTie()){ //loops until a valid board is choosen
                                System.out.println("Select a valid board: ");
                                nextboard = in.nextInt();
                            }
                    this.playerTurn(player2, this.UltTTTBoards[nextboard]);

                    //if board hasnt already been won and if theres a win detected executes to assign board as won and assigns its winner
                    if(!this.UltTTTBoards[nextboard].getHasAWinner() && this.win(player2.getRow(), player1.getCol(), player2.getMark(), this.UltTTTBoards[nextboard]))
                    {
                        this.UltTTTBoards[nextboard].setWinner(player2.getMark()); //if win returns true, winner is set
                        //this.UltTTTBoards[nextboard].setHasAWinner(true);
                        System.out.println("Player 2 won board " + nextboard );
                        remainingboards--;
                    }
                    nextboard = player2.getBox()-1;//
                    playerturn++;
                }
            else
                { //player 1 goes
                    System.out.println("Player 1-");
                    while(this.UltTTTBoards[nextboard].getTie()){
                        System.out.println("Select a valid board: ");
                        nextboard = in.nextInt();
                    }
                    this.playerTurn(player1, this.UltTTTBoards[nextboard]);

                    //if board hasnt already been won and if theres a win detected executes to assign board as won and assigns its winner
                    if(!this.UltTTTBoards[nextboard].getHasAWinner() && this.win(player1.getRow(), player1.getCol(), player1.getMark(), this.UltTTTBoards[nextboard]))
                        {
                            this.UltTTTBoards[nextboard].setWinner(player1.getMark()); //if win returns true, winner is set
                            //this.UltTTTBoards[nextboard].setHasAWinner(true);
                            System.out.println("Player 1 won board " + nextboard);
                            remainingboards--;
                        }
                    nextboard = player1.getBox()-1;//
                    playerturn++;
                }


        }while(!this.hasWon() && !this.tie());
        if(hasWon())
        System.out.println(this.winner + " HAS WON!!!");
        if(tie())
            System.out.println("Tie!!!");

    }

    //checks if there's a win
    public boolean hasWon(){
        if (UltTTTBoards[0].getHasAWinner()) //has a nested loop in order to avoid unnecessary checks
        {
            if(//checks the diagonal, horizontal, and vertical row from 0
                         UltTTTBoards[0].getWinner().equals(UltTTTBoards[1].getWinner()) && UltTTTBoards[0].getWinner().equals(UltTTTBoards[2].getWinner())
                    ||
                         UltTTTBoards[0].getWinner().equals(UltTTTBoards[4].getWinner()) && UltTTTBoards[0].getWinner().equals(UltTTTBoards[8].getWinner())
                    ||
                         UltTTTBoards[0].getWinner().equals(UltTTTBoards[3].getWinner()) && UltTTTBoards[0].getWinner().equals(UltTTTBoards[6].getWinner())
              )
                {
                    this.winner = UltTTTBoards[0].getWinner();
                    return true;
                }
        }
        if (UltTTTBoards[1].getHasAWinner()) //has a nested loop in order to avoid unnecessary checks
        {
            if (//checks the diagonal, horizontal, and vertical row from 0
                    UltTTTBoards[1].getWinner().equals(UltTTTBoards[4].getWinner()) && UltTTTBoards[1].getWinner().equals(UltTTTBoards[7].getWinner())
            ) {
                this.winner = UltTTTBoards[1].getWinner();
                return true;
            }
        }
        if (UltTTTBoards[2].getHasAWinner()) //has a nested loop in order to avoid unnecessary checks
        {
            if(//checks the diagonal, horizontal, and vertical row from 0
                            UltTTTBoards[2].getWinner().equals(UltTTTBoards[5].getWinner()) && UltTTTBoards[2].getWinner().equals(UltTTTBoards[8].getWinner())
                            ||
                            UltTTTBoards[2].getWinner().equals(UltTTTBoards[4].getWinner()) && UltTTTBoards[2].getWinner().equals(UltTTTBoards[6].getWinner())
            )
            {
                this.winner = UltTTTBoards[2].getWinner();
                return true;
            }
        }
        if (UltTTTBoards[3].getHasAWinner()) //has a nested loop in order to avoid unnecessary checks
        {
            if(//checks the diagonal, horizontal, and vertical row from 0
                    UltTTTBoards[3].getWinner().equals(UltTTTBoards[4].getWinner()) && UltTTTBoards[3].getWinner().equals(UltTTTBoards[5].getWinner())
              )
            {
                this.winner = UltTTTBoards[3].getWinner();
                return true;
            }
        }

        if (UltTTTBoards[6].getHasAWinner()) //has a nested loop in order to avoid unnecessary checks
        {
            if(//checks the diagonal, horizontal, and vertical row from 0
                    UltTTTBoards[6].getWinner().equals(UltTTTBoards[7].getWinner()) && UltTTTBoards[6].getWinner().equals(UltTTTBoards[8].getWinner())
              )
            {
                this.winner = UltTTTBoards[6].getWinner();
                return true;
            }
        }
        return false;
    }

    public boolean tie(){
        if(this.remainingboards == 0){
            return true;
        }
        else
            return false;
    }
}

