import java.util.List;
import java.util.ArrayList;

public class CombinationSum {

    public static void print ( List<Integer> arr, int target ) {
        List<List<Integer>> result = new ArrayList<> ();
        combination ( arr, 0, new ArrayList<> (), target, 0, result );
        System.out.println ( result );
    }

    private static void combination ( List<Integer> arr, int start, List<Integer> subset, int target, int sum, List<List<Integer>> result ) {
        if ( start == arr.size () ){
            return;
        }

        if ( sum > target ) {
            return;
        }

        if ( sum == target ) {
            result.add ( new ArrayList<> ( subset ) );
            return;
        }

        subset.add ( arr.get ( start ) );
//        combination ( arr, start + 1, subset, target, sum + arr.get ( start ), result ); - Remember to mention this point

        combination ( arr, start, subset, target, sum + arr.get ( start ), result );

        subset.remove ( subset.size () - 1 );

        combination ( arr, start + 1, subset, target, sum, result );
    }

}
