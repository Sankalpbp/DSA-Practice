import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ListIterator;
import java.util.Collections;

public class FrequencySort {

    private Map<Integer, Integer> getFrequencies ( List<Integer> list ) {
        Map<Integer, Integer> frequencyOfElement = new HashMap<> ();

        ListIterator<Integer> iterator = list.listIterator ();
        int element = 0;

        while ( iterator.hasNext () ) {
            element = iterator.next ();

            if ( frequencyOfElement.containsKey ( element ) ) {
                frequencyOfElement.put ( element, frequencyOfElement.get ( element ) + 1 );
            } else {
                frequencyOfElement.put ( element, 1 );
            }
        }

        return frequencyOfElement;
    }

    public List<Integer> sort ( List<Integer> list ) {

        Map<Integer, Integer> frequencyOfElement = getFrequencies ( list );

        PriorityQueue<Element> maxHeap = new PriorityQueue<> ( Collections.reverseOrder () );

        for ( Map.Entry<Integer, Integer> entry : frequencyOfElement.entrySet () ) {
            maxHeap.add ( new Element ( entry.getKey (), entry.getValue () ) );
        }
    
        List<Integer> output = new ArrayList<> ( list.size () );

        Element element = null;
        int frequency = 0;

        while ( !maxHeap.isEmpty () ) {

            element = maxHeap.poll ();
            frequency = element.getFrequency ();

            while ( frequency > 0 ) {
                output.add ( element.getData () );
                --frequency;
            }
        }

        return output;
    }

    private static class Element implements Comparable<Element> {
        private int data;
        private int frequency;

        public Element ( int data, int frequency ) {
            this.data = data;
            this.frequency = frequency;
        }

        public int getData () {
            return this.data;
        }

        public int getFrequency () {
            return this.frequency;
        }

        @Override
        public int compareTo ( Element other ) {

            if ( this.frequency == other.frequency ) {
                if ( this.data == other.data ) {
                    return 0;
                } 
                return ( this.data > other.data ) ? 1 : -1;
            }

            return ( this.frequency > other.frequency ) ? 1 : -1;
        }

        @Override
        public String toString ( ) {
            return data + " " + frequency;
        }
    }
}
