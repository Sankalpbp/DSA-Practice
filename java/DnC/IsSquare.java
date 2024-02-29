public class IsSquare {

    public static void print () {
        int n = 1089;

        if ( isSquare ( n ) ) {
            System.out.println ( n + " is a square of an integer" );
        } else {
            System.out.println ( n + " is not a square of an integer" );
        }

        n = 1088;
        if ( isSquare ( n ) ) {
            System.out.println ( n + " is a square of an integer" );
        } else {
            System.out.println ( n + " is not a square of an integer" );
        }
    }

    private static boolean isSquare ( int n ) {
        int start = 0; 
        int end = n;

        int mid = 0;
        int midSquare = 0;

        while ( start < end ) {
            mid = start + ( end - start ) / 2;
            midSquare = mid * mid;

            if ( midSquare == n ) {
                return true;
            } else if ( midSquare > n ) {
                end = mid - 1;
            } else if ( midSquare < n ) {
                start = mid + 1;
            }
        }

        return false;
    }

}
