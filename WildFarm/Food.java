package WildFarm;

public abstract class Food {
    private int quantity;

    public int getQuantity() {
        return this.quantity;
    }

    protected Food(int quantity) {
        this.quantity = quantity;
    }
}
