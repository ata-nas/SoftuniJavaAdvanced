package softuni.advanced.iteratorsandcomparators.lab;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books){
        this.books = books;
    }

    private final class LibIterator implements Iterator<Book> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
            if (this.hasNext()) {
                return books[index++];
            }
            return null;
        }
    }
    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
