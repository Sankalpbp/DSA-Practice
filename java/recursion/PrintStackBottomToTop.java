import java.util.Stack;

public class PrintStackBottomToTop {

    public static void print ( Stack<Integer> stack ) {

        if ( stack.isEmpty () ) {
            return;
        }

        int key = stack.pop ();
        print ( stack );

        System.out.println ( key );
        stack.push ( key );
    }
}
