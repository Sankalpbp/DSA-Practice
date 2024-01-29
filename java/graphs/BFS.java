import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;

public class BFS {

    public static void print () {
        int [][] adjacencyMatrix = Graphs.getAdjacencyMatrix ();

        System.out.println ( "\n\nAdjacency Matrix: " );
        bfsAdjacencyMatrix ( adjacencyMatrix );

        LinkedList<Integer> [] adjacencyList = Graphs.getAdjacencyList ();

        System.out.println ( "\n\nAdjacency List: " );
        bfsAdjacencyList ( adjacencyList );
    }

    private static void bfsAdjacencyList ( LinkedList<Integer> [] adjacencyList ) {
        Queue<Integer> pendingNodes = new ArrayDeque<> ();
        boolean [] visited = new boolean [ adjacencyList.length ];

        int current = -1;

        for ( int i = 0; i < adjacencyList.length; ++i ) {
            if ( !visited [ i ] ) {

                current = -1;
                pendingNodes.offer ( i );

                while ( !pendingNodes.isEmpty () ) {
                    current = pendingNodes.poll ();
                    visited [ current ] = true;
                    System.out.print ( current + " " );

                    for ( int j = 0; j < adjacencyList [ current ].size (); ++j ) {
                        if ( !visited [ adjacencyList [ current ].get ( j ) ] ) {
                            pendingNodes.offer ( adjacencyList [ current ].get ( j ) );
                        }
                    }
                }
            }
        }
    }

    private static void bfsAdjacencyMatrix ( int [][] adjacencyMatrix ) {
        Queue<Integer> pendingNodes = new ArrayDeque<> ();
        boolean [] visited = new boolean [ adjacencyMatrix.length ];

        int current = -1;

        for ( int i = 0; i < adjacencyMatrix.length; ++i ) {
            if ( !visited [ i ] ) {
                current = -1;
                pendingNodes.offer ( i );

                while ( !pendingNodes.isEmpty () ) {
                    current = pendingNodes.poll ();
                    visited [ current ] = true;
                    System.out.print ( current + " " );

                    for ( int j = 0; j < adjacencyMatrix [ current ].length; ++j ) {
                        if ( !visited [ j ] && adjacencyMatrix [ current ][ j ] == 1 ) {
                            pendingNodes.offer ( j );
                        }
                    }
                }
            }
        }
    }

}

