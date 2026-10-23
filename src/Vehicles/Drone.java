package Vehicles;

public class Drone extends Vehicle {
    private int batteryLevel;

    public Drone(String id, int batteryLevel) {
        super(id, 5.0); // Фиксированная макс. грузоподъёмность 5 кг
        if (batteryLevel < 0 || batteryLevel > 100) {
            throw new IllegalArgumentException("Заряд батареи должен быть от 0 до 100%");
        }
        this.batteryLevel = batteryLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void move() {
        // Уменьшаем заряд на 5% при каждом вызове (но не ниже 0)
        batteryLevel = Math.max(0, batteryLevel - 5);
        System.out.println("Дрон " + getId() + " летит по воздуху, заряд батареи: " + batteryLevel + "%");
    }
}