import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

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

        List<Integer> list4 = Arrays.asList ( 1, 1, 1, 3, 2, 2, 4, 4, 4, 4 );
        TopKFrequentNumbers tfe = new TopKFrequentNumbers ( );
        System.out.println ( tfe.topKFrequent ( list4, 2 ) );

        FrequencySort fs = new FrequencySort ();
        System.out.println ( fs.sort ( list4 ) );

        List<List<Integer> > points = new ArrayList<> ();
        points.add ( new ArrayList<> ( Arrays.asList ( 1, 3 ) ) );
        points.add ( new ArrayList<> ( Arrays.asList ( -2, 2 ) ) );
        points.add ( new ArrayList<> ( Arrays.asList ( 5, 8 ) ) );
        points.add ( new ArrayList<> ( Arrays.asList ( 0, 1 ) ) );

        KClosestPointsToOrigin kpo = new KClosestPointsToOrigin ();
        System.out.println ( kpo.kClosest ( points, 2 ) );

        List<Integer> list5 = Arrays.asList ( 4, 3, 5, 1, 2 );
        ConnectRopes cr = new ConnectRopes ();
        System.out.println ( cr.minCost ( list5 ) );

        SumBetweenK1ThAndK2Th sb12 = new SumBetweenK1ThAndK2Th ();
        List<Integer> list10 = Arrays.asList ( 1, 3, 12, 5, 15, 11 );
        System.out.println ( sb12.sum ( 2, 6, list10 ) );

    }
}
