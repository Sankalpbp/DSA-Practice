import java.util.Stack;

public class MinStackNaive {

    private Stack<Integer> main;
    private Stack<Integer> auxilliary;

    public MinStackNaive ( ) {
        main = new Stack<> ();
        auxilliary = new Stack<> ();
    }

    public int top ( ) {
        return main.peek ();
    }

    public void push ( int data ) {
        main.push ( data );

        if ( auxilliary.isEmpty () ) {
            auxilliary.add ( data );
        } else if ( data >= auxilliary.peek () ) {
            auxilliary.add ( auxilliary.peek () );
        } else {
            auxilliary.add ( data );
        }
    }

    public void pop () {
        if ( main.isEmpty () ) {
            throw new NullPointerException ( "StackOverflow" );
        }

        main.pop ();
        auxilliary.pop ();
    }

    public int getMin ( ) {
        if ( auxilliary.isEmpty () ) {
            throw new NullPointerException ( "StackOverflow" );
        }

        return auxilliary.peek ();
    }

}
