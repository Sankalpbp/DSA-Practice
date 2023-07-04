import java.util.List;

public class DeleteElementFromArray {

    public static void delete ( List<Integer> arr, int element ) {
        delete ( arr, arr.size () - 1, element );
        if ( arr.size () > 0 ) {
            arr.remove ( arr.get ( arr.size () - 1 ) );
        }
    }

    private static void delete ( List<Integer> arr, int index, int element ) {
        if ( index < 0 || index == arr.size () ) {
            return;
        }

        if ( arr.get ( index ) == element ) {
            shift ( arr, index );
            return;
        }

        delete ( arr, index + 1, element );
    }

    private static void shift ( List<Integer> arr, int index ) {
        if ( index >= arr.size () - 1 ) {
            return;
        }

        arr.set ( index , arr.get ( index + 1 ) );
        shift ( arr, index + 1 );
    }
}
