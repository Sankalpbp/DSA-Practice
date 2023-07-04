import java.util.Stack;

public class PrintStackTopToBottom {

    public static void print ( Stack<Integer> stack ) {
        if ( stack.isEmpty () ) {
            return;
        }

        int key = stack.pop ();
        System.out.println ( key );

        print ( stack );

        stack.push ( key );
    }
}
