package inputters;

import static validate.Validator.*;

import converter.Parser;
import model.*;
import model.type.rootVegetableType;
import java.util.Scanner;

public class DataInputter {
    private static final Scanner scanner = new Scanner(System.in);

    public static Book inputBookData() {
        while (true) {
            System.out.println("Введите через пробел название книги, автора и кол-во страниц: ");
            String data = scanner.nextLine();

            String name = Parser.getBookName(data);
            String author = Parser.getBookAuthor(data);
            int numberOfPages = Parser.getBookNumberOfPages(data);
            if (validateBookData(name, author, numberOfPages))
                return new Book.BookBuilder(name).setAuthor(author).setNumberOfPages(numberOfPages).build();
        }
    }

    public static Car inputCarData() {
        while (true) {
            System.out.println("Введите через пробел модель, мощность и год выпуска: ");
            String data = scanner.nextLine();

            String model = Parser.getCarModel(data);
            int power = Parser.getCarPower(data);
            int year = Parser.getCarYear(data);

            if (validateCarData(model, power, year))
                return new Car.CarBuilder(model).setPower(power).setYear(year).build();
        }
    }

    public static RootVegetable inputRootVegetableData() {
        while (true) {
            System.out.println("Введите через пробел тип корнеплода (ASTER, CABBAGE, GOOSEFOOT, UMBRELLA), вес и цвет: ");
            String data = scanner.nextLine();

            rootVegetableType type = Parser.getRootVegetableType(data);
            double weight = Parser.getRootVegetableWeight(data);
            String color = Parser.getRootVegetableColor(data);

            if (validateRootVegetableData(type, weight, color))
                return new RootVegetable.RootVegetableBuilder(type).setWeight(weight).setColor(color).build();
        }
    }
}
