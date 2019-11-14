package semester1.chapter12.Task5;

public class Book {
    public Book next;
    public int isbn;
    public String title;
    public String author;
    public String publisher;

    public Book(int isbn, String title, String author, String publisher) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public String toString() {
        return "#" + isbn + ", " + title + " by " + author + ", Published by " + publisher;
    }
}