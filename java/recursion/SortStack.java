import java.util.Stack;

public class SortStack {

    public static void sort ( Stack<Integer> stack ) {

        if ( stack.isEmpty () ) {
            return;
        }

        int key = stack.pop ();
        sort ( stack );

        putAtCorrectPosition ( stack, key );
    }

    private static void putAtCorrectPosition ( Stack<Integer> stack, int key ) {
        if ( stack.isEmpty () ) {
            stack.push ( key );
            return;
        }

        if ( stack.peek () > key ) {
            stack.push ( key );
            return;
        }

        int topElement = stack.pop ();
        putAtCorrectPosition ( stack, key );

        stack.push ( topElement );
    }
}
