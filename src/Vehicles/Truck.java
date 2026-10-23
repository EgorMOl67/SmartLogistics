package Vehicles;

import Tracking.ITrackable;

public class Truck extends Vehicle implements ITrackable {
    private double latitude = 54.7388;
    private double longitude = 55.9721;

    public Truck(String id, double maxCapacityKg) {
        super(id, maxCapacityKg);
    }

    @Override
    public void move() {
        // Имитация GPS-изменения координат при движении
        latitude += 0.01;
        longitude += 0.01;
        System.out.println("Грузовик " + getId() + " едет по трассе со скоростью 70 км/ч");
    }

    @Override
    public String getCurrentCoordinates() {
        return String.format("Lat: %.4f, Lon: %.4f", latitude, longitude);
    }

    @Override
    public void sendStatusUpdate() {
        System.out.println("Грузовик [" + getId() + "] передает телеметрию. Координаты: " + getCurrentCoordinates());
    }
}