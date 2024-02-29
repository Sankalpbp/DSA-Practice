import java.util.Deque;
import java.util.ArrayDeque;

public class TopologicalSort {

    public static void print () {
        int [][] adjacencyMatrix = Graphs.buildDAG ();
        System.out.print ( "Topological Sort: " );
        topologicalSort ( adjacencyMatrix );
    }

    private static void topologicalSort ( int [][] adjacencyMatrix ) {
        Deque<Integer> stack = new ArrayDeque<> ();
        boolean [] visited = new boolean [ adjacencyMatrix.length ];

        performTopSort ( adjacencyMatrix, visited, 0, stack );
        printTopSort ( stack );
    }

    private static void performTopSort ( int [][] adjacencyMatrix, boolean [] visited, int source, Deque<Integer> stack ) {
        visited [ source ] = true;
        for ( int i = 0; i < adjacencyMatrix [ source ].length; ++i ) {
            if ( !visited [ i ] && adjacencyMatrix [ source ][ i ] == 1 ) {
                performTopSort ( adjacencyMatrix, visited, i, stack );
            }
        }
        stack.push ( source );
    }

    private static void printTopSort ( Deque<Integer> stack ) {
        System.out.println ( "\n\nTop Sort order: " );
        while ( !stack.isEmpty () ) {
            System.out.print ( stack.pop () + " " );
        }
        System.out.println ();
    }

}
