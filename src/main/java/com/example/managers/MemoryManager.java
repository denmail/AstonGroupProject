package com.example.managers;

import com.example.model.*;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {
    private final List<Book> bookList;
    private final List<Car> carList;
    private final List<RootVegetable> rootVegetableList;
    private int bookListLength;
    private int carListLength;
    private int rootListLength;

    public MemoryManager() {
        bookList = new ArrayList<>();
        carList = new ArrayList<>();
        rootVegetableList = new ArrayList<>();
    }

    public void add(Book book) {
        if (!bookList.contains(book)) {
            bookList.add(book);
            System.out.println("Объект " + book + " был успешно добавлен в хранилище");
        }
    }

    public void add(Car car) {
        if (!carList.contains(car)) {
            carList.add(car);
            System.out.println("Объект " + car + " был успешно добавлен в хранилище");
        }
    }

    public void add(RootVegetable rootVegetable) {
        if (!rootVegetableList.contains(rootVegetable)) {
            rootVegetableList.add(rootVegetable);
            System.out.println("Объект " + rootVegetable + " был успешно добавлен в хранилище");
        }
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

    public void setBookListLength(int bookListLength) {
        this.bookListLength = bookListLength;
    }

    public void setCarListLength(int carListLength) {
        this.carListLength = carListLength;
    }

    public void setRootListLength(int rootListLength) {
        this.rootListLength = rootListLength;
    }
}
