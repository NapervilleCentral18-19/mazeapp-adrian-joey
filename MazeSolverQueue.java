
/**
 * Write a description of class MazeSolverQueue here.
 *
 * @Adrian Tse, Joey Rubas
 * @version (a version number or a date)
 */
public class MazeSolverQueue extends MazeSolver
{
    MyQueue queue;

    /**
     * Constructor
     *
     *  @param maze the maze to solve
     */
    public MazeSolverQueue(Maze maze)
    {
        super(maze);
    }
    
    /**
     * Create an empty worklist
     *
     */
    public void makeEmpty()
    {
        queue = new MyQueue();
    }
    
    /**
     * Returns true if the worklist is empty
     *
     *  @return true if the worklist is empty
     */
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }
    
    /**
     * Adds the specified square to the worklist
     *
     *  @param the square to add to the worklist
     */
    public void add(Square sq)
    {
        System.out.println("here");
        System.out.println(sq);
        queue.enqueue(sq);
    }
    
    /**
     * Returns the next item from the worklist
     *
     *  @return the next item from the worklist
     */
    public Square next()
    {
        System.out.println(queue);
        return (Square) queue.dequeue();
}
}
