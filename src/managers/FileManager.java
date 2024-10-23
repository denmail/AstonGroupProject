package managers;

import static converter.Parser.*;

import exceptions.*;
import model.*;
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
                fileWriter.write(parseDataToString(book) + "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new FileWriteException("Ошибка записи в файл");
        }

    }

    private void saveCarData() throws FileWriteException {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            for (Car car : carList)
                fileWriter.write(parseDataToString(car) + "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new FileWriteException("Ошибка записи в файл");
        }
    }

    private void saveRootVegetableData() throws FileWriteException {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            for (RootVegetable rootVegetable : rootVegetableList)
                fileWriter.write(parseDataToString(rootVegetable) + "\n");
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
                    case typeClass.BOOK -> memoryManager.addBook(parseStringToBookData(data));
                    case typeClass.CAR -> memoryManager.addCar(parseStringToCarData(data));
                    case typeClass.ROOT_VEGETABLE ->
                            memoryManager.addRootVegetable(parseStringToRootVegetableData(data));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new FileReadException("Ошибка чтения файла.");
        }
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
