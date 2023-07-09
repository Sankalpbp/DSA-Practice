import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class FractionalKnapsack {

    public static double getProfit ( List<Integer> weight, List<Integer> price, int maxWeight ) {
        List<Item> items = new ArrayList<> ();
        for ( int i = 0; i < weight.size (); ++i ) {
            items.add ( new Item ( price.get ( i ), weight.get ( i ) ) );
        }
        return getProfit ( items, maxWeight );
    }

    private static double getProfit ( List<Item> items, int maxWeight ) {

        Collections.sort ( items, new Comparator () {
            public int compare ( Object object1, Object object2 ) {
                Item item1 = ( Item ) object1;
                Item item2 = ( Item ) object2;

                double item1PricePerWeight = ( double ) item1.price / item1.weight;
                double item2PricePerWeight = ( double ) item2.price / item2.weight;

                return ( item1PricePerWeight == item2PricePerWeight )
                       ? 0
                       : ( item1PricePerWeight > item2PricePerWeight )
                         ? -1
                         : 1;
            }
        } );

        int weight = 0;
        double profit = 0;

        for ( int i = 0; i < items.size (); ++i ) {
            if ( weight + items.get ( i ).weight <= maxWeight ) {
                profit += items.get ( i ).price;
                weight += items.get ( i ).weight;
            } else {
                profit += ( ( double ) items.get ( i ).price / items.get ( i ).weight ) * ( maxWeight - weight );
                break;
            }
        }

        return profit;
    }

    private static class Item {
        public int price;
        public int weight;

        public Item ( int price, int weight ) {
            this.price = price;
            this.weight = weight;
        }

        public String toString ( ) {
            return "Price: " + this.price + "\nWeight: " + this.weight;
        }
    }
}
