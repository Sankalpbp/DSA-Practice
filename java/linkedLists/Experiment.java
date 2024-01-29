public class Experiment {

    public static void main ( String... args ) {
        int [] arr = { 5 };
        call ( arr, 3 );
    }

    private static void call ( int[] i, int n ) {
        if ( n == 0 ) {
            return;
        }

        --n;
        call ( i, n );
        --i[0];
        System.out.print ( i[0] + " " );
    }
}
