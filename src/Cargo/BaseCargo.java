package Cargo;

public abstract class BaseCargo implements ICargo {
    private String id;
    private String name;
    private double weight;

    public BaseCargo(String id, String name, double weight) {
        this.id = id;
        this.name = name;
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес должен быть > 0");
        }
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}