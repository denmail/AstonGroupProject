import java.util.Scanner;

public class DataInputter {
    public static Book inputBookData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название книги: ");
        String name = scanner.nextLine();
        System.out.println("Введите автора книги: ");
        String author = scanner.nextLine();
        System.out.println("Введите количество страниц книги: ");
        int numberOfPages = scanner.nextInt();
        return new Book.BookBuilder(name).setAuthor(author).setNumberOfPages(numberOfPages).build();
    }

    public static Car inputCarData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите модель автомобиля: ");
        String model = scanner.nextLine();
        System.out.println("Введите мощность двигателя: ");
        int horsePower = scanner.nextInt();
        System.out.println("Введите год производства: ");
        int yearProduction = scanner.nextInt();
        return new Car.CarBuilder(model).setPower(horsePower).setYear(yearProduction).build();
    }

    public static RootVegetable inputRootVegetableData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип корнеплода (ASTER, CABBAGE, GOOSEFOOT, UMBRELLA): ");
        String inputType = scanner.nextLine();
        rootVegetableType type = RootVegetable.getType(inputType);

        System.out.println("Введите вес корнеплода: ");
        double weight = scanner.nextDouble();
        System.out.println("Введите цвет корнеплода: ");
        String color = scanner.nextLine();
        return new RootVegetable.RootVegetableBuilder(type).setWeight(weight).setColor(color).build();
    }
}
