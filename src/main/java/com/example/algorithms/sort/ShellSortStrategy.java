package com.example.algorithms.sort;

import com.example.algorithms.strategy.SortStrategy;

import java.util.Comparator;
import java.util.List;

public class ShellSortStrategy implements SortStrategy {
    @Override
    public <T extends Comparable<? super T>> void sort(List<T> container) {
        int size = container.size();
        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i++) {
                T temp = container.get(i);
                int j;
                for (j = i; j >= gap && container.get(j - gap).compareTo(temp) > 0; j -= gap) {
                    container.set(j, container.get(j - gap));
                }
                container.set(j, temp);
            }
        }
    }

    @Override
    public <T> void sort(List<T> container, Comparator<? super T> comparator) {
        int size = container.size();
        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i++) {
                T temp = container.get(i);
                int j;
                for (j = i; j >= gap && comparator.compare(container.get(j - gap), temp) > 0; j -= gap) {
                    container.set(j, container.get(j - gap));
                }
                container.set(j, temp);
            }
        }
    }
}
