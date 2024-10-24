package app;

import static inputters.DataInputter.*;
import static inputters.DataRandomInputter.*;

import managers.*;

import java.io.File;
import java.util.Scanner;

public class Application {
    private final MemoryManager memoryManager;
    private final FileManager fileManager;
    private final Scanner scanner;

    public Application() {
        memoryManager = new MemoryManager();
        fileManager = new FileManager(new File("data.txt"), memoryManager);
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;

        while (true) {
            printMenu();
            choice = scanner.nextInt();
            if (choice == 8) break;
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
                    printData();
                    break;
                case 6:
                    System.out.println("Выбран 6 пункт");
                    break;
                case 7:
                    System.out.println("Выбран 7 пункт");
                    break;
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

    private void printMenu() {
        System.out.println("""
                Выберите действие:
                1. Ввод данных вручную
                2. Ввод данных случайным образом
                3. Сохранить данные
                4. Загрузить из файла
                5. Вывести данные на экран
                6. Указать длину массива данных
                7. Найти указанный элемент
                8. Выйти из приложения""");
    }

    private void printData() {
        if (!memoryManager.getBookList().isEmpty()) System.out.println(memoryManager.getBookList());
        if (!memoryManager.getCarList().isEmpty()) System.out.println(memoryManager.getCarList());
        if (!memoryManager.getRootVegetableList().isEmpty()) System.out.println(memoryManager.getRootVegetableList());
    }
}