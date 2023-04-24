public class Main {

    public static void main ( String... args ) {

        ArrayStack stack = new ArrayStack ();

        for ( int i = 0; i < 10; ++i ) {
            stack.push ( i );
        }

        while ( stack.size () != 0 ) {
            System.out.println ( stack.top () );
            stack.pop ();
        }

        int [ ] arr = { 2, 8, 0, 7, 5, 3, 9, 6 };

        NearestGreaterToLeft ngtl = new NearestGreaterToLeft ();
        int [ ] output = ngtl.nearestGreaterToLeft ( arr );

        NearestGreaterToRight ngtr = new NearestGreaterToRight ();
        int [ ] output2 = ngtr.nearestGreaterToRight ( arr );

        System.out.println ();
        System.out.println ();

        NearestSmallerToTheLeft nstl = new NearestSmallerToTheLeft ( );
        int [ ] output3 = nstl.nearestSmallerToLeftInefficient ( arr );
        int [ ] output4 = nstl.nearestSmallerToLeft ( arr );

        System.out.println ();

        NearestSmallerToRight nstr = new NearestSmallerToRight ();
        int [ ] output5 = nstr.nearestSmallerToRight ( arr );

        System.out.println ();
        for ( int x : output5 ) {
            System.out.print ( x + " " );
        }
        System.out.println ();

        StockSpanProblem ssp = new StockSpanProblem ();
        int [ ] span = ssp.stockSpan ( arr );

        System.out.println ();
        for ( int x : span ) {
            System.out.print ( x + " " );
        }
        System.out.println ();

    }
}
