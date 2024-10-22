package com.example.algorithms;

import com.example.algorithms.strategy.SortStrategy;

import java.util.Comparator;
import java.util.List;

public class SortExecutor {
    private SortStrategy sortStrategy;

    public SortExecutor(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public <T extends Comparable<? super T>> void sort(List<T> container) {
        sortStrategy.sort(container);
    }

    public <T> void sort(List<T> container, Comparator<? super T> comparator) {
        sortStrategy.sort(container, comparator);
    }
}
