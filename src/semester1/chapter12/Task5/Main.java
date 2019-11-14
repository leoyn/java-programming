package semester1.chapter12.Task5;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book(3, "Computer science for beginners", "John Smith", "ABC")).addBook(new Book(2, "Routing 101", "Netty Nielson", "ABC")).addBook(new Book(1, "Security pitfalls", "George Seck", "ABC"));
        library.removeBook(2);

        System.out.println(library.getNextBook());
        System.out.println(library.getNextBook());
        System.out.println(library.getNextBook());

        System.out.println(library.getBook(3));
    }
}