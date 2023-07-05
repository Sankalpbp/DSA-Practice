import java.util.Stack;

public class DeleteMiddleElementFromStack {

    public static void delete ( Stack<Integer> stack ) {
        delete ( stack, 0, stack.size () / 2 );
    }

    private static void delete ( Stack<Integer> stack, int i, int middleElementIndex ) {
        if ( stack.isEmpty () ) {
            return;
        }

        if ( stack.size () == 1 || i == middleElementIndex ) {
            stack.pop ();
            return;
        }

        int topElement = stack.pop ();
        delete ( stack, i + 1, middleElementIndex );
        stack.push ( topElement );
    }
}
