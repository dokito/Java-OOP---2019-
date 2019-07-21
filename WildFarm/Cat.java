package WildFarm;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        String baseToString = super.toString();
        int index = baseToString.indexOf(",");

        StringBuilder builder = new StringBuilder(baseToString);

        builder.insert(index + 2, this.breed + ", ");

        return builder.toString();
    }
}
