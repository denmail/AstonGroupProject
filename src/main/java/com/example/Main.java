package com.example;

import com.example.algorithms.SearchExecutor;
import com.example.algorithms.SortExecutor;
import com.example.algorithms.search.BinarySearchStrategy;
import com.example.algorithms.sort.ShellSortStrategy;
import com.example.algorithms.strategy.SearchStrategy;
import com.example.algorithms.strategy.SortStrategy;
import com.example.Interface.UserInterface;

public class Main {
    public static void main(String[] args) {
        // Создание заглушки
        SortStrategy sortStrategy = new ShellSortStrategy();
        SearchStrategy searchStrategy = new BinarySearchStrategy();

        SortExecutor sortExecutor = new SortExecutor(sortStrategy);
        SearchExecutor searchExecutor = new SearchExecutor(searchStrategy);

        // Передача заглушки в интерфейс
        UserInterface ui = new UserInterface(sortExecutor,searchExecutor);

        // Запуск интерфейса
        ui.start();
    }
}