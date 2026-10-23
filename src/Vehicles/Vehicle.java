package Vehicles;

import Cargo.CargoItem;
import java.util.List;
import java.util.ArrayList;

public abstract class Vehicle {
    private String id;
    private double maxCapacityKg;
    private double currentLoadKg;
    private List<CargoItem> cargoList = new ArrayList<>();

    public Vehicle(String id, double maxCapacityKg) {
        this.id = id;
        if (maxCapacityKg <= 0) {
            throw new IllegalArgumentException("Грузоподъёмность должна быть положительной");
        }
        this.maxCapacityKg = maxCapacityKg;
    }

    public abstract void move();

    // Версия 1: только вес (быстрая загрузка без имён)
    public void load(double weight) {
        if (currentLoadKg + weight <= maxCapacityKg) {
            currentLoadKg += weight;
            cargoList.add(new CargoItem("Стандартный груз", weight));
        } else {
            System.out.println("Превышен лимит загрузки для " + id);
        }
    }

    // Версия 2: именованный груз
    public void load(CargoItem item) {
        if (currentLoadKg + item.getWeight() <= maxCapacityKg) {
            currentLoadKg += item.getWeight();
            cargoList.add(item);
        } else {
            System.out.println("Превышен лимит загрузки для груза: " + item.getName());
        }
    }

    // Версия 3: партия грузов
    public void load(List<CargoItem> items) {
        double totalWeight = 0;
        for (CargoItem item : items) {
            totalWeight += item.getWeight();
        }

        if (currentLoadKg + totalWeight <= maxCapacityKg) {
            currentLoadKg += totalWeight;
            cargoList.addAll(items);
        } else {
            System.out.println("Превышен общий лимит загрузки для списка грузов");
        }
    }

    public String getId() {return id;}

    public double getMaxCapacityKg() {return maxCapacityKg;}

    public double getCurrentLoadKg() {return currentLoadKg;}

    public List<CargoItem> getCargoList() {return cargoList;}
}