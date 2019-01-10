package chapter12.Task5;

public class Library {
    public Book head;
    public int index;
    public int count;

    public Library() {
        index = 0;
    }

    public Library addBook(Book book) {
        if(head != null) {
            Book currentBook = head;
            Book previousBook = null;

            while(currentBook != null && currentBook.isbn < book.isbn) {
                
                previousBook = currentBook;
                currentBook = currentBook.next;
            }

            book.next = currentBook;
            if(previousBook != null) previousBook.next = book;
            else head = book;
        } else head = book;

        count++;
        return this;
    }

    public Library removeBook(int isbn) {
        Book prev = null;
        Book book = head;

        while(book != null && book.isbn != isbn) {
            prev = book;
            book = book.next;
        }

        if(prev != null) {
            prev.next = book.next;
            count--;
        }


        return this;
    }

    public Book getBook(int isbn) {
        Book book = head;

        while(book != null) {
            if(book.isbn == isbn) return book;
            book = book.next;
        }

        return null;
    }

    public Book getNextBook() {
        Book book = head;
        int i = 0;

        while(book != null && i < index) {
            book = book.next;
            i++;
        }

        index = (index + 1) % count;

        if(book != null) return book;
        else return null;
    }
}