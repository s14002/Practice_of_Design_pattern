package jp.ac.it_college.std.s14002.pdp;

import jp.ac.it_college.std.s14002.pdp.Book;
import jp.ac.it_college.std.s14002.pdp.BookShelf;
import jp.ac.it_college.std.s14002.pdp.Iterator;

/**
 * Created by s14002 on 15/06/02.
 */
public class Main {
    public static void main(String[] args) {
        IteratorMain();
    }
    public static void IteratorMain() {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }
}
