import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Meeting {

    public static int maxMeetings ( List<Timing> meetings ) {

        Collections.sort ( meetings, new Comparator () {
            public int compare ( Object a, Object b ) {
                Timing timing1 = ( Timing ) a;
                Timing timing2 = ( Timing ) b;

                if ( timing1.getEndTime () == timing2.getEndTime () ) {
                    return ( timing1.getStartTime () > timing2.getStartTime () ) ? 1 : -1;
                }

                return ( timing1.getEndTime () > timing2.getEndTime () ) ? 1 : -1;
            }
        } );

        int numberOfMeetings = 1;
        int endTime = meetings.get ( 0 ).getEndTime ();

        for ( int i = 1; i < meetings.size (); ++i ) {
            if ( endTime <= meetings.get ( i ).getStartTime () ) {
                ++numberOfMeetings;
                endTime = meetings.get ( i ).getEndTime ();
            }
        }

        return numberOfMeetings;
    }
}
