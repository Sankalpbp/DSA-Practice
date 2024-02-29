import java.util.LinkedList;

public class HasPath {

    public static void print () {
        LinkedList<Integer> [] graph = Graphs.buildUnweightedGraphAdjList ();
        if ( hasPath ( graph, 1, 6 ) ) {
            System.out.println ( "There is a path between 1 to 6." );
        } else {
            System.out.println ( "There is no path between 1 to 6." );
        }

        LinkedList<Integer> [] graph2 = Graphs.buildDAGAdjList ();
        if ( hasPath ( graph2, 2, 1 ) ) {
            System.out.println ( "There is a path between 2 to 1." );
        } else {
            System.out.println ( "There is no path between 2 to 1." );
        }
    }

    private static boolean hasPath ( LinkedList<Integer> [] graph, int source, int destination ) {
        boolean [] visited = new boolean [ graph.length ];
        return hasPath ( graph, 1, 6, visited );
    }

    private static boolean hasPath ( LinkedList<Integer> [] graph, int source, int destination, boolean [] visited ) {
        if ( source == destination ) {
            return true;
        }

        visited [ source ] = true;

        for ( int x : graph [ source ] ) {
            if ( !visited [ x ] && hasPath ( graph, x, destination, visited ) ) {
                return true;
            }  
        }
        return false;
    }

}
