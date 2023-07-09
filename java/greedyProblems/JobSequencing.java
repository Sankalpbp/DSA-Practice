import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class JobSequencing {

    public static Pair profit ( List<Integer> profit, List<Integer> deadline ) {
        List<Job> jobs = new ArrayList<> ( profit.size () );
        for ( int i = 0; i < profit.size (); ++i ) {
            jobs.add ( new Job ( i + 1, profit.get ( i ), deadline.get ( i ) ) );
        }

        return profit ( jobs );
    }

    public static Pair profit ( List<Job> jobs ) {

        Collections.sort ( jobs, new Comparator () {
            public int compare ( Object object1, Object object2 ) {
                Job job1 = ( Job ) object1;
                Job job2 = ( Job ) object2;

                if ( job1.profit == job2.profit ) {
                    return ( job1.deadline == job2.deadline ) 
                           ? 0
                           : ( job1.deadline > job2.deadline )
                             ? -1
                             : 1;
                }

                return ( job1.profit > job2.profit )
                       ? -1
                       : 1;
            }
        } );

        int maxDeadline = getMaxDeadline ( jobs );

        List<Integer> deadlines = new ArrayList<> ( maxDeadline + 1 );
        for ( int i = 0; i < jobs.size () + 1; ++i ) {
            deadlines.add ( -1 );
        }

        int profitMade = 0;
        int jobsDone = 0;

        for ( int i = 0; i < jobs.size (); ++i ) {
            if ( deadlines.get ( jobs.get ( i ).deadline ) == -1 ) {
                profitMade += jobs.get ( i ).profit;
                deadlines.set ( jobs.get ( i ).deadline, i );
                ++jobsDone;
            }
        }

        return new Pair ( profitMade, jobsDone );
    }

    private static int getMaxDeadline ( List<Job> jobs ) {
        int maxDeadline = Integer.MIN_VALUE;

        for ( int i = 0; i < jobs.size (); ++i ) {
            maxDeadline = Math.max ( maxDeadline, jobs.get ( i ).deadline );
        }

        return maxDeadline;
    }

    private static class Job {
        public int id;
        public int profit;
        public int deadline;

        public Job ( int id, int profit, int deadline ) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }

        public String toString ( ) {
            return "\nid: " + id + "\nprofit: " + profit + "\ndeadline: " + deadline;
        }
    }
}
