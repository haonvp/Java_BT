import java.util.Scanner;

public abstract class Book {
    protected String id;
    protected String title;
    protected int year;
    protected String author;

    public Book(String id, String title, int year, String author) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("_ ID: " + id);
        System.out.println("_ Title: " + title);
        System.out.println("_ Year: " + year);
        System.out.println("_ Author: " + author);
    }

    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID: ");
        id = sc.nextLine();
        System.out.print("Nhập Title: ");
        title = sc.nextLine();
        System.out.print("Nhập Year: ");
        year = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập Author: ");
        author = sc.nextLine();
    }
}
