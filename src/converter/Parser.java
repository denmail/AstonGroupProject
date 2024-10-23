package converter;

import model.*;
import model.type.rootVegetableType;

public class Parser {

    public static String parseDataToString(Book book) {
        return "BOOK," + book.getName() + "," + book.getAuthor() + "," + book.getNumberOfPages();
    }

    public static String parseDataToString(Car car) {
        return "CAR," + car.getModel() + "," + car.getPower() + "," + car.getYear();
    }

    public static String parseDataToString(RootVegetable rootVegetable) {
        return "ROOT_VEGETABLE," + rootVegetable.getType() + "," + rootVegetable.getWeight() + "," + rootVegetable.getColor();
    }

    public static Book parseStringToBookData(String csvData) {
        String[] data = csvData.split(",");
        return new Book.BookBuilder(data[1]).setAuthor(data[2]).setNumberOfPages(Integer.parseInt(data[3])).build();
    }

    public static Car parseStringToCarData(String csvData) {
        String[] data = csvData.split(",");
        return new Car.CarBuilder(data[1]).setPower(Integer.parseInt(data[2])).setPower(Integer.parseInt(data[3])).build();
    }

    public static RootVegetable parseStringToRootVegetableData(String csvData) {
        String[] data = csvData.split(",");
        return new RootVegetable.RootVegetableBuilder(RootVegetable.getType(data[1]))
                .setWeight(Double.parseDouble(data[2])).setColor(data[3]).build();
    }

    public static String getBookName(String bookData) {
        String[] data = bookData.split(" ");
        return data[0];
    }

    public static String getBookAuthor(String bookData) {
        String[] data = bookData.split(" ");
        return data[1];
    }

    public static int getBookNumberOfPages(String bookData) {
        String[] data = bookData.split(" ");
        return Integer.parseInt(data[2]);
    }

    public static String getCarModel(String carData) {
        String[] data = carData.split(" ");
        return data[0];
    }

    public static int getCarPower(String carData) {
        String[] data = carData.split(" ");
        return Integer.parseInt(data[1]);
    }

    public static int getCarYear(String carData) {
        String[] data = carData.split(" ");
        return Integer.parseInt(data[2]);
    }

    public static rootVegetableType getRootVegetableType(String rootVegetableData) {
        String[] data = rootVegetableData.split(" ");
        return switch (data[0].toUpperCase()) {
            case "ASTER" -> rootVegetableType.ASTER;
            case "CABBAGE" -> rootVegetableType.CABBAGE;
            case "GOOSEFOOT" -> rootVegetableType.GOOSEFOOT;
            case "UMBRELLA" -> rootVegetableType.UMBRELLA;
            default -> null;
        };
    }

    public static double getRootVegetableWeight(String rootVegetableData) {
        String[] data = rootVegetableData.split(" ");
        return Double.parseDouble(data[1]);
    }

    public static String getRootVegetableColor(String rootVegetableData) {
        String[] data = rootVegetableData.split(" ");
        return data[2];
    }
}
