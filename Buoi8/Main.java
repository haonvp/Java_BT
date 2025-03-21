import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library(2);

        Book book1 = new BusinessBook("bb1", "Bussiness 1", 2020, "Alex", "Economic");
        Book book2 = new ScienceBook("bs1", "Science 1", 2021, "Tom", "Physic");

        library.addBook(book1);
        library.addBook(book2);

        while (true) {
            System.out.println("\nChọn chức năng");
            System.out.println("1. Thêm sách");
            System.out.println("2. Tìm sách");
            System.out.println("3. In danh sách");
            System.out.print("Mời chọn: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("Thêm sách Bussines chọn 1 - sách Science chọn 2: ");
                    int type = sc.nextInt();
                    Book newBook = (type == 1) ? new BusinessBook("", "", 0, "", "") : new ScienceBook("", "", 0, "", "");
                    newBook.inputInfo();
                    library.addBook(newBook);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Nhập author của sách cần tìm: ");
                    String author = sc.nextLine();
                    library.searchByAuthor(author);
                    break;
                case 3:
                    library.displayAllBooks();
                    break;
                default:
                    System.out.println("Chức năng không có trong danh sách");
                    break;
            }
        }
    }
}
