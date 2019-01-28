package net.lilifei.algorithm.clrs.v2.model;

import java.util.Comparator;

public class DataObjectComparator implements Comparator<DataObject> {

    @Override
    public int compare(final DataObject o1, final DataObject o2) {
        if (o1.getValue() == o2.getValue()) {
            return 0;
        }
        return o1.getValue() < o2.getValue() ? -1 : 1;
    }
}
