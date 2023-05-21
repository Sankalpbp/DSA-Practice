import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main ( String... args ) {

        List<Integer> list = Arrays.asList ( 1, 3, 2, 5, 5 );
        FindOneMissingDuplicate fomd = new FindOneMissingDuplicate ();

        System.out.println ( fomd.find ( list ) );

        List<Integer> list2 = Arrays.asList ( 2, 3, 1, 5, 1 );
        SwapSort ss = new SwapSort ();
        ss.sort ( list2 );
        System.out.println ( list2 );

        List<Integer> list3 = Arrays.asList ( 2, 3, 1, 5, 1 );
        FindMissingAndDuplicateUsingSwapSort fmss = new FindMissingAndDuplicateUsingSwapSort ();
        List<Integer> result = fmss.find ( list3 );
        System.out.println ( "missing: " + result.get ( 0 ) + " duplicate: " + result.get ( 1 ) );
    }
}
