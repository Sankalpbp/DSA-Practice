import java.util.Arrays;

public class MainOccurrence {

    public static void main ( String... args ) {

        int [ ] arr = { 3, 3, 3, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 3, 3, 3 };

        Arrays.sort ( arr );

        System.out.print ( "inx: [ " );
        for ( int i = 0; i < arr.length; ++i ) {
            System.out.print ( i + " " );
        }


        StringBuilder sb = new StringBuilder ( "\narr: [ " );
        for ( int x : arr ) { sb.append ( x + " " ); }
        sb.append ( " ]" );

        System.out.println ( sb.toString () );

        FirstOccurrence fo = new FirstOccurrence ();
        System.out.println ( fo.firstOccurrence ( arr, 2 ) );
        System.out.println ( fo.firstOccurrence ( arr, 1 ) );
        System.out.println ( fo.firstOccurrence ( arr, 3 ) );
        System.out.println ( fo.firstOccurrence ( arr, 0 ) );

        LastOccurrence lo = new LastOccurrence ();
        System.out.println ( lo.lastOccurrence ( arr, 2 ) );
        System.out.println ( lo.lastOccurrence ( arr, 1 ) );
        System.out.println ( lo.lastOccurrence ( arr, 3 ) );
        System.out.println ( lo.lastOccurrence ( arr, 0 ) );

        NumberOfOccurrences no = new NumberOfOccurrences ();
        System.out.println ( no.numberOfOccurrences ( arr, 2 ) );
        System.out.println ( no.numberOfOccurrences ( arr, 1 ) );
        System.out.println ( no.numberOfOccurrences ( arr, 3 ) );
        System.out.println ( no.numberOfOccurrences ( arr, 0 ) );

    }

}
