package net.lilifei.algorithm.clrs.v2.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Insert sort implementation of sorter.
 */
public class InsertionSorter implements Sorter {

    @Override
    public <T> List<T> sort(final List<T> elements,
                            final Comparator<T> comparator) {
        if (elements == null) return null;
        final List<T> result = new ArrayList<>(elements); // in-place
        if (elements.size() < 2) {
            return result;
        }
        for (int i = 1; i < result.size(); i++) {
            final T current = result.get(i);
            int j;
            for (j = i - 1; j >= 0; j--) {
                final T elementToCompare = result.get(j);
                if (comparator.compare(current, elementToCompare) < 0) {
                    result.set(j + 1, elementToCompare);
                } else {
                    break;
                }
            }
            result.set(j + 1, current);
        }
        return result;
    }
}
