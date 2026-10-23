package Manager;

import Tracking.ITrackable;
import java.util.List;

public class LogisticsCenter {
    // Принимает ТОЛЬКО отслеживаемый транспорт
    public void dispatch(List<ITrackable> trackableVehicles) {
        for (ITrackable v : trackableVehicles) {
            v.sendStatusUpdate();
        }
    }

    public void monitorFleet(List<ITrackable> trackableVehicles) {
        for (ITrackable v : trackableVehicles) {
            System.out.println(v.getClass().getSimpleName() + ": " + v.getCurrentCoordinates());
        }
    }
}