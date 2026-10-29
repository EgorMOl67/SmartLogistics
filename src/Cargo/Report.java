package Cargo;

public class Report<T> {
    private T data;

    public Report(T data) {
        this.data = data;
    }

    public void printReport() {
        System.out.println("=== Отчет ===");
        System.out.println("Тип данных: " + data.getClass().getSimpleName());
        System.out.println("Содержимое:");

        // Если отчет содержит склад, выведем его манифест
        if (data instanceof Warehouse) {
            ((Warehouse<?>) data).printManifest();
            System.out.println("Общий вес: " + ((Warehouse<?>) data).getTotalWeight() + " кг");
        } else {
            System.out.println(data);
        }
        System.out.println("==============");
    }

    public T getData() {
        return data;
    }
}