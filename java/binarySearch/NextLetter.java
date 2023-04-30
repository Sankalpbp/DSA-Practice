public class NextLetter {

    public char nextLetter ( char [ ] letters, char letter ) {

        int start = 0;
        int end = letters.length - 1;

        int mid;
        char nextLetter = 0;

        while ( start <= end ) {
            
            mid = start + ( end - start ) / 2;

            if ( letters [ mid ] == letter ) {
                return ( mid + 1 ) < letters.length ? letters [ mid + 1 ] : 0;
            } else if ( letters [ mid ] > letter ) {
                nextLetter = letters [ mid ];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return nextLetter;
    }
}
