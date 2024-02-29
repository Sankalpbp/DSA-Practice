public class DisjointSetImpl {

    public int vertices;
    public int [] parent;

    public DisjointSetImpl ( int vertices ) {
        this.vertices = vertices;
        this.parent = new int [ vertices ];
        makeSet ();
    }

    private void makeSet ( ) {
        for ( int i = 0; i < vertices; ++i ) {
            parent [ i ] = i;
        }
    }

    public int find ( int vertex ) {
        if ( vertex < 0 || vertex >= vertices ) {
            throw new RuntimeException ( "Invalid vertex with value: " + vertex );
        }

        if ( parent [ vertex ] == vertex ) {
            return vertex;
        }

        return find ( parent [ vertex ] );
    }

    public void union ( int x, int y ) {
        if ( ( x < 0 || x >= vertices ) || ( y < 0 || y >= vertices ) ) {
            throw new RuntimeException ( "Either of the two vertices has invalid value: " + x + ", or " + y );
        }
        parent [ x ] = y;
    }

}
