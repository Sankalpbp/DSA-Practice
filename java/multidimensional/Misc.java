public class Misc {

    public static void print ( int n, int m ) {
        int [][] matrix = make ( n, m );
        System.out.println ( "\n\n" );
        for ( int i = 0; i < matrix.length; ++i ) {
            System.out.print ( matrix [ i ] + " " );
        }

        System.out.println ( "\n\n" );
        int [][][] matrix3 = make3 ( 2, 3, 4 );
        for ( int i = 0; i < matrix.length; ++i ) {
            System.out.print ( matrix [ i ] + " " );
        }
    }

    private static int [][][] make3 ( int n, int m, int o ) {
        int [][][] matrix = new int [ n ][ m ][ ];
        return matrix;
    }

    private static int [][] make ( int n, int m ) {
        int [][] matrix = new int [ n ][];

        return matrix;
    }
}
