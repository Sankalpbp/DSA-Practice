public class TowerOfHanoi {

    public static void toh ( int n, char source, char destination, char helper ) {

        if ( n == 0 ) {
            return;
        }

        toh ( n - 1, source, helper, destination );
        System.out.println ( "Move " + n + " from " + source + " to " + destination );
        toh ( n - 1, helper, destination, source );
    }
}
