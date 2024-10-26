package Interface;

public class Main {
    public static void main(String[] args) {
        // Создание заглушки
        SortManager sortManager = new SortManager();
        SearchManager searchManager = new SearchManager();

        // Передача заглушки в интерфейс
        UserInterface ui = new UserInterface(sortManager, searchManager);

        // Запуск интерфейса
        ui.start();
    }
}