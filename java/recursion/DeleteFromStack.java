import java.util.Stack;

public class DeleteFromStack {

    public static void delete ( Stack<Integer> stack, int element ) {
        if ( stack.isEmpty () ) {
            return;
        }

        if ( stack.peek () == element ) {
            stack.pop ();
            return;
        }

        int topElement = stack.pop ();
        delete ( stack, element );
        stack.push ( topElement );
    }
}
