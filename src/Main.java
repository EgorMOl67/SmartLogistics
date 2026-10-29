import Vehicles.*;
import Cargo.*;
import Tracking.ITrackable;
import Manager.LogisticsCenter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ ЗАДАЧИ 3.3: Dependency Inversion & ITrackable ===");

        List<ITrackable> trackableFleet = new ArrayList<>();

        Truck truck = new Truck("TRUCK-01", 5000.0);
        Drone drone = new Drone("DRONE-01", 5.0, 80);
        Car car = new Car("CAR-01", 300); // Обычная машина

        trackableFleet.add(truck);
        trackableFleet.add(drone);

        // Попытка добавить car вызовет ошибку компиляции, так как Car не реализует ITrackable:
        // trackableFleet.add(car);

        LogisticsCenter logisticsCenter = new LogisticsCenter();

        System.out.println("Отправка статусов телеметрии:");
        logisticsCenter.dispatch(trackableFleet);

        System.out.println("\nМониторинг координат фლოта:");
        logisticsCenter.monitorFleet(trackableFleet);


        System.out.println("\n=== ДЕМОНСТРАЦИЯ ЗАДАЧИ 4: Дженерики, Warehouse и Report ===");

        // Создаем склады для конкретных типов грузов
        Warehouse<StandardBox> standardWarehouse = new Warehouse<>();
        standardWarehouse.addItem(new StandardBox("BOX-1", "Обычная коробка", 15.5));
        standardWarehouse.addItem(new StandardBox("BOX-2", "Маленькая коробка", 5.0));

        Warehouse<FragileItem> fragileWarehouse = new Warehouse<>();
        fragileWarehouse.addItem(new FragileItem("FRAG-1", "Хрупкая ваза", 3.2, true));

        // Попытка положить FragileItem в Warehouse<StandardBox> вызовет ошибку компиляции:
        // Дженерики инвариантны, обеспечивая строгую типобезопасность.
        // standardWarehouse.addItem(new FragileItem("ERR", "Ошибка", 1.0, true));

        // Генерация отчетов через универсальный класс Report<T>
        Report<Warehouse<StandardBox>> standardReport = new Report<>(standardWarehouse);
        Report<Warehouse<FragileItem>> fragileReport = new Report<>(fragileWarehouse);

        standardReport.printReport();
        System.out.println();
        fragileReport.printReport();
    }
}