public class TwoD {

    private static int [][] make2 ( int n, int m ) {
        int [][] matrix = new int [ n ][ m ];
        for ( int i = 0; i < n; ++i ) {
            matrix [ i ] = new int [ m ];
            for ( int j = 0; j < m; ++j ) {
                matrix [ i ][ j ] = i + j;
            }
        }
        return matrix;
    }

    public static void print ( int n, int m ) {
        int [][] matrix = make2 ( n, m );
        for ( int i = 0; i < n; ++i ) {
            for ( int j = 0; j < m; ++j ) {
                System.out.print ( matrix [ i ][ j ] + " " );
            }
            System.out.println ();
        }
    }
}
