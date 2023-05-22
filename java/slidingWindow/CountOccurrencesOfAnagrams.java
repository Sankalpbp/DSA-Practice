import java.util.Map;
import java.util.HashMap;

public class CountOccurrencesOfAnagrams {

    private static boolean matchFrequency ( final Map<Character, Integer> frequency, 
                                            final Map<Character, Integer> frequencyOfCharacter ) {
        for ( Map.Entry<Character, Integer> entry : frequencyOfCharacter.entrySet () ) {
            if ( entry.getValue () > 0 && 
                 ( !frequency.containsKey ( entry.getKey () ) ||
                   frequency.get ( entry.getKey () ) != entry.getValue () ) ) {
                return false;
            }
        }

        return true;
    }

    private static void insertInMap ( final Map<Character, Integer> frequency, char ch ) {
        if ( frequency.containsKey ( ch ) ) {
            frequency.put ( ch, frequency.get ( ch ) + 1 );
        } else {
            frequency.put ( ch, 1 );
        }
    }

    private static void getFrequency ( final String pattern, final Map<Character, Integer> frequency ) {
        for ( char ch : pattern.toCharArray () ) {
            insertInMap ( frequency, ch );
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
