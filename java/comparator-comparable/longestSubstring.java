public class longestSubstring {

    public static void main ( String... arg ) {

        String x = "abcdef";
        String y = "bcd";

        char [] xA = x.toCharArray ();
        char [] yA = y.toCharArray ();

        int maxLen = 0;

        for ( int i = 0; i < xA.length; ++i ) {
            for ( int j = i; j < xA.length; ++j ) {
                String s = x.substring ( i, j + 1 );
                if ( y.contains ( s ) ) {
                    maxLen = Math.max ( maxLen, s.length () );
                }
            }
        }

        System.out.println ( maxLen );
    }
}
