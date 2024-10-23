package managers;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {
    private final List<Book> bookList;
    private final List<Car> carList;
    private final List<RootVegetable> rootVegetableList;

    public MemoryManager() {
        bookList = new ArrayList<>();
        carList = new ArrayList<>();
        rootVegetableList = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void addRootVegetable(RootVegetable rootVegetable) {
        rootVegetableList.add(rootVegetable);
    }


    public List<Book> getBookList() {
        return bookList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<RootVegetable> getRootVegetableList() {
        return rootVegetableList;
    }
}
