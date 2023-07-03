public class PrintOneToN {

    public static void print ( int n ) {

        if ( n == 0 ) {
            return;
        }

        print ( n - 1 );
        System.out.println ( n );
    }
}
