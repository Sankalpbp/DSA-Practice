import java.util.List;

public class ReverseArray {

    public static void reverse ( List<Integer> arr ) {
        reverse ( arr, arr.size () - 1 );
    }

    private static void reverse ( List<Integer> arr, int lastIndex ) {
        if ( lastIndex == 0 ) {
            return;
        }

        int lastElement = arr.get ( lastIndex );

        int indexBeforeLast = lastIndex - 1;
        reverse ( arr, indexBeforeLast );

        shiftAndPut ( arr, lastElement, lastIndex );
    }

    private static void shiftAndPut ( List<Integer> arr, int key, int lastIndex ) {
        if ( lastIndex == 0 ) {
            arr.set ( lastIndex, key );
            return;
        }

        // shifting
        arr.set ( lastIndex, arr.get ( lastIndex - 1 ) );

        shiftAndPut ( arr, key, lastIndex - 1 );
    }
}
