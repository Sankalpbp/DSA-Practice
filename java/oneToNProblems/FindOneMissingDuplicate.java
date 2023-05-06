import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

public class FindOneMissingDuplicate {

    private BigInteger getSum ( List<Integer> list ) {
        BigInteger sum = BigInteger.ZERO;
        for ( int x : list ) {
            sum = sum.add ( new BigInteger ( Integer.valueOf ( x ).toString () ) );
        }
        return sum;
    }

    private BigInteger getSquareSum ( List<Integer> list ) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger value = null;
        for ( int x : list ) {
            value = new BigInteger ( Integer.valueOf ( x ).toString () );
            value = value.multiply ( value );
            sum = sum.add ( value );
        }
        return sum;
    }

    private BigInteger getSumOfNNaturalNumbers ( int n ) {
        BigInteger bigN = new BigInteger ( Integer.valueOf ( n ).toString () );
        BigInteger bigNPlus1 = new BigInteger ( Integer.valueOf ( n + 1 ).toString () );

        BigInteger sumOfN = bigN.multiply ( bigNPlus1 );
        sumOfN = sumOfN.divide ( new BigInteger ( "2" ) );

        return sumOfN;
    }

    private BigInteger getSumOfSquareOfNNaturalNumbers ( int n ) {
        BigInteger bigN = new BigInteger ( Integer.valueOf ( n ).toString () );
        BigInteger bigNPlus1 = bigN.add ( BigInteger.ONE );
        BigInteger big2NPlus1 = bigN.add ( bigNPlus1 );

        BigInteger result = bigN.multiply ( bigNPlus1 );
        result = result.multiply ( big2NPlus1 );
        result = result.divide ( new BigInteger ( Integer.valueOf ( 6 ).toString () ) );
        
        return result;
    }

    public List<Integer> find ( List<Integer> list ) {

        int n = list.size ();

        BigInteger idealSum = getSumOfNNaturalNumbers ( n );
        BigInteger listSum = getSum ( list );

        BigInteger idealSquareSum = getSumOfSquareOfNNaturalNumbers ( n );
        BigInteger listSquareSum = getSquareSum ( list );

        BigInteger differenceOfMissingAndDuplicate = idealSum.subtract ( listSum );
        BigInteger differenceOfSquareOfMissingAndDuplicate = idealSquareSum.subtract ( listSquareSum );

        BigInteger sumOfMissingAndDuplicate = differenceOfSquareOfMissingAndDuplicate.divide ( differenceOfMissingAndDuplicate );

        BigInteger missing = ( differenceOfMissingAndDuplicate.add ( sumOfMissingAndDuplicate ) );
        missing = missing.divide ( new BigInteger ( Integer.valueOf ( 2 ).toString () ) );
        BigInteger duplicate = missing.subtract ( differenceOfMissingAndDuplicate );

        return Arrays.asList ( missing.intValue (), duplicate.intValue () );
    }
}
