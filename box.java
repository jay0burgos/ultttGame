


 import java.lang.*;


public class box {
    private String mark;
    private boolean filled;

    public box(){ //default constructor
        mark = " ";
        filled = false;
    }
    //updated overloaded constructor to assign a number to the box to make box selection
    //easier
    public box(String mark){
        this.mark = mark;
        filled = false;
    }

    public String getMark() {
        return mark;
    }

    //stores the mark the user wants to use
    public void setMark(String mark) {
        this.mark = mark;
        filled = true;
    }

    public boolean isFilled() {
        return filled;
    }
}






