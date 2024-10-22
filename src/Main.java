import Inputters.DataInputter;
import Inputters.DataRandomInputter;
import managers.FileManager;
import managers.MemoryManager;

import java.io.File;
import java.util.Scanner;

public class Main {

    static void printMenu() {
        System.out.println("""
                Выберите действие:
                1. Ввод данных вручную
                2. Ввод данных случайным образом
                3. Сохранить данные
                4. Загрузить из файла
                5. Указать длину массива данных
                6. Найти указанный элемент
                7. Выйти из приложения""");
    }

    public static void main(String[] args) {
        MemoryManager memoryManager = new MemoryManager();
        FileManager fileManager = new FileManager(new File("data.txt"), memoryManager);
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            printMenu();
            choice = scanner.nextInt();
            if (choice == 7)
                break;
            switch (choice) {
                case 1:
                    System.out.println("Введите тип данных (1. model.Book, 2. model.Car, 3. model.RootVegetable)");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            memoryManager.addBook(DataInputter.inputBookData());
                            break;
                        case 2:
                            memoryManager.addCar(DataInputter.inputCarData());
                            break;
                        case 3:
                            memoryManager.addRootVegetable(DataInputter.inputRootVegetableData());
                            break;
                        default:
                            System.out.println("Неверный тип данных.");
                    }
                    break;
                case 2:
                    System.out.println("Введите тип данных (1. model.Book, 2. model.Car, 3. model.RootVegetable");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            memoryManager.addBook(DataRandomInputter.getRandomBook());
                            break;
                        case 2:
                            memoryManager.addCar(DataRandomInputter.getRandomCar());
                            break;
                        case 3:
                            memoryManager.addRootVegetable(DataRandomInputter.getRandomRootVegetable());
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
                    System.out.println("Выбран 5 пункт");
                    break;
                case 6:
                    System.out.println("Выбран 6 пункт");
                    break;
            }
        }
    }
}

