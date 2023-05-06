import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Collections;

public class KClosestPointsToOrigin {

    private double getDistanceFromOrigin ( List<Integer> point ) {
        int x = point.get ( 0 );
        int y = point.get ( 1 );

        return Math.sqrt ( x * x + y * y );
    }

    public List<List<Integer> > kClosest ( List<List<Integer> > points, int k ) {

        if ( k > points.size () ) {
            return new ArrayList<> ( 0 );
        }

        PriorityQueue<Point> maxHeap = new PriorityQueue<> ( Collections.reverseOrder () );

        for ( int i = 0; i < k; ++i ) {
            maxHeap.add ( new Point ( i, getDistanceFromOrigin ( points.get ( i ) ) ) );
        }

        for ( int i = k; i < points.size (); ++i ) {
            maxHeap.add ( new Point ( i, getDistanceFromOrigin ( points.get ( i ) ) ) );
            maxHeap.poll ();
        }

        List<List<Integer> > output = new ArrayList<> ();

        while ( !maxHeap.isEmpty () ) {
            output.add ( points.get ( maxHeap.poll ().getIndex () ) );
        }

        return output;
    }

    private static class Point implements Comparable<Point> {

        private int index;
        private double distance;

        public Point ( int index, double distance ) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex ( ) {
            return this.index;
        }

        public double getDistance ( ) {
            return this.distance;
        }

        @Override
        public String toString () {
            return index + " " + distance;
        }

        @Override
        public int compareTo ( Point other ) {
            return ( this.distance == other.distance ) ? 0 : ( ( this.distance > other.distance ) ? 1 : -1 );
        }

    }

}
