
/**
 * Write a description of class MazeSolverStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MazeSolverStack implements MazeSolver
{
    MyStack stack;

    public MazeSolverStack()
    {
        stack = new MyStack();
    }
    
    public void makeEmpty()
    {
        stack = new MyStack();
    }
    
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public void add(Square sq)
    {
        stack.push(sq);
    }
    
    public Square next()
    {
        //IDK
    }
    
    
}
