package net.lilifei.algorithm.v1.model;

public class DataObject implements Comparable<DataObject> {
    private int value;

    public DataObject(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(DataObject o) {
        return this.getValue() - o.getValue();
    }

    public boolean equals(DataObject o) {
        return this.getValue() == o.getValue();
    }

    public static DataObject[] turn(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int lenA = A.length;
        DataObject[] res = new DataObject[lenA];
        for (int i = 0; i < lenA; i++) {
            res[i] = new DataObject(A[i]);
        }
        return res;
    }
}
