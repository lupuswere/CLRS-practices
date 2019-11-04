package net.lilifei.algorithm.clrs.v2.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SelectionSorter implements Sorter {

    @Override
    public <T> List<T> sort(final List<T> elements,
                            final Comparator<T> comparator) {
        if (elements == null) return null;
        final List<T> result = new ArrayList<>(elements);
        for(int i = 0; i < result.size(); i++) {
            T temp = result.get(i);
            int flag = i;
            for(int j = i + 1; j < result.size(); j++) {
                if (comparator.compare(result.get(j), temp) < 0) {
                    temp = result.get(j);
                    flag = j;
                }
            }
            if (flag != i) {
                result.set(flag, result.get(i));
                result.set(i, temp);
            }
        }
        return null;
    }
}
