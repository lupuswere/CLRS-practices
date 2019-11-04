package net.lilifei.algorithm.clrs.v2.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSorter implements Sorter {

    @Override
    public <T> List<T> sort(final List<T> elements,
                            final Comparator<T> comparator) {
        if (elements == null) return null;
        final List<T> result = new ArrayList<>(elements);

        return result;
    }
}
