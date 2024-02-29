public class Main {

    public static void main ( String... args ) {
        DisjointSetImpl dsi = new DisjointSetImpl ( 6 );

        for ( int i = 0; i < 6; ++i ) {
            System.out.println ( "Root of " + i + " is: " + dsi.find ( i ) );
        }

        dsi.union ( 0, 1 );
        dsi.union ( 1, 2 );
        dsi.union ( 3, 4 );

        for ( int i = 0; i < 6; ++i ) {
            System.out.println ( "Root of " + i + " is: " + dsi.find ( i ) );
        }

    }
}
