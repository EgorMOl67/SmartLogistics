package Vehicles;

public class Car extends Vehicle {
    private int passengerCount;

    public Car(String id, int passengerCount) {
        super(id, 500.0); // Фиксированная макс. грузоподъёмность 500 кг
        this.passengerCount = passengerCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    @Override
    public void move() {}
}
