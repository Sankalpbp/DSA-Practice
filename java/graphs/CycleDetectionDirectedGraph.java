import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;

public class CycleDetectionDirectedGraph {

    public static void print () {
        if ( cycleFound ( Graphs.directedCyclic ( ) ) ) {
            System.out.println ( "The given graph is cyclic" );
        } else {
            System.out.println ( "The given graph is acyclic" );
        }

        if ( cycleFound ( Graphs.directedAcyclic ( ) ) ) {
            System.out.println ( "The given graph is cyclic" );
        } else {
            System.out.println ( "The given graph is acyclic" );
        }
    }

    private static boolean cycleFound ( LinkedList<Integer> [] graph ) {
        boolean [] visited = new boolean [ graph.length ];
        Set<Integer> ancestors = new HashSet<> ();

        return cycleFound ( graph, visited, 0, ancestors );
    }

    private static boolean cycleFound ( LinkedList<Integer> [] graph, boolean [] visited, int source, Set<Integer> ancestors ) {
        visited [ source ] = true;

        for ( int neighbor : graph [ source ] ) {
            if ( visited [ neighbor ] && ancestors.contains ( neighbor ) ) {
                return true;
            } else if ( !visited [ neighbor ] ) {
                ancestors.add ( source );
                if ( cycleFound ( graph, visited, neighbor, ancestors ) ) {
                    return true;
                }
                ancestors.remove ( source );
            }
        }
        return false;
    }

}
