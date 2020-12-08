
/**
 * Write a description of class MazeSolverStack here.
 *
 * @Adrian Tse, Joey Rubas
 * @version (a version number or a date)
 */
public class MazeSolverStack extends MazeSolver
{
    MyStack stack;

    /**
     * Constructor
     *
     *  @param maze the maze to solve
     */
    public MazeSolverStack(Maze maze)
    {
        super(maze);
    }
    
    /**
     * Create an empty worklist
     *
     */
    public void makeEmpty()
    {
        stack = new MyStack();
    }
    
    /**
     * Returns true if the worklist is empty
     *
     *  @return true if the worklist is empty
     */
    public boolean isEmpty()
    {
        return stack.isEmpty();
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
        stack.push(sq);
    }
    
    /**
     * Returns the next item from the worklist
     *
     *  @return the next item from the worklist
     */
    public Square next()
    {
        System.out.println(stack);
        return (Square) stack.pop();
}
}
