package Vehicles;

public abstract class Vehicle {
    private String id;
    private double maxCapacityKg;
    private double currentLoadKg;

    public Vehicle(String id, double maxCapacityKg) {
        this.id = id;
        if (maxCapacityKg <= 0) {
            throw new IllegalArgumentException("Грузоподъёмность должна быть > 0");
        }
        this.maxCapacityKg = maxCapacityKg;
    }

    public abstract void move();

    public void load(double weight) {
        if (currentLoadKg + weight <= maxCapacityKg) {
            currentLoadKg += weight;
        } else {
            System.out.println("Превышен лимит загрузки для " + id);
        }
    }

    public String getId() { return id; }
    public double getMaxCapacityKg() { return maxCapacityKg; }
    public double getCurrentLoadKg() { return currentLoadKg; }
}