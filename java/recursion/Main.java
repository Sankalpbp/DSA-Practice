import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main ( String... args ) {

        PrintOneToN.print ( 10 );
        System.out.println ( Factorial.factorial ( 5 ) );

        System.out.println ( FindCorrectPositionInSortedArray.findIndex ( Arrays.asList ( 1, 2, 3, 5 ), 4 ) );
        System.out.println ( FindCorrectPositionInSortedArray.findIndex ( Arrays.asList ( 3, 4, 9, 10 ), 8 ) );
        System.out.println ( FindCorrectPositionInSortedArray.findIndex ( Arrays.asList ( 3, 4, 5 ), 2 ) );
        System.out.println ( FindCorrectPositionInSortedArray.findIndex ( Arrays.asList ( 1, 2, 3 ), 4 ) );

        List<Integer> array = new ArrayList<> ( Arrays.asList ( 3, 5, 6 ) );
        ShiftAndPutInSortedArray.shiftAndPut ( array, 2 );
        System.out.println ( array );

        List<Integer> input = new ArrayList<> ( Arrays.asList ( 3, 2, 1 ) );
        List<Integer> input1 = new ArrayList<> ( Arrays.asList ( 1, 2, 3 ) );
        List<Integer> input2 = new ArrayList<> ( Arrays.asList ( 1, 3, 2 ) );
        SortArray.sort ( input );
        SortArray.sort ( input1 );
        SortArray.sort ( input2 );
        System.out.println ( input );
        System.out.println ( input1 );
        System.out.println ( input2 );
    }
}
