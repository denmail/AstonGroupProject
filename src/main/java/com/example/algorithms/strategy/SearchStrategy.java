package com.example.algorithms.strategy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface SearchStrategy {
    <T> Optional<Integer> search(final List<? extends Comparable<? super T>> container, T target);
    <T> Optional<Integer> search(final List<T> container, T target, Comparator<? super T> comparator);
}
