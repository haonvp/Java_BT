public class Library implements ILibrary {
    private Book[] book;
    private int sizeBook;

    public Library(int size) {
        book = new Book[size];
        size = 0;
    }

    @Override
    public void addBook(Book book) {
        if (sizeBook <= this.book.length) {
            Book[] newBook = new Book[this.book.length * 2];
            for (int i = 0; i < this.book.length; i++) {
                newBook[i] = this.book[i];
            }
            this.book = newBook;
        }
        this.book[sizeBook++] = book;
    }

    @Override
    public void searchByAuthor(String author) {
        boolean found = false;
        for (int i = 0; i < sizeBook; i++) {
            if (this.book[i].author.toLowerCase().contains(author)) {
                book[i].displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách với author " + author);
        }
    }

    @Override
    public void displayAllBooks() {
        System.out.println("*** THÔNG TIN SÁCH ***");
        for (int i = 0; i < sizeBook; i++) {
            book[i].displayInfo();
            System.out.println("===========================");
        }
    }
}
