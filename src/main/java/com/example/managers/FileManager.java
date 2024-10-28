package com.example.managers;

import static com.example.converter.Parser.*;

import com.example.model.*;
import com.example.model.type.typeClass;

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

    private void saveBookData() throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (Book book : bookList)
            fileWriter.write(parseDataToString(book) + "\n");
        fileWriter.close();
    }

    private void saveCarData() throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        for (Car car : carList)
            fileWriter.write(parseDataToString(car) + "\n");
        fileWriter.close();
    }

    private void saveRootVegetableData() throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        for (RootVegetable rootVegetable : rootVegetableList)
            fileWriter.write(parseDataToString(rootVegetable) + "\n");
        fileWriter.close();
    }

    public void save() {
        try {
            if (!bookList.isEmpty())
                saveBookData();
            if (!carList.isEmpty())
                saveCarData();
            if (!rootVegetableList.isEmpty())
                saveRootVegetableData();
            if (bookList.isEmpty() & carList.isEmpty() & rootVegetableList.isEmpty())
                System.out.println("Введите данные для сохранения");
            else
                System.out.println("Сохранение данных");

        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
    }

    public void load() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            while (bufferedReader.ready()) {
                String data = bufferedReader.readLine();
                switch (getTypeData(data)) {
                    case BOOK -> memoryManager.add(parseStringToBookData(data));
                    case CAR -> memoryManager.add(parseStringToCarData(data));
                    case ROOT_VEGETABLE -> memoryManager.add(parseStringToRootVegetableData(data));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка! Файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка чтения данных из файла!");
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
