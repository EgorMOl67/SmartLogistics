package Vehicles;

import Tracking.ITrackable;

public class Drone extends Vehicle implements ITrackable {
    private int batteryLevel;
    private double latitude = 54.7388;
    private double longitude = 55.9721;
    private double altitude = 50.0; // высота в метрах

    public Drone(String id, double maxCapacityKg, int batteryLevel) {
        super(id, maxCapacityKg);
        if (batteryLevel < 0 || batteryLevel > 100) {
            throw new IllegalArgumentException("Заряд батареи должен быть от 0 до 100%");
        }
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void move() {
        // Имитация GPS-изменения координат/высоты и разряда батареи
        latitude += 0.05;
        longitude += 0.05;
        altitude += 10.0;
        batteryLevel = Math.max(0, batteryLevel - 5);

        System.out.println("Дрон " + getId() + " летит по воздуху, заряд батареи: " + batteryLevel + "%");
    }

    @Override
    public String getCurrentCoordinates() {
        return String.format("Lat: %.4f, Lon: %.4f, Alt: %.1fm", latitude, longitude, altitude);
    }

    @Override
    public void sendStatusUpdate() {
        System.out.println("Дрон [" + getId() + "] передает телеметрию. Позиция: " + getCurrentCoordinates() + ", Заряд: " + batteryLevel + "%");
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
}