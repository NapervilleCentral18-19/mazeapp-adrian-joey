import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Implementation of a stack
 *
 * @Adrian Tse, Joey Rubas
 * @version 1
 */
public class MyStack<T> implements StackADT<T>
{
    private ArrayList<T> stack;


    /**
     * Constructor
     *
     */
    public MyStack()
    {
        this.stack = new ArrayList<T>();
    }


    /**
     * Add an item onto the stack
     * @param item the data item to add (of type T)
     */
    public void push(T t)
    {
        this.stack.add(t);
    }





    /**
     * Remove the top item from the stack
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T pop() throws NoSuchElementException
    {
        T value = this.stack.get(this.stack.size() - 1);
        this.stack.remove(this.stack.size() - 1);
        return value;
    }

    /**
     * Display the top item from the stack without removing it
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T top() throws NoSuchElementException
    {
        return this.stack.get(this.stack.size() - 1);
    }

    /**
     * Find how many items are in the stack
     * @return the number of items in the stack
     */

    public int size()
    {
        return this.stack.size();
    }



    /**
     * Determine if the stack is empty
     * @return true if the size is 0, false otherwise
     */

    public boolean isEmpty()
    {
        return this.stack.size() == 0;
    }



    /**
     * Clear out the data structure
     */
    public void clear()
    {
        this.stack.clear();
    }

    public String toString()
    {
        String str = "[";
        for(T t:stack)
            str += t + ", ";
        str += "]";

        return str;
    }
}
