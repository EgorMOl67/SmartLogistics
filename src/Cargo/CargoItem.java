package Cargo;

public class CargoItem {
    private String name;
    private double weight;

    public CargoItem(String name, double weight) {
        this.name = name;
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес должен быть положительным");
        }
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}