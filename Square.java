
/**
 * Represents a single square in the maze.
 *
 * @author gcschmit
 * @version 1 June 2017
 */
public class Square
{

    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int START = 2;
    public static final int EXIT = 3;

    // the state of the square in the context of the maze solver
    public enum State
    {
        UNEXPLORED,     // '_'
        ON_WORK_LIST,   // 'o'
        EXPLORED,       // '.'
        ON_PATH         // 'x'
    };

    private int row;
    private int col;
    private int type;
    private Square prev;
    private State state;    // this is required for the GUI to display progress

    /**
     * Constructor for objects of class Square
     * @param row col type
     */
    public Square(int row1, int col1, int type1){
        row = row1;
        col = col1;
        type = type1;
        
        state = State.UNEXPLORED;
    
    }
    


    /**
     * Returns this square's row
     *
     * @return    this square's row
     */
    public int getRow(){
        return row;
    }

    /**
     * Returns this square's column
     *
     * @return    this square's column
     */
    public int getCol(){
        return col;
    }

    /**
     * Returns this square's type
     *
     * @return    this square's type
     */
    public int getType(){
        return type;
    }


    /**
     * Returns this square's previous square
     *
     * @return    this square's previous square
     */
    public Square getPrev()
    {
        return this.prev;
    }
    
    
    /**
     * Returns this square's state
     *
     * @return    this square's previous square
     */
    public State getState()
    {
        return this.state;
    }

    /**
     * Sets the previous square to the specified square
     *
     */
    public void setPrev( Square prev )
    {
        this.prev = prev;
    }

    /**
     * Sets the square's state to the specified state
     *
     */
    public void setState(State newState){
        state = newState;
    }


    /**
     * Resets this square
     *
     */
    
    public void reset(){
        state = State.UNEXPLORED;
    }
    
    

    /**
     * toString method
     *
     * @return    string representation of the square
     * _, o, ., x, #, S, E
     */
    public String toString(){
        if (state.equals(State.UNEXPLORED))    
            return "_";
        else if (state.equals(State.ON_WORK_LIST))
            return "o";
        else if (state.equals(State.EXPLORED))
            return ".";
        else 
            return "x";
    
    }

}
