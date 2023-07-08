import java.util.List;
import java.util.ArrayList;

public class StoreSubsets {

    public static List<String> store ( String input ) {
        List<String> list = new ArrayList<> ();
        store ( input, "", list );

        return list;
    }

    private static void store ( String input, String output, List<String> list ) {
        if ( input.length () == 0 ) {
            list.add ( output );
            return;
        }

        store ( input.substring ( 1 ), output, list );

        int size = list.size ();

        for ( int i = 0; i < size; ++i ) {
            list.add ( input.charAt ( 0 ) + list.get ( i ) );
        }
    }
}
