import java.util.Scanner;

public class ScienceBook extends Book {
    private String researchSubject;

    public ScienceBook(String id, String title, int year, String author, String researchSubject) {
        super(id, title, year, author);
        this.researchSubject = researchSubject;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("_ Research Subject: " + researchSubject);
    }

    @Override
    public void inputInfo() {
        System.out.println("+++ NHẬP THÔNG TIN SÁCH Science +++");
        Scanner sc = new Scanner(System.in);
        super.inputInfo();
        System.out.println("Nhập Research Subject: ");
        researchSubject = sc.nextLine();
    }
}
