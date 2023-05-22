import java.util.Map;
import java.util.HashMap;

public class CountOccurrencesOfAnagrams {

    private static void getFrequency ( final String pattern, final Map<Character, Integer> frequency ) {
        for ( char ch : pattern.toCharArray () ) {
            if ( frequency.containsKey ( ch ) ) {
                frequency.put ( ch, frequency.get ( ch ) + 1 );
            } else {
                frequency.put ( ch, 1 );
            }
        }
    }

    public static int count ( final String s, final String pattern ) {

        int k = pattern.length ();
        final Map<Character, Integer> frequency = new HashMap<> ();
        getFrequency ( pattern, frequency );

        int occurrences = 0;
        int count = frequency.entrySet ().size ();

        int i = 0;
        int j = 0;

        while ( j < s.length () ) {
            char ch = s.charAt ( j );

            if ( frequency.containsKey ( ch ) ) {
                frequency.put ( ch, frequency.get ( ch ) - 1 );
                // to keep track of the number of characters which are 
                // successfully found to have the same number as there 
                // are in the anagram
                if ( frequency.get ( ch ) == 0 ) {
                    --count;
                }
            }

            if ( ( j - i + 1 ) < k ) {
                ++j;
            } else if ( ( j - i + 1 ) == k ) {
                // update the occurrences
                if ( count == 0 ) {
                    ++occurrences;
                }

                // slide the window
                if ( frequency.containsKey ( s.charAt ( i ) ) ) {
                    frequency.put ( s.charAt ( i ), frequency.get ( s.charAt ( i ) ) + 1 );
                    // to keep track of the updated number of characters because we are 
                    // sliding the window
                    if ( frequency.get ( s.charAt ( i ) ) == 1 ) {
                        ++count;
                    }
                }
                ++j;
                ++i;
            }
        }

        return occurrences;
    }
}
