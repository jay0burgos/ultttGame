import java.lang.*;
import java.util.Scanner;

public class APlayer {
    private String name;
    private String mark;
    private int wins = 0;
    private int row;
    private int col;
    private int box;

    public APlayer(Scanner in) {
        System.out.println("Enter name and mark you want to use!:");
        name = in.next();
        mark = in.next();
    }

    public void  selectBox( int num){ //used to set the 
        box = num;
        switch (num) {
            case 1:
                row = 0;
                col = 0;
                //System.out.println("picking 1");
                break;
            case 2:
                row = 0;
                col = 1;
                //System.out.println("picking 2");
                break;
            case 3:
                row = 0;
                col = 2;
                //System.out.println("picking 3");
                break;
            case 4:
                row = 1;
                col = 0;
                //System.out.println("picking 4");
                break;
            case 5:
                row = 1;
                col = 1;
                //System.out.println("picking 5");
                break;
            case 6:
                row = 1;
                col = 2;
                //System.out.println("picking 6");
                break;
            case 7:
                row = 2;
                col = 0;
                //System.out.println("picking 7");
                break;
            case 8:
                row = 2;
                col = 1;
                //System.out.println("picking 8");
                break;
            case 9:
                row = 2;
                col = 2;
                //System.out.println("picking 9");
                break;

        }
    }

    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void increWin(){
        wins++;
    }

    public int getWins(){
        return wins;
    }

    public int getBox() {
        return box;
    }
    //added this to be called in the case that mark needs to be change when both players got the same mark
    public void setMark() {
        System.out.println("Enter a new mark: ");
        Scanner in = new Scanner(System.in);
        this.mark = in.next();
    }
}








