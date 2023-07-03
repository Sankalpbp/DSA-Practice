import java.util.List;

public class SortArray {

    public static void sort ( List<Integer> arr ) {
        sort ( arr, arr.size () - 1 );
    }

    private static void sort ( List<Integer> arr, int x ) {
        if ( x == 0 ) {
            return;
        }

        int key = arr.get ( x );
        sort ( arr, x - 1 );
        shiftAndPut ( arr, x, key );
    }

    private static void shiftAndPut ( List<Integer> arr, int x, int key ) {
        if ( x == 0 ) {
            arr.set ( x, key );
            return;
        }

        if ( arr.get ( x - 1 ) < key ) {
            arr.set ( x, key );
            return;
        }

        arr.set ( x, arr.get ( x - 1 ) );
        shiftAndPut ( arr, x - 1, key );
    }
}
