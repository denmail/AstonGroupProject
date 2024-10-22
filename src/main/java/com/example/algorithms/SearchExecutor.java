package com.example.algorithms;

import com.example.algorithms.strategy.SearchStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SearchExecutor {

    private SearchStrategy searchStrategy;

    public SearchExecutor(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public <T> Optional<Integer> search(final List<? extends Comparable<? super T>> container, T target) {
        return searchStrategy.search(container, target);
    }

    public <T> Optional<Integer> search(final List<T> container, T target, Comparator<? super T> comparator) {
        return searchStrategy.search(container, target, comparator);
    }
}
