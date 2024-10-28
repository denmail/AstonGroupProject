package com.example.validate;

import com.example.model.type.rootVegetableType;

public class Validator {

    public static boolean validateBookData(String name, String author, int numberOfPages) {
        if (name.isEmpty() || name.isBlank()) {
            System.out.println("Вы не указали название книги");
            return false;
        }
        if (author.isEmpty() || author.isBlank()) {
            System.out.println("Вы не указали автора книги");
            return false;
        }
        if (numberOfPages <= 0) {
            System.out.println("Кол-во страниц должно быть положительным числом");
            return false;
        }
        return true;
    }

    public static boolean validateCarData(String model, int power, int year) {
        if (model.isEmpty() || model.isBlank()) {
            System.out.println("Вы не указали модель автомобиля");
            return false;
        }
        if (power <= 0) {
            System.out.println("Мощность двигателя не может быть равно 0 и меньше");
            return false;
        }
        if (year <= 1885) {
            System.out.println("Первый в мире автомобиль был изобретён в 1885 году");
            return false;
        }
        if (year > 2024) {
            System.out.println("Сейчас 2024-й год, будущее еще не наступило");
            return false;
        }
        return true;
    }

    public static boolean validateRootVegetableData(rootVegetableType type, double weight, String color) {
        if (weight <= 0) {
            System.out.println("Вес не может быть 0 гр. и менее");
            return false;
        }
        if (color.isEmpty() || color.isBlank()) {
            System.out.println("Вы не указали цвет корнеплода");
            return false;
        }
        return true;
    }
}
