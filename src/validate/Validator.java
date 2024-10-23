package validate;

import model.type.rootVegetableType;

public class Validator {

    public static boolean validateBookData(String name, String author, int numberOfPages) {
        // ПРОВЕРКА КОРРЕКТНОСТИ ВВОДИМЫХ ДАННЫХ
        return true;
    }

    public static boolean validateCarData(String model, int power, int year) {
        // ПРОВЕРКА КОРРЕКТНОСТИ ВВОДИМЫХ ДАННЫХ
        return true;
    }

    public static boolean validateRootVegetableData(rootVegetableType type, double weight, String color) {
        // ПРОВЕРКА КОРРЕКТНОСТИ ВВОДИМЫХ ДАННЫХ
        return true;
    }

    //CHECK VALIDATION DATA
    /*System.out.println("Вы не указали автора");
    System.out.println("Количество страниц должно быть положительным числом");

    System.out.println("Мощность должна быть положительным числом");
    System.out.println("Первый в мире автомобиль был изобретён в 1885 году");
    System.out.println("Сейчас 2024й год, будущее еще не наступило");

    System.out.println("Вес не может быть 0 гр. и менее");
    System.out.println("Вы не указали цвет корнеплода");*/
}
