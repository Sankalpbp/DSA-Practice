public class MainMinStack {

    private static void printData ( MinStackEfficient msn ) {
        System.out.println ( "\nTop: " + msn.top () );
        System.out.println ( "Minimum: " + msn.getMin () + "\n" );
    }

    public static void main ( String... args ) {

//        MinStackNaive msn = new MinStackNaive ( );
//        MinStackInefficient msn = new MinStackInefficient ();

        MinStackEfficient msn = new MinStackEfficient ();

        int [ ] arr = { 8, 7, 5, 4, 6, 2, 3, 0 };

        for ( int i = 0; i < arr.length; ++i ) {
            msn.push ( arr [ i ] );
            printData ( msn );
        }
 
    }

}
