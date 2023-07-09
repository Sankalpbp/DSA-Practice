import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {

    public static void main ( String... args ) {

        List<Timing> meetings = new ArrayList<> ();
        meetings.add ( new Timing ( 1, 2 ) );
        meetings.add ( new Timing ( 3, 4 ) );
        meetings.add ( new Timing ( 5, 7 ) );
        meetings.add ( new Timing ( 8, 9 ) );
        meetings.add ( new Timing ( 0, 6 ) );
        meetings.add ( new Timing ( 5, 9 ) );

        System.out.println ( Meeting.maxMeetings ( meetings ) );

        List<Integer> candies = new ArrayList<> ( Arrays.asList ( 3, 2, 1, 4 ) );
        CandyStore.minMaxPriceCandies ( candies, 2 );
    }
}
