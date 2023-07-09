public class ThreeD {

    private static int [][][] make ( int n, int m, int p ) {
        int [ ][ ][ ] matrix = new int [ n ][ m ][ p ];
        return matrix;
    }

    public static void print ( int n, int m, int p ) {

        int [][][] matrix = make ( n, m, p );

        for ( int i = 0; i < matrix.length; ++i ) {
            for ( int j = 0; j < matrix [ 0 ].length; ++j ) {
                for ( int k = 0; k < matrix [ 0 ][ 0 ].length; ++k ) {
                    System.out.print ( matrix [ i ][ j ][ k ] + " " );
                }
                System.out.println ();
            }
            System.out.println ();
        }
    }
}
