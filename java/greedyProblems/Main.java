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

        System.out.println ( SurviveOnIsland.buyFoodDays ( 10, 30, 20 ) );
        System.out.println ( SurviveOnIsland.buyFoodDays ( 5, 2, 2 ) );
        System.out.println ( SurviveOnIsland.buyFoodDays ( 10, 1, 1 ) );

        System.out.println ( ReverseWords.reverse ( "you.are.all.singing" ) );

        List<Integer> chocolates = new ArrayList<> ( Arrays.asList ( 3, 4, 1, 9, 56, 7, 9, 12 ) );
        System.out.println ( MinDiffChocolates.minimum ( chocolates, 5 ) );

        List<Integer> frequencies = Arrays.asList ( 5, 9, 12, 13, 16, 45 );
        System.out.println ( HuffmanCodes.getCodes ( "abcdef", frequencies ) );

        List<Integer> weights = Arrays.asList ( 10, 20, 30 );
        List<Integer> prices = Arrays.asList ( 60, 100, 120 );

        System.out.println ( FractionalKnapsack.getProfit ( weights, prices, 50 ) );

        List<Integer> profits = Arrays.asList ( 20, 10, 40, 30 );
        List<Integer> weights2 = Arrays.asList ( 4, 1, 1, 1 );

        Pair answer = JobSequencing.profit ( profits, weights2 );
        System.out.println ( "profit: " + answer.getFirst () + " jobs: " + answer.getSecond () );
    }
}
