package com.example.algorithms.search;

import com.example.algorithms.strategy.SearchStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BinarySearchStrategy implements SearchStrategy {
    @Override
    public <T> Optional<Integer> search(List<? extends Comparable<? super T>> container, T target) {
        int low  = 0;
        int high = container.size() - 1;

        while(low <= high) {
            int mid = low + high >>> 1;
            Comparable<? super T> val = container.get(mid);
            int cmpResult = val.compareTo(target);
            if (cmpResult < 0) {
                low = mid + 1;
            } else if (cmpResult == 0) {
                return Optional.of(mid);
            } else {
                high = mid - 1;
            }
        }
        return Optional.empty();
    }

    @Override
    public <T> Optional<Integer> search(List<T> container, T target, Comparator<? super T> comparator) {
        int low  = 0;
        int high = container.size() - 1;

        while(low <= high) {
            int mid = low + high >>> 1;
            T val = container.get(mid);
            int cmpResult = comparator.compare(val, target);
            if (cmpResult < 0) {
                low = mid + 1;
            } else if (cmpResult == 0) {
                return Optional.of(mid);
            } else {
                high = mid - 1;
            }
        }
        return Optional.empty();
    }
}
