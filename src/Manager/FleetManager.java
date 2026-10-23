package Manager;

import Vehicles.Vehicle;
import java.util.List;

public class FleetManager {
    public void startDelivery(List<Vehicle> fleet) {
        for (Vehicle v : fleet) {
            v.move();  // полиморфный вызов
        }
    }
}