package net.lilifei.algorithm.clrs.v2.sort;

import java.util.Comparator;
import java.util.List;

public interface Sorter<T> {

    List<T> sort(final List<T> elements,
                 final Comparator<T> comparator);
}
