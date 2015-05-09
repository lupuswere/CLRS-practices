package net.lilifei.dataStructure;

import java.util.Comparator;

/**
 * Created by Lifei on 15/5/8.
 */
public class Heap {
    /**
     * 6.1 : PARENT
     *
     * @param i : the index of a node in the heap
     * @return : the index of parent node
     */
    public static int parent(int i) {
        return (i + 1) / 2 - 1;
    }

    /**
     * 6.1 : LEFT
     *
     * @param i : the index of a node in the heap
     * @return : the index of left child node
     */
    public static int left(int i) {
        return (i + 1) * 2 - 1;
    }

    /**
     * 6.1 : RIGHT
     *
     * @param i : the index of a node in the heap
     * @return : the index of right child node
     */
    public static int right(int i) {
        return (i + 1) * 2;
    }

    /**
     * 6.2 : MAX-HEAPIFY
     *
     * @param A        : the heap
     * @param i        : the index of the root of the heap
     * @param heapSize : the size of the heap
     */
    public static <T extends Comparable<? super T>> void maxHeapify(T[] A, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int largest = l;
        if (l <= heapSize && (A[l].compareTo(A[i]) > 0)) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= heapSize && ((A[r].compareTo(A[largest]) > 0))) {
            largest = r;
        }
        if (largest != i) {
            T tmp = A[largest];
            A[largest] = A[i];
            A[i] = tmp;
            maxHeapify(A, i, heapSize);
        }
    }

    /**
     * 6.2 : MAX-HEAPIFY
     *
     * @param A        : the heap
     * @param i        : the index of the root of the heap
     * @param heapSize : the size of the heap
     */
    public static void maxHeapify(int[] A, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int largest = l;
        if (l <= heapSize && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= heapSize && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            int tmp = A[largest];
            A[largest] = A[i];
            A[i] = tmp;
            maxHeapify(A, largest, heapSize);
        }
    }

    /**
     * 6.2-2 : MIN-HEAPIFY
     *
     * @param A        : the heap
     * @param i        : the index of the root of the heap
     * @param heapSize : the size of the heap
     */
    public static <T extends Comparable<? super T>> void minHeapify(T[] A, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int smallest = l;
        if (l <= heapSize && (A[l].compareTo(A[i]) < 0)) {
            smallest = l;
        } else {
            smallest = i;
        }
        if (r <= heapSize && ((A[r].compareTo(A[smallest]) < 0))) {
            smallest = r;
        }
        if (smallest != i) {
            T tmp = A[smallest];
            A[smallest] = A[i];
            A[i] = tmp;
            minHeapify(A, i, heapSize);
        }
    }

    /**
     * 6.2-2 : MIN-HEAPIFY
     *
     * @param A        : the heap
     * @param i        : the index of the root of the heap
     * @param heapSize : the size of the heap
     */
    public static void minHeapify(int[] A, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int smallest = l;
        if (l <= heapSize && A[l] < A[i]) {
            smallest = l;
        } else {
            smallest = i;
        }
        if (r <= heapSize && A[r] < A[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            int tmp = A[smallest];
            A[smallest] = A[i];
            A[i] = tmp;
            minHeapify(A, smallest, heapSize);
        }
    }

    /**
     * 6.2-5 : MAX-HEAPIFY-ITERATIVE
     *
     * @param A        : the heap
     * @param i        : the index of the root of the heap
     * @param heapSize : the size of the heap
     */
    public static <T extends Comparable<? super T>> void maxHeapifyIterative(T[] A, int i, int heapSize) {
        int index = i;
        while(true) {
            int l = left(index);
            int r = right(index);
            int largest = l;
            if (l <= heapSize && (A[l].compareTo(A[index]) > 0)) {
                largest = l;
            } else {
                largest = index;
            }
            if (r <= heapSize && (A[r].compareTo(A[largest]) > 0)) {
                largest = r;
            }
            if (largest != i) {
                T tmp = A[largest];
                A[largest] = A[index];
                A[index] = tmp;
                index = largest;
            } else {
                break;
            }
        }
    }

    /**
     * 6.2-5 : MAX-HEAPIFY-ITERATIVE
     *
     * @param A        : the heap
     * @param i        : the index of the root of the heap
     * @param heapSize : the size of the heap
     */
    public static void maxHeapifyIterative(int[] A, int i, int heapSize) {
        int index = i;
        while(true) {
            int l = left(index);
            int r = right(index);
            int largest = l;
            if (l <= heapSize && A[l] > A[index]) {
                largest = l;
            } else {
                largest = index;
            }
            if (r <= heapSize && A[r] > A[largest]) {
                largest = r;
            }
            if (largest != i) {
                int tmp = A[largest];
                A[largest] = A[index];
                A[index] = tmp;
                index = largest;
            } else {
                break;
            }
        }

    }

}
