import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static void printMenu() {
        System.out.println("""
                Выберите действие:
                1. Ввод данных вручную
                2. Ввод данных случайным образом
                3. Сохранить данные
                4. Загрузить из файла
                5. Указать длину массива данныхпс
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
                    System.out.println("Введите тип данных (1. Book, 2. Car, 3. RootVegetable");
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
                    System.out.println("Введите тип данных (1. Book, 2. Car, 3. RootVegetable");
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

        System.out.println(memoryManager.getBookList());
        System.out.println(memoryManager.getCarList());
        System.out.println(memoryManager.getRootVegetableList());

    }
}

/*
Общая часть задания: написать приложение, которое будет реализовывать алгоритм сортировки по переданным классам.
Приложение должно быть выложено на гитхаб/гитлаб, количество веток с кодом должно соответствовать количеству
участников (минимум), все ветки в итоге должны быть смерджены в master/main ветку. Вся архитектура и код стайл
должны соответствовать конвенциям языка Java.Программа должна выполняться в цикле. Выход из цикла возможен только
путем соответствующего выбора пользователя. Пользователь должен иметь возможность выбирать варианты заполнения
исходного массива данных (из файла, рандом, вручную) и его длину. Также у пользователя должна быть возможность
найти какой-либо элемент отсортированной коллекции при помощи алгоритма бинарного поиска, которые также необходимо
реализовать. Сотрировки и бинарный поиск должны быть реализованы с использованием дженериков и быть универсальными
под любые классы программы. В программе должен использовать паттерн стратегия. Сортировать необходимо кастомные
классы - класс должен иметь реализованный паттерн Builder. Для вводимых данных (в тч из файла) должна производится
валидация данных. Доп. задание: дополнительно к основным сортировкам реализовать эти же алгоритмы сортировки таким
        образом, что классы будут сортироваться по какому-либо числовому полю таким образом, что классы с четными
значениями будут сортироваться в натуральном порядке, а с нечетными оставаться на своих местах.
Доп. доп. задание: Необходимо реализовать функционал для записи отсортированных коллекций/найденных значений в файл
в режиме добавления данных

- Классы: Автомобиль (Мощность, Модель, Год производства), Книга (Автора, Название, Количество страниц), Корнеплод
        (Тип, Вес, Цвет) Сортировка - ShellSort*/
