public class MinStackTest {

    public static void main ( String... args ) {

        MinStackEfficient ms = new MinStackEfficient ();

        int [ ] arr = { 10, 7, 12, 8, 2, 5 };

        for ( int x : arr ) {
            ms.push ( x );
        }

        while ( !ms.isEmpty () ) {
            System.out.println ( "top: " + ms.top () );
            System.out.println ( "minimum: " + ms.getMin () );
            ms.pop ();
            System.out.println ( "isEmpty: " + ms.isEmpty () );
        }
    }
}
