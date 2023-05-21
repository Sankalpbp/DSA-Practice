import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class FindMissingAndDuplicateUsingSwapSort {

    private void swapSort ( List<Integer> list ) {

        for ( int i = 0; i < list.size (); ++i ) {

            while ( list.get ( i ) != ( i + 1 ) && 
                    ( list.get ( list.get ( i ) - 1 ) != list.get ( i ) ) ) {
                int j = list.get ( i ) - 1;
                int temp = list.get ( i );
                list.set ( i, list.get ( list.get ( i ) - 1 ) );
                list.set ( j, temp );
            }
        }
    }

    public List<Integer> find ( List<Integer> list ) {
        swapSort ( list );

        for ( int i = 0; i < list.size (); ++i ) {
            if ( list.get ( i ) != ( i + 1 ) ) {
                return Arrays.asList ( i + 1, list.get ( i ) );
            }
        }

        return new ArrayList<> ( 0 );
    }
}

