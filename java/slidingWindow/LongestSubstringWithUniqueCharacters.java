import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithUniqueCharacters {

    /*
     * k: number of unique characters
     */
    public static int longestSubstring ( String s, int k ) {

        Map<Character, Integer> frequencyForCharacter = new HashMap<Character, Integer> ();
        int i = 0;
        int j = 0;

        int longest = 0;

        while ( j < s.length () ) {

            if ( frequencyForCharacter.containsKey ( s.charAt ( j ) ) ) {
                frequencyForCharacter.put ( s.charAt ( j ), frequencyForCharacter.get ( s.charAt ( j ) ) + 1 );
            } else {
                frequencyForCharacter.put ( s.charAt ( j ), 1 );
            }

            if ( frequencyForCharacter.size () < k ) {
                ++j;
            } else if ( frequencyForCharacter.size () == k ) {
                // possible solution;
                longest = Math.max ( longest, ( j - i + 1 ) );
                ++j;
            } else if ( frequencyForCharacter.size () > k ) {
                while ( frequencyForCharacter.size () > k ) {
                    if ( frequencyForCharacter.containsKey ( s.charAt ( i ) ) ) {
                        if ( frequencyForCharacter.get ( s.charAt ( i ) ) > 0 ) {
                            frequencyForCharacter.put ( s.charAt ( i ), frequencyForCharacter.get ( s.charAt ( i ) ) - 1 );
                        }

                        if ( frequencyForCharacter.get ( s.charAt ( i ) ) == 0 ) {
                            frequencyForCharacter.remove ( s.charAt ( i ) );
                        }
                    }
                    ++i;
                }
                ++j;
            }
        }

        return longest;
    }
}
