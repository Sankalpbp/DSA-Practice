import java.util.Arrays;

public class Main {

    public static void main ( String... args ) {

        int [ ] arr = { 11, 12, 15, 18, 2, 5, 6, 8 };

        ArrayRotations ar = new ArrayRotations ( );
        System.out.println ( ar.numberOfArrayRotations ( arr ) );

        SearchInRotatedSortedArray srs = new SearchInRotatedSortedArray ( );

        System.out.println ( srs.search ( arr, 11 ) );
        System.out.println ( srs.search ( arr, 12 ) );
        System.out.println ( srs.search ( arr, 15 ) );
        System.out.println ( srs.search ( arr, 18 ) );
        System.out.println ( srs.search ( arr, 2 ) );
        System.out.println ( srs.search ( arr, 5 ) );
        System.out.println ( srs.search ( arr, 6 ) );
        System.out.println ( srs.search ( arr, 8 ) );

        SearchInNearlySortedArray sns = new SearchInNearlySortedArray ( );

        int [ ] na = { 5, 10, 30, 20, 40 };

        System.out.println ( sns.search ( na, 5 ) );
        System.out.println ( sns.search ( na, 10 ) );
        System.out.println ( sns.search ( na, 30 ) );
        System.out.println ( sns.search ( na, 20 ) );
        System.out.println ( sns.search ( na, 40 ) );

        Arrays.sort ( arr );

        FloorOfAnElement fe = new FloorOfAnElement ( );
        System.out.println ( fe.floor ( arr, 4 ) );
        System.out.println ( fe.floor ( arr, 2 ) );
        System.out.println ( fe.floor ( arr, 12 ) );
        System.out.println ( fe.floor ( arr, 13 ) );

        CeilOfAnElement ce = new CeilOfAnElement ( );
        System.out.println ( ce.ceil ( arr, 4 ) );
        System.out.println ( ce.ceil ( arr, 2 ) );
        System.out.println ( ce.ceil ( arr, 12 ) );
        System.out.println ( ce.ceil ( arr, 13 ) );

        NextLetter nl = new NextLetter ( );
        char [ ] letters = { 'a', 'c', 'f', 'g' };
        System.out.println ( nl.nextLetter ( letters, 'a' ) );
        System.out.println ( nl.nextLetter ( letters, 'c' ) );
        System.out.println ( nl.nextLetter ( letters, 'f' ) );
        System.out.println ( nl.nextLetter ( letters, 'g' ) );
        System.out.println ( nl.nextLetter ( letters, 'd' ) );
        System.out.println ( nl.nextLetter ( letters, 'e' ) );
        System.out.println ( nl.nextLetter ( letters, 'b' ) );

        int [ ] infinite = new int [ 10000000 ];
        for ( int i = 1; i <= 10000000; ++i ) {
            infinite [ i - 1 ] = i;
        }

        SearchInInfiniteSortedArray sis = new SearchInInfiniteSortedArray ();

        System.out.println ( sis.search ( infinite, 77777 ) );

        int [ ] infiniteBinary = new int [ 1000000 ];
        for ( int i = 0; i < 50000; ++i ) {
            infiniteBinary [ i ] = 0;
        }

        for ( int i = 50000; i < infiniteBinary.length; ++i ) {
            infiniteBinary [ i ] = 1;
        }

        Search1InBinarySortedArray sib = new Search1InBinarySortedArray ();

        System.out.println ( sib.search ( infiniteBinary ) );


        MinimumDifferenceElement mde = new MinimumDifferenceElement ();
        System.out.println ( mde.minimumDifference ( arr, 7 ) );
        System.out.println ( mde.minimumDifference ( arr, 14 ) );

    }
}
