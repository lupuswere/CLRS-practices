package net.lilifei.basic;

/**
 * Created by Lifei on 15/5/5.
 */
public class Sort {
    /**
     * 2.1 : Insert Sort
     *
     * @param A : the array of Integer that is to be sorted
     */
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

    /**
     * 2.1-2 : Insert Sort (Descending Order)
     *
     * @param A : the array of Integer that is to be sorted
     */
    public static void insertSortDescending(int[] A) {
        if (A == null || A.length < 2) {
            return;
        }
        for (int j = 0; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] < key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
    }

    /**
     * 2.3.1 : Merge Sort
     *
     * @param A : the array of Integer that is to be sorted
     */
    public static void mergeSort(int[] A) {
        mergeSort(A, 0, A.length - 1);
    }

    /**
     * The private function wrapped up by Merge Sort
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : the start index of the array
     * @param r : the end index of the array
     */
    private static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    /**
     * The merge process function
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : the start index of the array
     * @param q : the divide index of the array
     * @param r : the end index of the array
     */
    private static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    /**
     * 2.3-2 Merge Sort Without Using Sentinels
     *
     * @param A : the array of Integer that is to be sorted
     */
    public static void mergeSortWithoutSentinels(int[] A) {
        mergeSortWithoutSentinels(A, 0, A.length - 1);
    }

    /**
     * The private function wrapped up by Merge Sort Without Using Sentinels
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : the start index of the array
     * @param r : the end index of the array
     */
    private static void mergeSortWithoutSentinels(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSortWithoutSentinels(A, p, q);
            mergeSortWithoutSentinels(A, q + 1, r);
            mergeWithoutSentinels(A, p, q, r);
        }
    }

    /**
     * The merge process function without using sentinels
     *
     * @param A : the array of Integer that is to be sorted
     * @param p : the start index of the array
     * @param q : the divide index of the array
     * @param r : the end index of the array
     */
    private static void mergeWithoutSentinels(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (i >= n1) {
                while (j < n2) {
                    A[k] = R[j];
                    j++;
                    k++;
                }
                break;
            } else if (j >= n2) {
                while (i < n1) {
                    A[k] = L[i];
                    i++;
                    k++;
                }
                break;
            }
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }
}
