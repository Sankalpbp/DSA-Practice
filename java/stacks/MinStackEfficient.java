import java.util.Stack;

public class MinStackEfficient {

    private Stack<Integer> main;
    private int minimum;

    public MinStackEfficient ( ) {
        main = new Stack<> ();
    }

    public int getMin ( ) {
        return minimum;
    }

    public int top () {
        if ( main.isEmpty () ) {
            throw new NullPointerException ( "StackOverflow" );
        }
        return ( main.peek () >= minimum ) ? main.peek () : minimum;
    }

    public void push ( int data ) {
        if ( main.isEmpty () ) {
            main.push ( data );
            minimum = data;
            return;
        }

        if ( data >= minimum ) {
            main.push ( data );
        } else {
            main.push ( 2 * data - minimum );
            minimum = data;
        }
    }

    public void pop () {
        if ( main.isEmpty () ) {
            throw new NullPointerException ( "StackOverflow" );
        }

        if ( main.peek () <= minimum ) {
            minimum = 2 * minimum - main.peek ();
        }

        main.pop ();
    }

}
