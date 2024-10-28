package com.example.Interface;
import com.example.algorithms.SearchExecutor;
import com.example.algorithms.SortExecutor;
import com.example.managers.FileManager;
import com.example.managers.MemoryManager;
import com.example.model.Book;
import com.example.model.Car;
import com.example.model.RootVegetable;

import static com.example.converter.Parser.*;
import static com.example.inputters.DataInputter.*;
import static com.example.inputters.DataRandomInputter.*;

import java.io.File;
import java.util.Optional;
import java.util.Scanner;

public class UserInterface {

    private final SearchExecutor searchExecutor;
    private final SortExecutor sortExecutor;
    private final MemoryManager memoryManager = new MemoryManager();
    private final FileManager fileManager;
    private final Scanner scanner;
    public UserInterface(SortExecutor sortExecutor, SearchExecutor searchExecutor) {
        this.sortExecutor = sortExecutor;
        this.searchExecutor = searchExecutor;
        scanner = new Scanner(System.in);
        fileManager = new FileManager(new File("data.txt"), memoryManager);
    }

    public void start() {


        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Ввод данных вручную");
            System.out.println("2. Ввод данных случайным образом");
            System.out.println("3. Сохранить данные");
            System.out.println("4. Загрузить из файла");
            System.out.println("5. Задать длину массива");
            System.out.println("6. Выполнить сортировку");
            System.out.println("7. Найти элемент с помощью бинарного поиска");
            System.out.println("8. Вывод данных на экран");
            System.out.println("9. Отчистить данные");
            System.out.println("10. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manualInput();
                    break;
                case 2:
                    randomInput();
                    break;
                case 3:
                    fileManager.save();
                    break;
                case 4:
                    fileManager.load();
                    break;
                case 5:
                    setArrayLength(scanner);
                    break;
                case 6:
                    performSorting();
                    break;
                case 7:
                    performBinarySearch(scanner);
                    break;
                case 8:
                    printData();
                    break;
                case 9:
                    cleanData();
                    break;
                case 10:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void inputData(Boolean random) {
        System.out.println("Введите тип данных (1. Book, 2. Car, 3. RootVegetable)");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                if (random) memoryManager.add(getRandomBook());
                else memoryManager.add(inputBookData());
                break;
            case 2:
                if (random) memoryManager.add(getRandomCar());
                else memoryManager.add(inputCarData());
                break;
            case 3:
                if (random) memoryManager.add(getRandomRootVegetable());
                else memoryManager.add(inputRootVegetableData());
                break;
            default:
                System.out.println("Неверный тип данных.");
        }
    }

    private void manualInput() {
        inputData(false);
    }

    private void randomInput() {
        inputData(true);
    }


    private void setArrayLength(Scanner scanner) {
        System.out.println("Выберите класс (1.Car 2.Book 3.RootVegetable):");
        int type = scanner.nextInt();
        System.out.println("Введите длину массива: ");
        int length = scanner.nextInt();
        switch (type) {
            case 1:
                memoryManager.setCarListLength(length);
                break;
            case 2:
                memoryManager.setBookListLength(length);
                break;
            case 3:
                memoryManager.setRootListLength(length);
                break;
            default:
                setArrayLength(scanner);
        }

    }


    private void performSorting() {
        System.out.println("Введите тип данных для сортировки (1.Car 2.Book 3.RootVegetable):");
        int type = scanner.nextInt();
        switch (type) {
            case 1:
                sortExecutor.sort(memoryManager.getCarList());
                System.out.println("Сортировка завершена");
                break;
            case 2:
                sortExecutor.sort(memoryManager.getBookList());
                System.out.println("Сортировка завершена");
                break;
            case 3:
                sortExecutor.sort(memoryManager.getRootVegetableList());
                System.out.println("Сортировка завершена");
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

    private void performBinarySearch(Scanner scanner) {
        System.out.println("Введите тип данных для поика (1.Car 2.Book 3.RootVegetable):");
        int type = scanner.nextInt();
        System.out.println("Введите объект для для поиска \"*,*,*\": ");
        String value = scanner.next();
        Optional<Integer> index;
        switch (type) {
            case 1:
                Car car = parseStringToCarData("CAR," + value);
                index = searchExecutor.search(memoryManager.getCarList(), car);
                break;
            case 2:
                Book book = parseStringToBookData("BOOK," + value);
                index = searchExecutor.search(memoryManager.getBookList(), book);
                break;
            case 3:
                RootVegetable rootVegetable = parseStringToRootVegetableData("ROOT_VEGETABLE," + value);
                index = searchExecutor.search(memoryManager.getRootVegetableList(), rootVegetable);
                break;
            default:
                System.out.println("Неверный выбор!");
                return;
        }
        if (index.isPresent()) {
            System.out.println("Элемент найден на позиции: " + index.get());
        } else {
            System.out.println("Элемент не найден.");
        }
    }

    private void cleanData() {
        System.out.println("Введите тип данных для отчистки (1.Car 2.Book 3.RootVegetable):");
        int type = scanner.nextInt();
        switch (type) {
            case 1:
                memoryManager.getCarList().clear();
                System.out.println("отчистка завершена");
                break;
            case 2:
                memoryManager.getBookList().clear();
                System.out.println("отчистка завершена");
                break;
            case 3:
                memoryManager.getRootVegetableList().clear();
                System.out.println("отчистка завершена");
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

    private void printData() {
        System.out.println("Введите тип данных для вывода (1.Car 2.Book 3.RootVegetable):");
        int type = scanner.nextInt();
        switch (type) {
            case 1:
                System.out.println(memoryManager.getCarList());
                break;
            case 2:
                System.out.println(memoryManager.getBookList());
                break;
            case 3:
                System.out.println(memoryManager.getRootVegetableList());
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }
}
