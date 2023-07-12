import java.util.Map;
import java.util.HashMap;

public class BooleanParenthesization {

    public static int waysMemoized ( String expression ) {
        Map<MemoEntry, Integer> memo = new HashMap<> ();

        return waysMemoized ( expression, 0, expression.length () - 1, 'T', memo );
    }

    private static int waysMemoized ( String expression, int i, int j, char required, Map<MemoEntry, Integer> memo ) {
        
        MemoEntry entry = new MemoEntry ( i, j, required );

        if ( i > j ) {
            memo.put ( entry, 0 );
            return 0;
        }

        if ( memo.containsKey ( entry ) ) {
            return memo.get ( entry );
        }

        if ( i == j ) {
            int value = ( required == expression.charAt ( i ) ) ? 1 : 0;
            memo.put ( entry, value );
            return value;
        }

        int answer = 0;

        for ( int k = i + 1; k < j; k += 2 ) {
            int leftTrue = waysMemoized ( expression, i, k - 1, 'T', memo );
            int leftFalse = waysMemoized ( expression, i, k - 1, 'F', memo );
            int rightTrue = waysMemoized ( expression, k + 1, j, 'T', memo );
            int rightFalse = waysMemoized ( expression, k + 1, j, 'F', memo );

            answer += getAnswer ( expression, k, leftTrue, leftFalse, rightTrue, rightFalse, required );
        }

        memo.put ( entry, answer );
        return answer;
    }

    public static int ways ( String expression ) {
        return ways ( expression, 0, expression.length () - 1, 'T' );
    }

    private static int ways ( String expression, int i, int j, char required ) {

        if ( i > j ) {
            return 0;
        }

        if ( i == j ) {
            return ( required == expression.charAt ( i ) ) ? 1 : 0;
        }

        int answer = 0;

        for ( int k = i + 1; k < j; k += 2 ) {
            int leftTrue = ways ( expression, i, k - 1, 'T' );
            int leftFalse = ways ( expression, i, k - 1, 'F' );
            int rightTrue = ways ( expression, k + 1, j, 'T' );
            int rightFalse = ways ( expression, k + 1, j, 'F' );

            answer += getAnswer ( expression, k, leftTrue, leftFalse, rightTrue, rightFalse, required );
        }

        return answer;
    }

    private static int getAnswer ( String expression, int k, int leftTrue, int leftFalse, int rightTrue, int rightFalse, char required ) {
        int temp = 0;
        int answer = 0;
        if ( expression.charAt ( k ) == '&' ) {
            if ( required == 'T' ) {
                temp = leftTrue * rightTrue;
                answer += temp;
            } else {
                temp = leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                answer += temp;
            }
        } else if ( expression.charAt ( k ) == '|' ) {
            if ( required == 'T' ) {
                temp = leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
                answer += temp;
            } else {
                temp = leftFalse * rightFalse;
                answer += temp;
            }
        } else if ( expression.charAt ( k ) == '^' ) {
            if ( required == 'T' ) {
                temp = leftTrue * rightFalse + leftFalse * rightTrue;
                answer += temp;
            } else {
                temp = leftFalse * rightFalse + leftTrue * rightTrue;
                answer += temp;
            }
        }

        return answer;
    }

    private static class MemoEntry {
        public int i;
        public int j;
        public char required;

        public MemoEntry ( int i, int j, char required ) {
            this.i = i;
            this.j = j;
            this.required = required;
        }
    }
}
