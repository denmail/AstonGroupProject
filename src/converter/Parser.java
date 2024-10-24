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
        return new Car.CarBuilder(data[1]).setPower(Integer.parseInt(data[2])).setYear(Integer.parseInt(data[3])).build();
    }

    public static RootVegetable parseStringToRootVegetableData(String csvData) {
        String[] data = csvData.split(",");
        return new RootVegetable.RootVegetableBuilder(RootVegetable.getType(data[1]))
                .setWeight(Double.parseDouble(data[2])).setColor(data[3]).build();
    }

    public static rootVegetableType parseRootVegetableType(String rootVegetableData) {
        String[] data = rootVegetableData.split(" ");
        return switch (data[0].toUpperCase()) {
            case "ASTER" -> rootVegetableType.ASTER;
            case "CABBAGE" -> rootVegetableType.CABBAGE;
            case "GOOSEFOOT" -> rootVegetableType.GOOSEFOOT;
            case "UMBRELLA" -> rootVegetableType.UMBRELLA;
            default -> null;
        };
    }
}
