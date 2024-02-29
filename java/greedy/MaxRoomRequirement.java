import java.util.Arrays;
import java.util.Comparator;

public class MaxRoomRequirement {

    private static final String ARRIVAL = "arrival";
    private static final String DEPARTURE = "departure";

    public static void print () {
        System.out.println ( "Max number of rooms required are: " + getMaxRoomsRequired ( new int [] { 900, 940, 950, 1100, 1500, 1800 }, 
                                                                                          new int [] { 910, 1200, 1120, 1130, 1900, 2000 } ) );
    }

    private static int getMaxRoomsRequired ( int [] arrivals, int [] departures ) {
        Time [] times = new Time [ arrivals.length + departures.length ];

        int number = 0;

        for ( int x : arrivals ) {
            times [ number++ ] = new Time ( x, ARRIVAL );
        }

        for ( int x : departures ) {
            times [ number ++ ] =  new Time ( x, DEPARTURE );
        }

        Arrays.sort ( times, new Comparator<Time> () {
            public int compare ( Time t1, Time t2 ) {
                return ( t1.value > t2.value ) ? 1
                                               : ( ( t1.value == t2.value ) ? 0
                                                                            : -1 );
            }
        } );

        int rooms = 0;
        int maxRooms = Integer.MIN_VALUE;

        for ( int i = 0; i < times.length; ++i ) {
            if ( times [ i ].type.equals ( ARRIVAL ) ) {
                ++rooms;
                maxRooms = Math.max ( rooms, maxRooms );
            } else {
                --rooms;
            }
        }

        return maxRooms;
    }

    private static class Time {
        int value;
        String type;

        public Time ( int value, String type ) {
            this.value = value;
            this.type = type;
        }

        public String toString ( ) {
            return "time: " + value + ", type: " + type;
        }
    }
}
