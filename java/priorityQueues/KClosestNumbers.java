import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collections;

public class KClosestNumbers {

    private int getDifference ( int element, int x ) {
        return Math.abs ( element - x );
    }

    public List<Integer> kClosest ( List<Integer> list, int k, int x ) {

        PriorityQueue<Element> maxHeap = list.stream ()
                                             .limit ( k )
                                             .map ( e -> new Element ( e, getDifference ( e, x ) ) )
                                             .collect ( Collectors.toCollection ( 
                                                            () -> new PriorityQueue ( Collections.reverseOrder () ) ) 
                                             );

        for ( int i = k; i < list.size (); ++i ) {
            maxHeap.add ( new Element ( list.get ( i ), getDifference ( list.get ( i ), x ) ) );
            System.out.println ( maxHeap.peek () );
            maxHeap.poll ();
        }

        return maxHeap.stream ()
                      .map ( e -> e.getData () )
                      .collect ( Collectors.toCollection ( ArrayList :: new ) );
    }

    private class Element implements Comparable<Element> {
        private int data;
        private int difference;

        public Element ( int data, int difference ) {
            this.data = data;
            this.difference = difference;
        }

        public int getData ( ) {
            return this.data;
        }

        public int getDifference ( ) {
            return this.difference;
        }

        @Override
        public int compareTo ( Element other ) {
            if ( this.getDifference () != other.getDifference () ) {
                return ( this.getDifference () > other.getDifference () ) ? 1 : -1;
            } else if ( this.getData () == other.getData () ) {
                return 0;
            }

            return ( this.getData () > other.getData () ) ? 1 : -1;
        }

        @Override
        public String toString () {
            return this.getData () + " " + this.getDifference ();
        }
    }

}
