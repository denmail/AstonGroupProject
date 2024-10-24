import static inputters.DataInputter.*;
import static inputters.DataRandomInputter.*;

import managers.*;

import java.io.File;
import java.util.Scanner;

class Application {
    MemoryManager memoryManager;
    FileManager fileManager;

    Application() {
        memoryManager = new MemoryManager();
        fileManager = new FileManager(new File("data.txt"), memoryManager);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            printMenu();
            choice = scanner.nextInt();
            if (choice == 8)
                break;
            switch (choice) {
                case 1:
                    System.out.println("Введите тип данных (1. Book, 2. Car, 3. RootVegetable)");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            memoryManager.add(inputBookData());
                            break;
                        case 2:
                            memoryManager.add(inputCarData());
                            break;
                        case 3:
                            memoryManager.add(inputRootVegetableData());
                            break;
                        default:
                            System.out.println("Неверный тип данных.");
                    }
                    break;
                case 2:
                    System.out.println("Введите тип данных (1. Book, 2. Car, 3. RootVegetable)");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            memoryManager.add(getRandomBook());
                            break;
                        case 2:
                            memoryManager.add(getRandomCar());
                            break;
                        case 3:
                            memoryManager.add(getRandomRootVegetable());
                            break;
                        default:
                            System.out.println("Неверный тип данных.");
                    }
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
            }
        }
    }

    static void printMenu() {
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

    public void printData() {
        if (!memoryManager.getBookList().isEmpty())
            System.out.println(memoryManager.getBookList());
        if (!memoryManager.getCarList().isEmpty())
            System.out.println(memoryManager.getCarList());
        if (!memoryManager.getRootVegetableList().isEmpty())
            System.out.println(memoryManager.getRootVegetableList());
    }
}