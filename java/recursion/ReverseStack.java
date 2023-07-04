import java.util.Stack;

public class ReverseStack {

    public static void reverse ( Stack<Integer> stack ) {

        if ( stack.isEmpty () ) {
            return;
        }

        int key = stack.pop ();

        reverse ( stack );

        putAtBottom ( stack, key );
    }

    private static void putAtBottom ( Stack<Integer> stack, int key ) {

        if ( stack.isEmpty () ) {
            stack.push ( key );
            return;
        }

        int topElement = stack.pop ();

        putAtBottom ( stack, key );

        stack.push ( topElement );
    }
}
