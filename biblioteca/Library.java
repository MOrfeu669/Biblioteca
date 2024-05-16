import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<Book> collection;

    public Library() {
        collection = new ArrayList<>();
    }

    public List<Book> getCollection() {
        return collection;
    }

    public List<Book> getCollection(String title) {
        List<Book> foundBooks = new ArrayList<>();

        for (Book book : collection) {
            if (book.getTitle().contains(title)) {
                foundBooks.add(book);
            }
        }

        return foundBooks;
    }

    public void addBook(Book book) throws Exception {
        if (book == null) {
            throw new Exception("Object can't be null");
        }
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new Exception("Title is a mandatory field");
        }
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new Exception("Author is a mandatory field");
        }
        collection.add(book);
    }

    public void removeBook(String title) throws Exception {
        List<Book> booksToRemove = getCollection(title);
        if (booksToRemove.isEmpty()) {
            throw new Exception("No books found with the title: " + title);
        }
        collection.removeAll(booksToRemove);
    }
}
