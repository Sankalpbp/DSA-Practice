import java.util.LinkedList;

public class DFS {

    public static void print () {
        int [][] adjacencyMatrix = Graphs.getAdjacencyMatrix ();

        System.out.println ( "\n\nAdjacency Matrix: " );
        dfsAdjacencyMatrix ( adjacencyMatrix );

        LinkedList<Integer> [] adjacencyList = Graphs.getAdjacencyList ();

        System.out.println ( "\n\nAdjacency List: " );
        dfsAdjacencyList ( adjacencyList );
    }

    private static void dfsAdjacencyList ( LinkedList<Integer> [] adjacencyList, boolean [] visited, int source ) {
        visited [ source ] = true;
        System.out.print ( source + " " );

        for ( int i = 0; i < adjacencyList [ source ].size (); ++i ) {
            if ( !visited [ i ] ) {
                dfsAdjacencyList ( adjacencyList, visited, adjacencyList [ source ].get ( i ) );
            }
        }
    }

    private static void dfsAdjacencyList ( LinkedList<Integer> [] adjacencyList ) {
        boolean [] visited = new boolean [ adjacencyList.length ];

        for ( int i = 0; i < adjacencyList.length; ++i ) {
            if ( !visited [ i ] ) {
                dfsAdjacencyList ( adjacencyList, visited, i );
            }
        }
    }

    private static void dfsAdjacencyMatrix ( int [][] adjacencyMatrix ) {
        boolean [] visited = new boolean [ adjacencyMatrix.length ];

        for ( int i = 0; i < adjacencyMatrix.length; ++i ) {
            if ( !visited [ i ] ) {
                dfsAdjacencyMatrix ( adjacencyMatrix, visited, i );
            }
        }
    }

    private static void dfsAdjacencyMatrix ( int [][] adjacencyMatrix, boolean [] visited, int source ) {
        visited [ source ] = true;
        System.out.print ( source + " " );

        for ( int i = 0; i < adjacencyMatrix [ source ].length; ++i ) {
            if ( !visited [ i ] && adjacencyMatrix [ source ][ i ] == 1 ) {
                dfsAdjacencyMatrix ( adjacencyMatrix, visited, i );
            }
        }
    }

}
