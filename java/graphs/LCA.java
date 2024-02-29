import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class LCA {

    public static void print () {
        LinkedList<Integer> [] graph = Graphs.buildLCAGraph ();
        System.out.println ( findLCA ( graph , 4, 6 ) );
    }

    private static boolean getAncestors ( LinkedList<Integer> [] graph, int node, Deque<Integer> stack, boolean [] visited, int source ) {
        visited [ source ] = true;

        if ( source == node ) {
            return true;
        }

        for ( int neighbor : graph [ source ] ) {
            if ( !visited [ neighbor ] && getAncestors ( graph, node, stack, visited, neighbor ) ) {
                stack.push ( neighbor );
                return true;
            }
        }

        return false;
    }

    private static int findLCA ( LinkedList<Integer> [] graph, int x, int y ) {
        boolean [] visited = new boolean [ graph.length ];
        Deque<Integer> stackX = new ArrayDeque<> ();
        Deque<Integer> stackY = new ArrayDeque<> ();

        getAncestors ( graph, x, stackX, visited, 0 );
        stackX.push ( 0 );

        Arrays.fill ( visited, false );
        getAncestors ( graph, y, stackY, visited, 0 );
        stackY.push ( 0 );

        int ancestor = -1;

        while ( !stackX.isEmpty () && !stackY.isEmpty () ) {
            if ( stackX.peek () == stackY.peek () ) {
                ancestor = stackX.peek ();
            } else {
                break;
            }
            stackX.pop ();
            stackY.pop ();
        }

        return ancestor;
    }

}
