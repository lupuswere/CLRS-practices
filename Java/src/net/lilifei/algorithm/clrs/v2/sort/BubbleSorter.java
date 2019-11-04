package net.lilifei.algorithm.clrs.v2.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BubbleSorter implements Sorter {

    @Override
    public <T> List<T> sort(final List<T> elements,
                            final Comparator<T> comparator) {
        if (elements == null) return null;
        final List<T> result = new ArrayList<>(elements); // in-place
        for(int i = elements.size() - 1; i >= 0; i--) {
            for(int j = 0; j < i; j++) {
                if (comparator.compare(result.get(j), result.get(j + 1)) > 0) {
                    final T temp = result.get(j);
                    result.set(j, result.get(j + 1));
                    result.set(j + 1, temp);
                }
            }
        }
        return result;
    }
}
