import Vehicles.*;
import Cargo.*;
import Manager.LogisticsCenter;

public class Main {
    public static void main(String[] args) {
        Warehouse<StandardBox> standardWarehouse = new Warehouse<>();
        Warehouse<FragileItem> fragileWarehouse = new Warehouse<>();

        // Наполняем склады
        standardWarehouse.addItem(new StandardBox("BOX-1", "Обычная коробка 1", 15.5));
        standardWarehouse.addItem(new StandardBox("BOX-2", "Обычная коробка 2", 8.0));

        fragileWarehouse.addItem(new FragileItem("FRAG-1", "Ваза", 3.2, true));

        // Попытка положить FragileItem в Warehouse<StandardBox>
        // Дженерики в Java инвариантны: Warehouse<FragileItem> не является подтипом Warehouse<StandardBox>.
        // Компилятор выдаст ошибку "incompatible types", так как метод addItem ожидает тип StandardBox,
        // а не FragileItem, обеспечивая строгую типобезопасность на этапе компиляции.
        // standardWarehouse.addItem(new FragileItem("ERR-1", "Ошибка", 1.0, true)); // Ошибка компиляции!

        Report<Warehouse<StandardBox>> standardReport = new Report<>(standardWarehouse);
        Report<Warehouse<FragileItem>> fragileReport = new Report<>(fragileWarehouse);

        System.out.println("Отчет по стандартному складу:");
        standardReport.printReport();

        System.out.println("\nОтчет по складу хрупких грузов:");
        fragileReport.printReport();
    }
}