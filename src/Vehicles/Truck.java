package Vehicles;

public class Truck extends Vehicle {
    private boolean hasTrailer;

    public Truck(String id, double baseCapacityKg, boolean hasTrailer) {
        super(id, hasTrailer ? baseCapacityKg + 5000.0 : baseCapacityKg);
        this.hasTrailer = hasTrailer;
    }

    public boolean isHasTrailer() {
        return hasTrailer;
    }

    @Override
    public void move() {}
}
