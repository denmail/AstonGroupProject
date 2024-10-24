package inputters;

import static validate.Validator.*;
import static converter.Parser.*;

import model.*;
import model.type.rootVegetableType;

import java.util.Scanner;

public class DataInputter {

    public static Book inputBookData() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название книги: ");
            String name = scanner.nextLine();
            System.out.println("Введите автора книги: ");
            String author = scanner.nextLine();
            System.out.println("Введите количество страниц книги: ");
            int numberOfPages = scanner.nextInt();

            if (validateBookData(name, author, numberOfPages))
                return new Book.BookBuilder(name).setAuthor(author).setNumberOfPages(numberOfPages).build();
        }
    }

    public static Car inputCarData() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите модель автомобиля: ");
            String model = scanner.nextLine();
            System.out.println("Введите мощность автомобиля: ");
            int power = scanner.nextInt();
            System.out.println("Введите год выпуска автомобиля: ");
            int year = scanner.nextInt();

            if (validateCarData(model, power, year))
                return new Car.CarBuilder(model).setPower(power).setYear(year).build();
        }
    }

    public static RootVegetable inputRootVegetableData() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите тип корнеплода (ASTER, CABBAGE, GOOSEFOOT, UMBRELLA): ");
            String inputType = scanner.nextLine();
            rootVegetableType type = parseRootVegetableType(inputType);
            System.out.println("Введите вес (ASTER, CABBAGE, GOOSEFOOT, UMBRELLA): ");
            double weight = scanner.nextDouble();
            System.out.println("Введите цвет корнеплода: ");
            String color = scanner.nextLine();

            if (validateRootVegetableData(type, weight, color))
                return new RootVegetable.RootVegetableBuilder(type).setWeight(weight).setColor(color).build();
        }
    }
}
