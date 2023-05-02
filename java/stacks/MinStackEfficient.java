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

    public void push ( int data ) {

        if ( main.isEmpty () ) {
            main.push ( data );
            minimum = data;
            return;
        }

        if ( data < minimum ) {
            int newData = 2 * data - minimum;
            minimum = data;
            main.push ( newData );
        } else if ( data >= minimum ) {
            main.push ( data );
        }

    }

    public int top ( ) throws NullPointerException {
        if ( main.isEmpty () ) {
            throw new NullPointerException ( "StackOverflow" );
        }

        if ( main.peek () >= minimum ) {
            return main.peek ();
        }

        if ( main.peek () < minimum ) {
            return minimum;
        }

        return -1;
    }
    
    public void pop () throws NullPointerException {
        if ( main.isEmpty () ) {
            throw new NullPointerException ( "StackOverflow" );
        }

        if ( main.peek () >= minimum ) {
            main.pop ();
            return;
        }

        if ( main.peek () < minimum ) {
            minimum = 2 * minimum - main.peek ();
            main.pop ();
            return;
        }
        
    }

    public boolean isEmpty () {
        return main.isEmpty ();
    }

}
