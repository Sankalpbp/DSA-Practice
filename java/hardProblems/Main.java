import java.util.List;

public class Main {

    public static void main ( String... args ) {
        KthSmallest.print ();
        AggressiveCows.print ();
        SpiralMatrix.print ();
        RotateBy90.print ();
        MergeIntervals.print ();
        AllocatePages.print ();

        RottenTomatoes.print ();
        MedianOfSortedArrays.print ();

        CandyDistribution.print ();

        InversionCount.print ();

        FlipsForAToB.print ();
        MakeAOrB_C.print ();

        WordBreak.print ();

        Trie trie = new Trie ( List.of ( "ninja", "nin", "nina", "nun", "ninjitsu" ) );
        if ( trie.search ( "nin" ) ) {
            System.out.println ( "\"nin\" is present" );
        }
        if ( trie.search ( "ninu" ) ) {
            System.out.println ( "\"ninu\" is present" );
        }
        trie.insert ( "nintu" );
        if ( trie.search ( "nintu" ) ) {
            System.out.println ( "\"nintu\" is present" );
        }

        PhoneDirectory.print ();

        MissingDuplicate.print ();
    }
}
