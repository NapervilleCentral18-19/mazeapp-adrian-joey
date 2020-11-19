
/**
 * Write a description of class MazeTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MazeTester
{
    public static void main(String[] args)
    {
        Maze mz = new Maze();
        mz.loadMaze("maze-1");
        System.out.println(mz.toString());
    }
}
