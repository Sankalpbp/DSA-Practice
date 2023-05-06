import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Set;
import java.util.Iterator;

public class TopKFrequentNumbers {

    private Map<Integer, Integer> getFrequency ( List<Integer> list ) {

        Map<Integer, Integer> frequencyOfElement = new HashMap<> ();
        ListIterator<Integer> iterator = list.listIterator ();

        while ( iterator.hasNext () ) {
            int element = iterator.next ();
            if ( frequencyOfElement.containsKey ( element ) ) {
                frequencyOfElement.put ( element, frequencyOfElement.get ( element ) + 1 );
            } else {
                frequencyOfElement.put ( element, 1 );
            }
        }

        return frequencyOfElement;
    }

    public List<Integer> topKFrequent ( List<Integer> list, int k ) {

        final Map<Integer, Integer> frequencyOfElement = getFrequency ( list );

        if ( frequencyOfElement.size () < k ) {
            return new ArrayList<> ( 0 );
        }

        PriorityQueue<Element> minHeap = new PriorityQueue<> ();

        int i = 0;

        Set<Map.Entry<Integer, Integer> > entries = frequencyOfElement.entrySet ();
        Iterator<Map.Entry<Integer, Integer> > entryIterator = entries.iterator ();
        Map.Entry<Integer, Integer> entry = null;

        while ( entryIterator.hasNext () && i < k ) {
            entry = entryIterator.next ();
            minHeap.add ( new Element ( entry.getKey (), entry.getValue () ) );
            ++i;
        }

        while ( entryIterator.hasNext () ) {
            entry = entryIterator.next ();
            minHeap.add ( new Element ( entry.getKey (), entry.getValue () ) );
            minHeap.poll ();
        }

        List<Integer> output = new ArrayList<> ();
        for ( Element element : minHeap ) {
            output.add ( element.getData () );
        }

        return output;
    }

    private class Element implements Comparable<Element> {

        private int data;
        private int frequency;

        public Element ( int data, int frequency ) {
            this.data = data;
            this.frequency = frequency;
        }

        public int getData ( ) {
            return this.data;
        }

        public int getFrequency ( ) {
            return this.frequency;
        }

        @Override
        public String toString () {
            return this.data + " " + this.frequency;
        }

        @Override
        public int compareTo ( Element other ) {

            if ( this.frequency == other.frequency ) {
                if ( this.data == other.data ) {
                    return 0;
                } else {
                    return ( this.data > other.data ) ? 1 : -1;
                }
            }

            return ( this.frequency > other.frequency ) ? 1 : -1;
        }
    }
}

