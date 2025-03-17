import java.util.Scanner;

public abstract class Animal {
    private String name;
    private int age;
    private String species;
    private String color;

    abstract void makeSound();

    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        name = scanner.nextLine();
        while (true) {
            System.out.print("Nhập tuổi: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Tuổi phải là số nguyên, xin nhập lại ....");
                scanner.nextLine();
            }
        }
        System.out.print("Nhập loài: ");
        species = scanner.nextLine();
        System.out.print("Nhập màu sắc: ");
        color = scanner.nextLine();
    }

    public void displayInfo() {
        System.out.println("Tên: " + this.name);
        System.out.println("Tuổi: " + this.age);
        System.out.println("Loài: " + this.species);
        System.out.println("Màu sắc: " + this.color);
    }
}
