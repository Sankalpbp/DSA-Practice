import java.util.List;

public class ShiftAndPutInSortedArray {

    public static void shiftAndPut ( List<Integer> arr, int element ) {
        arr.add ( Integer.MAX_VALUE );
        shiftAndPut ( arr, arr.size () - 1, element );
    }

    private static void shiftAndPut ( List<Integer> arr, int x, int element ) {

        if ( x == 0 ) {
            arr.set ( 0, element );
            return;
        }

        if ( arr.get ( x - 1 ) < element ) {
            arr.set ( x, element );
            return;
        }

        arr.set ( x, arr.get ( x - 1 ) );
        shiftAndPut ( arr, x - 1, element );
    }
}
