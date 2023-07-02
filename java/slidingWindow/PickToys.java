import java.util.Map;
import java.util.HashMap;

public class PickToys {

    public static final int MAX_TOY_TYPES = 2;

    public static int maxToys ( String toyTypes ) {

        Map<Character, Integer> countForToy = new HashMap<> ();

        int i = 0;
        int j = 0;
        
        int maximumToys = 0;

        while ( j < toyTypes.length () ) {

            if ( countForToy.containsKey ( toyTypes.charAt ( j ) ) ) {
                countForToy.put ( toyTypes.charAt ( j ), countForToy.get ( toyTypes.charAt ( j ) ) + 1 );
            } else {
                countForToy.put ( toyTypes.charAt ( j ), 1 );
            }

            if ( countForToy.size () < MAX_TOY_TYPES ) {
                ++j;
            } else if ( countForToy.size () == MAX_TOY_TYPES ) {
                maximumToys = Math.max ( maximumToys, ( j - i + 1 ) );
                ++j;
            } else if ( countForToy.size () > MAX_TOY_TYPES ) {

                while ( countForToy.size () > MAX_TOY_TYPES ) {
                    if ( countForToy.containsKey ( toyTypes.charAt ( i ) ) ) {
                        if ( countForToy.get ( toyTypes.charAt ( i ) ) > 0 ) {
                            countForToy.put ( toyTypes.charAt ( i ), countForToy.get ( toyTypes.charAt ( i ) ) - 1 );
                        }

                        if ( countForToy.get ( toyTypes.charAt ( i ) ) == 0 ) {
                            countForToy.remove ( toyTypes.charAt ( i ) );
                        }
                    }
                    ++i;
                }

                ++j;
            }
        }

        return maximumToys;
    }
}
