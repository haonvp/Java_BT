import java.util.Scanner;

public class Cat extends Animal {
    private String breed;

    @Override
    void makeSound() {
        System.out.print("Meow! Meow!");
    }

    @Override
    public void inputInfo() {
        System.out.println("*** MÈO ***");
        super.inputInfo();
        System.out.print("Nhập giống mèo: ");
        breed = new Scanner(System.in).nextLine();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giống mèo: " + this.breed);
        System.out.println("============================");
    }
}
