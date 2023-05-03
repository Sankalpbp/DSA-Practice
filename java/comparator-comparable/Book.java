public class Book implements Comparable {

    private int pages;
    private String name;

    public Book ( int pages ) {
        this.pages = pages;
    }

    public int getPages ( ) {
        return this.pages;
    }

    public String getName () {
        return this.name;
    }

    public void setPages ( int pages ) {
        this.pages = pages;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    @Override
    public String toString ( ) {
        return "\nPages: " + pages;
    }

    @Override
    public int compareTo ( Object other ) {
        Book otherBook = ( Book ) other;
        return ( this.pages > otherBook.pages ) ? 1 : ( ( this.pages == otherBook.pages ) ? 0 : -1 );
    }

}
