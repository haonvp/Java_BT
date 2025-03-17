public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Animal dog = new Dog();
        dog.inputInfo();
        zoo.addAnimal(dog);

        Animal cat = new Cat();
        cat.inputInfo();
        zoo.addAnimal(cat);

        Animal bird = new Bird();
        bird.inputInfo();
        zoo.addAnimal(bird);

        zoo.displayAllInfo();
        zoo.makeAllSounds();

        for (int i = 0; i < zoo.getAnimal().size(); i++) {
            if (zoo.getAnimal().get(i) instanceof Bird) {
                ((Bird) zoo.getAnimal().get(i)).fly();
            }
        }
    }
}