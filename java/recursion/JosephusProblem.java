import java.util.List;
import java.util.ArrayList;

public class JosephusProblem {

    public static int josephus ( int n, int k ) {
        List<Integer> list = new ArrayList<> ();
        for ( int i = 1; i <= n; ++i ) {
            list.add ( i );
        }
        --k;
        return josephus ( 0, list, k );
    }

    private static int josephus ( int index, List<Integer> list, int k ) {
        if ( list.size () == 1 ) {
            return list.get ( 0 );
        }

        int toKill = ( index + k ) % list.size ();
        System.out.println ( toKill );
        list.remove ( toKill );
        return josephus ( toKill, list, k );
    }
}
