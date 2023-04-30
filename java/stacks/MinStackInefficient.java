import java.util.Stack;

public class MinStackInefficient {

    private Stack<Integer> main;
    private Stack<Integer> auxilliary;

    public MinStackInefficient ( ) {
        main = new Stack<> ();
        auxilliary = new Stack<> ();
    }

    public int top () {
        if ( main.isEmpty () ) {
            throw new NullPointerException ( "StackOverflow" );
        }
        return main.peek ();
    }

    public void push ( int data ) {
        main.push ( data );

        if ( auxilliary.isEmpty () || data < auxilliary.peek () ) {
            auxilliary.push ( data );
        }
    }

    public void pop ( ) {
        if ( main.isEmpty () ) {
            throw new NullPointerException ( "StackOverflow" );
        }

        if ( main.peek () == auxilliary.peek () ) {
            auxilliary.pop ();
        }

        main.pop ();
    }

    public int getMin ( ) {
        if ( auxilliary.isEmpty () ) {
            throw new NullPointerException ( "StackOverflow" );
        }

        return auxilliary.peek ();
    }

}
