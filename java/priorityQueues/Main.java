import java.util.List;
import java.util.Arrays;

public class Main {

    public static void main ( String... args ) {

        int [ ] arr = { 7, 10, 4, 3, 20, 15, 1 };

        KThSmallest ks = new KThSmallest ( );
        System.out.println ( ks.kThSmallest ( arr, 3 ) );

        KThLargest kl = new KThLargest ();
        System.out.println ( kl.kThLargest ( arr, 3 ) );

        List<Integer> list = Arrays.asList ( 7, 10, 4, 3, 20, 15, 1 );

        KSmallestElements kse = new KSmallestElements ( );
        System.out.println ( kse.kSmallestElements ( list, 3 ) );

        KLargestElements kle = new KLargestElements ();
        System.out.println ( kle.kLargestElements ( list, 3 ) );

        List<Integer> list2 = Arrays.asList ( 6, 5, 3, 2, 8, 10, 9 );
        NearlySorted ns = new NearlySorted ();
        ns.sort ( list2, 3 );
        System.out.println ( list2 );

        List<Integer> list3 = Arrays.asList ( 8, 5, 6, 7, 9 );
        KClosestNumbers kcn = new KClosestNumbers ();
        System.out.println ( kcn.kClosest ( list3, 3, 7 ) );

    }
}
