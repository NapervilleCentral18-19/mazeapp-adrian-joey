
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyQueue<T> implements QueueADT<T>
{
    private ArrayList<T> queue;
    /**
     * Constructor
     *
     */
    public MyQueue()
    {
        this.queue = new ArrayList<T>();
    }
    
    public void enqueue(T t)
    {
        this.queue.add(t);
    }
    
    public T dequeue()
    {
        T value = this.queue.get(0);
        this.queue.remove(0);
        return value;
    }
    
    public T front()
    {
        return this.queue.get(0);
    }
    
    public int size()
    {
        return queue.size();
    }
    
    public boolean isEmpty()
    {
        return this.queue.size() == 0;
    }
    
    public void clear()
    {
        this.queue = new ArrayList<T>();
    }
}
