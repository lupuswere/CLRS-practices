package net.lilifei.algorithm.dataStructure;

/**
 * Created by Lifei on 15/5/10.
 */
public class DnaryHeap {
    /**
     * 6-2 a) : the index of the parent node in d-nary heap
     *
     * @param i : the child node
     * @param d : the number of branches
     * @return : the index of the parent node in d-nary heap
     */
    public static int parent(int i, int d) {
        int level = 1;
        if (i == 0) {
            return -1;
        }
        int start = 0, end = 0;
        int prevStart = 0;
        do {
            level++;
            prevStart = start;
            start = (int) (1 - Math.pow((double) d, (double) (level - 1))) / (1 - d);
            end = (int) (d - Math.pow((double) d, (double) level)) / (1 - d);
        } while (!(start <= i && i <= end));
        return prevStart + (i - start) / d;
    }

    /**
     * 6-2 a) : the index of the nth child node in d-nary heap
     *
     * @param i : the parent node
     * @param n : the nth
     * @param d : the number of branches
     * @return : the index of the nth child node in d-nary heap
     */
    public static int nthChild(int i, int n, int d) {
        if (n > d) {
            return -1;
        }
        int start = 0, end = 0;
        int level = 1;
        do {
            start = (int) (1 - Math.pow((double) d, (double) (level - 1))) / (1 - d);
            end = (int) (d - Math.pow((double) d, (double) level)) / (1 - d);
            level++;
        } while (!(start <= i && i <= end));
        return end + d * (i - start) + n;
    }

    /**
     * Helper function to check whether it is d-nary max heap
     *
     * @param A        : the heap
     * @param d        : d
     * @param heapSize : the size of the heap
     * @return : true : max heap
     */
    public static boolean isMaxDnaryHeap(int[] A, int d, int heapSize) {
        if (A == null || A.length < 2) {
            return true;
        }
        int lenA = A.length;
        for (int i = 0; i < lenA; i++) {
            for (int j = 1; j <= d; j++) {
                int child = nthChild(i, j, d);
                if (child >= heapSize) {
                    return true;
                } else if (A[child] > A[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Max D-nary Heapify
     *
     * @param A        : the heap
     * @param d        : d
     * @param i        : i
     * @param heapSize : the size of the heap
     */
    public static void maxHeapify(int[] A, int d, int i, int heapSize) {
        if (A == null || A.length < 2 || d >= A.length) {
            return;
        }
        int largest = i;
        for (int n = 1; n <= d; n++) {
            int child = nthChild(i, n, d);
            if (child < heapSize && A[child] > A[largest]) {
                largest = child;
            }
        }
        if (largest != i) {
            int tmp = A[largest];
            A[largest] = A[i];
            A[i] = tmp;
            maxHeapify(A, d, largest, heapSize);
        }
    }

    /**
     * Build Max Heap
     *
     * @param A : the heap
     * @param d : d
     */
    public static void buildMaxHeap(int[] A, int d) {
        if (A == null || A.length < 2) {
            return;
        }
        int lenA = A.length;
        int heapSize = lenA;
        for (int i = heapSize - 1; i >= 0; i--) {
            maxHeapify(A, d, i, heapSize);
        }
    }

    /**
     * 6-2 c) : EXTRACT-MAX, Delete and return the maximum Integer in the d-nary heap
     *
     * @param A : the d-nary heap
     * @param d : d
     * @return : the max element
     */
    public static int extractMax(int[] A, int d, int heapSize) throws Exception {
        if (heapSize < 1) {
            throw new Exception("Heap underflow");
        }
        int max = A[0];
        A[0] = A[heapSize - 1];
        DnaryHeap.maxHeapify(A, d, 0, --heapSize);
        return max;
    }

    /**
     * 6-2 e) : INCREASE-KEY(A, i, k)
     *
     * @param A   : the d-nary heap
     * @param d   : d
     * @param i   : index
     * @param key : the new key
     * @throws Exception
     */
    public static void heapIncreaseKey(int[] A, int d, int i, int key) throws Exception {
        if (key < A[i]) {
            throw new Exception("New key is smaller than the current key");
        }
        A[i] = key;
        while ((i > 0) && (A[parent(i, d)] < A[i])) {
            int tmp = A[i];
            A[i] = A[parent(i, d)];
            A[parent(i, d)] = tmp;
            i = parent(i, d);
        }
    }

    /**
     * 6-2 d) : INSERT
     *
     * @param A        : the d-nary heap
     * @param d        : d
     * @param key      : the new key
     * @param heapSize : the size of the heap
     * @throws Exception
     */
    public static void maxHeapInsert(int[] A, int d, int key, int heapSize) throws Exception {
        heapSize++;
        A[heapSize - 1] = Integer.MIN_VALUE;
        heapIncreaseKey(A, d, heapSize - 1, key);
    }
}
