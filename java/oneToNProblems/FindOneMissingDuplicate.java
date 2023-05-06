import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FindOneMissingDuplicate {

    private int getSum ( List<Integer> list ) {
        int sum = 0;
        for ( int x : list ) {
            sum += x;
        }
        return sum;
    }

    private int getSquareSum ( List<Integer> list ) {
        int sum = 0;
        for ( int x : list ) {
            sum += x * x;
        }
        return sum;
    }

    public List<Integer> find ( List<Integer> list ) {

        int n = list.size ();

        int idealSum = n * ( n + 1 ) / 2;
        int listSum = getSum ( list );

        int idealSquareSum = n * ( n + 1 ) * ( 2 * n + 1 ) / 6;
        int listSquareSum = getSquareSum ( list );

        int differenceOfMissingAndDuplicate = idealSum - listSum;
        int differenceOfSquareOfMissingAndDuplicate = idealSquareSum - listSquareSum;

        int sumOfMissingAndDuplicate = differenceOfSquareOfMissingAndDuplicate / differenceOfMissingAndDuplicate;

        int missing = ( differenceOfMissingAndDuplicate + sumOfMissingAndDuplicate ) / 2;
        int duplicate = missing - differenceOfMissingAndDuplicate;

        return Arrays.asList ( missing, duplicate );
    }
}
