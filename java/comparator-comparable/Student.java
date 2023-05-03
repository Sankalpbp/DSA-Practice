public class Student {
    private int booksRead;
    private int age;

    public Student ( int booksRead, int age ) {
        this.booksRead = booksRead;
        this.age = age;
    }

    public int getBooksRead  ( ) {
        return this.booksRead;
    } 

    public int getAge ( ) {
        return this.age;
    }

    public void setBooksRead ( int booksRead ) {
        this.booksRead = booksRead;
    }

    public void setAge ( int age ) {
        this.age = age;
    }

    @Override
    public String toString ( ) {
        return "\nbooksRead: " + this.booksRead + " age: " + this.age;
    }
};
