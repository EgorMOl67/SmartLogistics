import Vehicles.*;
import Cargo.*;
import Tracking.ITrackable;
import Manager.LogisticsCenter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(" 2.2: Перегрузка методов load()");

        Truck truck = new Truck("TRUCK-LOAD", 5000.0);

        // 1. Вызов ВЕРСИИ 1 (только вес)
        truck.load(100.0);
        System.out.println("После load(100.0): загружено " + truck.getCurrentLoadKg() + " кг");

        // 2. Вызов ВЕРСИИ 2 (один объект CargoItem)
        CargoItem box = new CargoItem("Коробка с документами", 50.0);
        truck.load(box);
        System.out.println("После load(CargoItem): загружено " + truck.getCurrentLoadKg() + " кг");

        // 3. Вызов ВЕРСИИ 3 (список объектов List<CargoItem>)
        List<CargoItem> batch = new ArrayList<>();
        batch.add(new CargoItem("Ящик 1", 1000.0));
        batch.add(new CargoItem("Ящик 2", 2000.0));
        truck.load(batch);
        System.out.println("После load(List): загружено " + truck.getCurrentLoadKg() + " кг\n");



        System.out.println("3.3: Dependency Inversion & ITrackable");

        List<ITrackable> trackableFleet = new ArrayList<>();

        //Truck truck = new Truck("TRUCK-01", 5000.0);
        Drone drone = new Drone("DRONE-01", 5.0, 80);
        Car car = new Car("CAR-01", 300); // Обычная машина

        trackableFleet.add(truck);
        trackableFleet.add(drone);
        System.out.println(trackableFleet);

        LogisticsCenter logisticsCenter = new LogisticsCenter();

        System.out.println("\nОтправка статусов телеметрии:");
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