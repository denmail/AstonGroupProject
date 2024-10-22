package com.example.algorithms.strategy;

import java.util.Comparator;
import java.util.List;

public interface SortStrategy {
    <T extends Comparable<? super T>> void sort(List<T> container);
    <T> void sort(List<T> container, Comparator<? super T> comparator);
}