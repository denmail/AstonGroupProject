package managers;

import Exceptions.FileReadException;
import Exceptions.FileWriteException;
import model.Book;
import model.Car;
import model.RootVegetable;
import model.type.typeClass;

import java.io.*;
import java.util.List;

public class FileManager {
    private final File file;
    private final List<Book> bookList;
    private final List<Car> carList;
    private final List<RootVegetable> rootVegetableList;
    private final MemoryManager memoryManager;

    public FileManager(File file, MemoryManager memoryManager) {
        this.file = file;
        this.memoryManager = memoryManager;
        this.bookList = memoryManager.getBookList();
        this.carList = memoryManager.getCarList();
        this.rootVegetableList = memoryManager.getRootVegetableList();
    }

    private void saveBookData() throws FileWriteException {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (Book book : bookList)
                fileWriter.write(parseDataToCsv(book) + "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new FileWriteException("Ошибка записи в файл");
        }

    }

    private void saveCarData() throws FileWriteException {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            for (Car car : carList)
                fileWriter.write(parseDataToCsv(car) + "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new FileWriteException("Ошибка записи в файл");
        }
    }

    private void saveRootVegetableData() throws FileWriteException {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            for (RootVegetable rootVegetable : rootVegetableList)
                fileWriter.write(parseDataToCsv(rootVegetable) + "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new FileWriteException("Ошибка записи в файл");
        }
    }

    public void save() {
        if (!bookList.isEmpty())
            saveBookData();
        if (!carList.isEmpty())
            saveCarData();
        if (!rootVegetableList.isEmpty())
            saveRootVegetableData();
    }

    public void load() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));
            while (bufferedReader.ready()) {
                String data = bufferedReader.readLine();
                switch (getTypeData(data)) {
                    case typeClass.BOOK -> memoryManager.addBook(parseCsvToBookData(data));
                    case typeClass.CAR -> memoryManager.addCar(parseCsvToCarData(data));
                    case typeClass.ROOT_VEGETABLE -> memoryManager.addRootVegetable(parseCsvToRootVegetableData(data));
                }
            }
        } catch (IOException e) {
            throw  new FileReadException("Ошибка чтения файла.");
        }
    }

    private static String parseDataToCsv(Book book) {
        return "BOOK," + book.getName() + "," + book.getAuthor() + "," + book.getNumberOfPages();
    }

    private static String parseDataToCsv(Car car) {
        return "CAR," + car.getModel() + "," + car.getPower() + "," + car.getYear();
    }

    private static String parseDataToCsv(RootVegetable rootVegetable) {
        return "ROOT_VEGETABLE," + rootVegetable.getType() + "," + rootVegetable.getWeight() + "," + rootVegetable.getColor();
    }

    private static Book parseCsvToBookData(String csvData) {
        String[] data = csvData.split(",");
        return new Book.BookBuilder(data[1]).setAuthor(data[2]).setNumberOfPages(Integer.parseInt(data[3])).build();
    }

    private static Car parseCsvToCarData(String csvData) {
        String[] data = csvData.split(",");
        return new Car.CarBuilder(data[1]).setPower(Integer.parseInt(data[2])).setPower(Integer.parseInt(data[3])).build();
    }

    private static RootVegetable parseCsvToRootVegetableData(String csvData) {
        String[] data = csvData.split(",");
        return new RootVegetable.RootVegetableBuilder(RootVegetable.getType(data[1]))
                .setWeight(Double.parseDouble(data[2])).setColor(data[3]).build();
    }

    private typeClass getTypeData(String csvData) {
        String[] data = csvData.split(",");
        return switch (data[0]) {
            case "BOOK" -> typeClass.BOOK;
            case "CAR" -> typeClass.CAR;
            case "ROOT_VEGETABLE" -> typeClass.ROOT_VEGETABLE;
            default -> typeClass.UNKNOWN;
        };
    }
}
