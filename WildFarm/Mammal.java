package WildFarm;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public void eat(Food food) {
        boolean foodIsMeat = food.getClass().getSimpleName().equals("Meat");

        if (foodIsMeat && !(this instanceof Feline)) {

            String message = (this.getAnimalType() + "s are not eating that type of food!").replace("Mouses", "Mice");

            throw new IllegalArgumentException();
        } else if (!foodIsMeat && this.getAnimalType().equals("Tiger")){
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }

        super.eat(food);
    }

    @Override
    public String toString() {
        return super.toString().replace("region", this.livingRegion);
    }
}
