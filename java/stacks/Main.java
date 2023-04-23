public class Main {

    public static void main ( String... args ) {

        ArrayStack stack = new ArrayStack ();

        for ( int i = 0; i < 10; ++i ) {
            stack.push ( i );
        }

        while ( stack.size () != 0 ) {
            System.out.println ( stack.top () );
            stack.pop ();
        }
    }
}
