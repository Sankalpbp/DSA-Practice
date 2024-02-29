public class Exponent {

    public static void print () {
        System.out.println ( "2^6 = " + exponent ( 2, 6 ) );
        System.out.println ( "3^8 = " + exponent ( 3, 8 ) );
    }

    private static double exponent ( double x, double y ) {
        if ( y == 0 ) {
            return 1;
        }

        if ( y % 2 == 0 ) {
            double smallOutput = exponent ( x, y / 2 );
            return smallOutput * smallOutput;
        }

        return x * exponent ( x, y - 1 );
    }
}
