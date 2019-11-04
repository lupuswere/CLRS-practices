package net.lilifei.algorithm.clrs.v2.sort;

import java.util.Comparator;
import java.util.List;

public interface Sorter {

    /**
     * Sort.
     * @param elements elements to sort.
     * @param comparator compare data.
     * @param <T> type of the object to sort.
     * @return a list of sorted elements.
     */
    <T> List<T> sort(final List<T> elements,
                     final Comparator<T> comparator);
}
