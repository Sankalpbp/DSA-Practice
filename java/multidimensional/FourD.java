public class FourD {

    public static void print ( int a, int b, int c, int d ) {
        int [][][][] matrix = make ( a, b, c, d );
        for ( int i = 0; i < matrix.length; ++i ) {
            for ( int j = 0; j < matrix [ 0 ].length; ++j ) {
                for ( int k = 0; k < matrix [ 0 ][ 0 ].length; ++k ) {
                    for ( int l = 0; l < matrix [ 0 ][ 0 ][ 0 ].length; ++l ) {
                        System.out.print ( matrix [ i ][ j ][ k ][ l ] );
                    }
                    System.out.println ();
                }
                System.out.println ();
            }
            System.out.println ();
        }
    }

    private static int [][][][] make ( int a, int b, int c, int d ) {
        int [][][][] matrix = new int [ a ][ b ][ c ][ d ];
        return matrix;
    }
}
