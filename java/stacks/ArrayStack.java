import java.util.List;
import java.util.ArrayList;

public class ArrayStack {

    private List<Integer> stack;
    private int _top;
    private int _size;

    public ArrayStack ( ) {
        stack = new ArrayList<> ();
        this._top = -1;
        this._size = 0;
    }

    public int size ( ) {
        return this._size;
    }

    public int top ( ) throws NullPointerException {
        if ( this._top == -1 ) {
            throw new NullPointerException ( "Stack Underflow" );
        }
        return this.stack.get ( this._top );
    }

    public void push ( int data ) {
        this.stack.add ( data );
        ++ ( _size );
        ++ ( _top );
    }

    public void pop ( ) {
        -- ( _size );
        -- ( _top );
    }
    
}
