package com.example.inputters;

import com.example.model.*;
import com.example.model.type.*;

import java.util.List;

public class DataRandomInputter {
    private static final List<Car> cars = List.of(
            new Car.CarBuilder("AUDI").setPower(180).setYear(2022).build(),
            new Car.CarBuilder("BMW").setPower(340).setYear(2024).build(),
            new Car.CarBuilder("Mercedes").setPower(160).setYear(2020).build(),
            new Car.CarBuilder("Жигули").setPower(73).setYear(1990).build()
    );
    private static final List<Book> books = List.of(
            new Book.BookBuilder("Мастер и Маргарита").setAuthor("М.Булгаков").setNumberOfPages(528).build(),
            new Book.BookBuilder("Тарас Бульба").setAuthor("Н.Гоголь").setNumberOfPages(352).build(),
            new Book.BookBuilder("Ромео и Джульетта").setAuthor("У.Шекспир").setNumberOfPages(384).build(),
            new Book.BookBuilder("Война и Мир").setAuthor("Л.Толстой").setNumberOfPages(5202).build()
    );
    private static final List<RootVegetable> rootVegetables = List.of(
            new RootVegetable.RootVegetableBuilder(rootVegetableType.ASTER).setWeight(628.8).setColor("Красный").build(),
            new RootVegetable.RootVegetableBuilder(rootVegetableType.CABBAGE).setWeight(979.3).setColor("Желтый").build(),
            new RootVegetable.RootVegetableBuilder(rootVegetableType.GOOSEFOOT).setWeight(221.1).setColor("Зеленый").build(),
            new RootVegetable.RootVegetableBuilder(rootVegetableType.UMBRELLA).setWeight(399.4).setColor("Серый").build()
    );

    private static List<Car> getCars() {
        return cars;
    }

    private static List<RootVegetable> getRootVegetables() {
        return rootVegetables;
    }

    private static List<Book> getBooks() {
        return books;
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * 4);
    }

    public static Book getRandomBook() {
        return getBooks().get(getRandomNumber());
    }

    public static Car getRandomCar() {
        return getCars().get(getRandomNumber());
    }

    public static RootVegetable getRandomRootVegetable() {
        return getRootVegetables().get(getRandomNumber());
    }


}
