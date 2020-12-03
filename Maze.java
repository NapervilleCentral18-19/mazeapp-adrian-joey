import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * Stores the logical layout of a maze.
 *
 * @author gcschmit
 * @version 1 June 2017
 */
public class Maze
{
    private Square[][] maze;
    private Square start;
    private Square end;
    private String fname;

    /**
     * Constructor for objects of class Maze
     */
    public Maze()
    {
    }

    /**
     * Loads the maze from the specified file
     *
     * @param  fname  the name of the file containing the maze to be loaded
     * @return    true if the maze was successfully loaded; otherwise, false
     */
    public boolean loadMaze( String fnameIn )
    {
        fname = fnameIn;

        try{
            File mazeFile = new File( fname );
            Scanner in = new Scanner(mazeFile);
            String[] rowArr = in.nextLine().split(" ");
            int numRows = Integer.parseInt(rowArr[0]);
            int numCols = Integer.parseInt(rowArr[1]);

            this.maze = new Square[numRows][numCols];
            for (int row=0; row < numRows; row++) {
                rowArr = in.nextLine().split(" ");
                for (int col=0; col < numCols; col++) {
                    int type = Integer.parseInt(rowArr[col]);
                    maze[row][col] = new Square(row, col, type);
                    if (type == 2){
                        start = maze[row][col];
                    }
                    else if (type == 3){
                        end = maze[row][col];
                    }
                }
            }
        }
        catch(Exception e) {
            return false;

        }
        return true;
    }

    /**
     * Returns a list of the neighbors of the specified square
     *
     * @param  sq  the square whose neighbors to return
     * @return    a list of the neighbors of the specified square
     */
    public ArrayList<Square> getNeighbors( Square sq )
    {
        ArrayList<Square> neighbors = new ArrayList<Square>();
        int r = sq.getRow();
        int c = sq.getCol();
        if (r > 0){
            neighbors.add(maze[r-1][c]);
        }
        if (r < maze.length - 1){
            neighbors.add(maze[r+1][c]);
        }
        if (c > 0){
            neighbors.add(maze[r][c-1]);
        }
        if (c < maze[0].length - 1){
            neighbors.add(maze[r][c+1]);
        }
        return neighbors;
    }

    /**
     * Returns the start square
     *
     * @return    the start square
     */

    Square getStart(){
        return start;
    }

    /**
     * Returns the finish square
     *
     * @return    the finish square
     */

    Square getEnd(){
        return end;
    }

    /**
     * Returns the maze back to the initial state after loading.
     *
     */

    public void reset(){
        loadMaze(fname);
    }

    /**
     * toString
     *
     * @return    string representation of the maze
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for( int row = 0; row < this.maze.length; row++ )
        {
            for( int col = 0; col < this.maze[row].length; col++ )
            {
                sb.append( this.maze[row][col].toString() + " " );
            }

            sb.append( "\n" );
        }

        return new String( sb );
    }

}
