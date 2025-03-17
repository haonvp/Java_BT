import java.util.Scanner;

public class Bird extends Animal {
    private double wingSpan;

    @Override
    void makeSound() {
        System.out.print("Tweet! Tweet!");
    }

    @Override
    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** CHIM ***");
        super.inputInfo();
        while (true) {
            System.out.print("Nhập sải cánh: ");
            if (scanner.hasNextDouble()) {
                wingSpan = scanner.nextDouble();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Nhập sải cánh phải là số, xin nhập lại...");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sải cánh: " + this.wingSpan + " mét");
        System.out.println("============================");
    }

    public void fly() {
        System.out.println("Chim bay với sải cánh: " + this.wingSpan + " mét");
    }
}
