import java.util.List;
import java.util.Scanner;

public class Main {
    private static Library library = new Library();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a new book");
            System.out.println("2. List all books");
            System.out.println("3. Search a book by title");
            System.out.println("4. Remove a book by title");
            System.out.println("5. Exit");

            int choice = scan.nextInt();
            scan.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewBook(scan);
                    break;
                case 2:
                    printBookList();
                    break;
                case 3:
                    searchBookByTitle(scan);
                    break;
                case 4:
                    removeBookByTitle(scan);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scan.close();
    }

    private static void addNewBook(Scanner scan) {
        System.out.println("Insert title: ");
        String title = scan.nextLine();

        System.out.println("Insert author: ");
        String author = scan.nextLine();

        System.out.println("Insert year: ");
        int year = scan.nextInt();
        scan.nextLine(); // Consume newline

        System.out.println("Insert page number: ");
        int pages = scan.nextInt();
        scan.nextLine(); // Consume newline

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setYear(year);
        newBook.setPages(pages);

        try {
            library.addBook(newBook);
            System.out.println("Book registered successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void searchBookByTitle(Scanner scan) {
        System.out.println("Insert title to search: ");
        String title = scan.nextLine();

        List<Book> foundBooks = library.getCollection(title);

        if (foundBooks.isEmpty()) {
            System.out.println("No books found with the title: " + title);
        } else {
            System.out.println("Books found:");
            for (Book book : foundBooks) {
                System.out.println("- Title: " + book.getTitle());
                System.out.println("- Author: " + book.getAuthor());
                System.out.println("- Year: " + book.getYear());
                System.out.println("- Page Number: " + book.getPages());
            }
        }
    }

    private static void removeBookByTitle(Scanner scan) {
        System.out.println("Insert title to remove: ");
        String title = scan.nextLine();

        try {
            library.removeBook(title);
            System.out.println("Book(s) removed successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printBookList() {
        List<Book> books = library.getCollection();

        System.out.println("Books in the collection:");
        for (Book book : books) {
            System.out.println("- Title: " + book.getTitle());
            System.out.println("- Author: " + book.getAuthor());
            System.out.println("- Year: " + book.getYear());
            System.out.println("- Page Number: " + book.getPages());
        }
    }
}
