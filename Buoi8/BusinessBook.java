import java.util.Scanner;

public class BusinessBook extends Book {
    private String businessField;

    public BusinessBook(String id, String title, int year, String author, String businessField) {
        super(id, title, year, author);
        this.businessField = businessField;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("_ Bussiness Field: " + businessField);
    }

    @Override
    public void inputInfo() {
        System.out.println("+++ NHẬP THÔNG TIN SÁCH Bussiness +++");
        Scanner sc = new Scanner(System.in);
        super.inputInfo();
        System.out.print("Nhập Bussiness Field: ");
        businessField = sc.nextLine();
    }
}
