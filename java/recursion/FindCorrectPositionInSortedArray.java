import java.util.List;

public class FindCorrectPositionInSortedArray {

    public static int findIndex ( List<Integer> arr, int element ) {
        return findIndex ( arr, arr.size () - 1, element );
    }

    private static int findIndex ( List<Integer> arr, int x, int element ) {

        if ( x < 0 ) {
            return 0;
        }

        if ( arr.get ( x ) < element ) {
            return x + 1;
        }

        return findIndex ( arr, x - 1, element );
    }
}
