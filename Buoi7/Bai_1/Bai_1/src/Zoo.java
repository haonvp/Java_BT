import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animal;

    public Zoo() {
        animal = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        this.animal.add(animal);
    }

    public void makeAllSounds() {
        System.out.println("Phát ra âm thanh của tất cả động vật trong vườn thú");
        for (int i = 0; i < animal.size(); i++) {
            animal.get(i).makeSound();
            System.out.println("");
        }
    }

    public void displayAllInfo() {
        System.out.print("=== Danh sách động vật trong vườn thú ===\n");
        for (int i = 0; i < animal.size(); i++) {
            animal.get(i).displayInfo();
        }
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }
}
