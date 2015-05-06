package net.lilifei.basic;

/**
 * Created by Lifei on 15/5/5.
 */
public class Sort {
    public static void insertSort(int[] A) {
        if (A == null || A.length < 2) {
            return;
        }
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
    }
    public static void insertSortDescending(int[] A) {
        if (A == null || A.length < 2) {
            return;
        }
        for(int j = 0; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] < key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
    }
}
