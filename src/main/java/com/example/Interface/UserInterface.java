package Interface;
import java.util.Scanner;

public class UserInterface {

    private final sortManager  ; //Сортировка (нужно передать класс по ней)
    private final SearchManager searchManager; //Бинарный поиск

//    public UserInterface(ShellSort shellSort, BinarySearch binarySearch) {
//        this.SortManager = sortManager;
//        this.SearchManager = searchManager;
//    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Выбрать тип данных для сортировки");
            System.out.println("2. Задать длину массива");
            System.out.println("3. Выбрать метод заполнения данных (ручной ввод, файл или рандом)");
            System.out.println("4. Выполнить сортировку");
            System.out.println("5. Найти элемент с помощью бинарного поиска");
            System.out.println("6. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    chooseDataType(scanner);
                    break;
                case 2:
                    setArrayLength(scanner);
                    break;
                case 3:
                    chooseDataFillingMethod(scanner);
                    break;
                case 4:
                    performSorting();
                    break;
                case 5:
                    performBinarySearch(scanner);
                    break;
                case 6:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void chooseDataType(Scanner scanner) {
        System.out.println("Выберите тип данных: ");
        System.out.println("1. Автомобиль");
        System.out.println("2. Книга");
        System.out.println("3. Корнеплод");

        int type = scanner.nextInt();
        switch (type) {
            case 1:
                sortManager.setDataType(Car.class);  // Передача типа данных менеджеру сортировки
                break;
            case 2:
                sortManager.setDataType(Book.class);  // Устанавливаем тип Книга
                break;
            case 3:
                sortManager.setDataType(RootVegetable.class);  // Устанавливаем тип Корнеплод
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }

    private void setArrayLength(Scanner scanner) {
        System.out.println("Введите длину массива: ");
        int length = scanner.nextInt();
        sortManager.setArrayLength(length);
    }

    private void chooseDataFillingMethod(Scanner scanner) {
        System.out.println("Выберите метод заполнения данных: ");
        System.out.println("1. Ручной ввод");
        System.out.println("2. Из файла");
        System.out.println("3. Случайные значения");

        int method = scanner.nextInt();
        switch (method) {
            case 1:
                sortManager.fillDataManually();
                break;
            case 2:
                sortManager.fillDataFromFile();
                break;
            case 3:
                sortManager.fillDataRandomly();
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }

    private void performSorting() {
        sortManager.sortData();
        System.out.println("Массив отсортирован.");
    }

    private void performBinarySearch(Scanner scanner) {
        System.out.println("Введите значение для поиска: ");
        String value = scanner.next();
        int index = searchManager.BinarySearch(value);
        if (index != -1) {
            System.out.println("Элемент найден на позиции: " + index);
        } else {
            System.out.println("Элемент не найден.");
        }
    }
}
