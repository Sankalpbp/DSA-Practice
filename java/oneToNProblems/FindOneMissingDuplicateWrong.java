import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class FindOneMissingDuplicate {

    private int getSum ( List<Integer> list ) {
        int sum = 0;
        for ( int x : list ) {
            sum += x;
        }

        return sum;
    }

    private int getProduct ( List<Integer> list ) {
        int product = 1;
        for ( int x : list ) {
            product *= x;
        }

        return product;
    }

    private List<Integer> getListFromXToY ( int x, int y ) {
        List<Integer> list = new ArrayList<> ( y - x + 1);
        for ( int i = x; i <= y; ++i ) {
            list.add ( i );
        }

        return list;
    }

    public List<Double> find ( List<Integer> list ) {

        int n = list.size ();

        int idealSum = n * ( n + 1 ) / 2;
        int listSum = getSum ( list );

        int difference = listSum - idealSum;

        int idealProduct = getProduct ( getListFromXToY ( 1, n ) );
        int listProduct = getProduct ( list );

        double quotient = listProduct / idealProduct;

        double missing = difference / ( quotient - 1 );
        double duplicate = difference + missing;

        return Arrays.asList ( missing, duplicate );
    }
}
