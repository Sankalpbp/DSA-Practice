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
        final Map<Character, Integer> frequencyOfCharacter = new HashMap<> ();

        int occurrences = 0;

        int i = 0;
        int j = 0;

        while ( ( j - i + 1 ) < k ) {
            char ch = s.charAt ( j );
            if ( frequencyOfCharacter.containsKey ( ch ) ) {
                frequencyOfCharacter.put ( ch, frequencyOfCharacter.get ( ch ) + 1 );
            } else {
                frequencyOfCharacter.put ( ch, 1 );
            }
            ++j;
        }

        while ( j < s.length () ) {
            char ch = s.charAt ( j );
            if ( frequencyOfCharacter.containsKey ( ch ) ) {
                frequencyOfCharacter.put ( ch, frequencyOfCharacter.get ( ch ) + 1 );
            } else {
                frequencyOfCharacter.put ( ch, 1 );
            }

            if ( matchFrequency ( frequency, frequencyOfCharacter ) ) {
                ++occurrences;
            }

            frequencyOfCharacter.put ( ch, frequencyOfCharacter.get ( ch ) - 1 );

            ++i;
            ++j;
        }

        return occurrences;
    }
}
