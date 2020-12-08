import java.util.ArrayList;

/**
 * Abstract class MazeSolver - write a description of the class here
 *
 * @author gcschmit, Adrian Tse, Joey Rubas
 * @version 2 June 2017
 */
public abstract class MazeSolver
{
    // instance variables - replace the example below with your own
    protected Maze maze;
    private Square end;
    boolean foundExit;

    /**
     * Constructor
     *
     *  @param maze the maze to solve
     */
    MazeSolver(Maze maze)
    {
        this.maze = maze;
        this.makeEmpty();
        this.add( this.maze.getStart() );
    }

    /**
     * Create an empty worklist
     *
     */
    public abstract void makeEmpty();

    /**
     * Returns true if the worklist is empty
     *
     *  @return true if the worklist is empty
     */
    public abstract boolean isEmpty();

    /**
     * Adds the specified square to the worklist
     *
     *  @param the square to add to the worklist
     */
    public abstract void add( Square sq );

    /**
     * Returns the next item from the worklist
     *
     *  @return the next item from the worklist
     */
    public abstract Square next();

    /**
     * Returns true if either: A path from the start to the exit has been found; OR
     *      You determine there is no such path (worklist is now empty)
     *
     *  @return if the maze is solved
     */
    boolean isSolved(){
        return this.foundExit || isEmpty();
    }


    /**
     * Returns either a string of the solution path as a list of coordinates [i,j]
     *      from the start to the exit or a message indicating no such path exists.
     *      If the maze isn't solved, a message is returned indicating such.
     *
     *  @return if the solution path if such a path exists
     */
    public String getPath()
    {
        String path = "";
        Square current = end;
        if (end == null)
            return "no path";

        while(current.getType() != 2){
            path = " --> [" + current.getCol() + " , " + current.getRow() + " ]" + path;
            current = current.getPrev();
        }
        return path;

    }

    /**
     * Perform one iteration of the algorithm above (i.e., steps 1 through 5) and
     *      return the Square that was just explored (and null if no such Square exists).
     *
     *  @return the Square that was just explored (and null if no such Square exists)
     */
    public Square step()
    {
        // check if the maze cannot be solved
        if(this.isEmpty() )
        {
            return null;
        }

        Square next = next();
        next.setState(Square.State.EXPLORED);
        System.out.println("Type is " + next.getType());

        
        ArrayList<Square> neighbors = maze.getNeighbors(next);
        for (Square sq : neighbors){
            if (sq.getType() == 0 && sq.getState().equals(Square.State.UNEXPLORED)){
                sq.setState(Square.State.ON_WORK_LIST);
                sq.setPrev(next);
                add(sq);
            }

            else if (sq.getType() == 3){
                System.out.println("Found exit!");
                sq.setPrev(next);
                this.foundExit = true;
                end = sq;
                System.out.println(this.getPath());
                return sq;

            }
        }

        System.out.println();
        return next;
    }

    /**
     * Repeatedly calls step() until you get to the exit square or the worklist is empty.
     *
     */
    public void solve(){
        this.foundExit = false;
        this.makeEmpty();
        this.add(this.maze.getStart());
        while (! this.isSolved()){
            this.step();
        }

    }
}
