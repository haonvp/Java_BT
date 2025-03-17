import java.util.Scanner;

public class Dog extends Animal {
    private String breed;

    @Override
    void makeSound() {
        System.out.print("Woof! Woof!");
    }

    @Override
    public void inputInfo() {
        System.out.println("*** CHÓ ***");
        super.inputInfo();
        System.out.print("Nhập giống chó: ");
        breed = new Scanner(System.in).nextLine();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giống chó: " + this.breed);
        System.out.println("============================");
    }
}
